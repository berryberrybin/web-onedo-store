package onedo.mvc.service;

import java.io.File;
import java.sql.SQLException;
import java.util.List;

import onedo.mvc.dao.ReviewDAO;
import onedo.mvc.dao.ReviewDAOImpl;
import onedo.mvc.dto.ReviewDTO;

public class ReviewServiceImpl implements ReviewService {
	private ReviewDAO rdao = new ReviewDAOImpl();
	
	@Override
	public List<ReviewDTO> selectAll() throws SQLException {
		List<ReviewDTO> list = rdao.selectAll();
		
		return list;
	}

	@Override
	public List<ReviewDTO> selectAll(int pageNo) throws SQLException {
		List<ReviewDTO> list = rdao.getBoardList(pageNo);
				
		return list;
	}

	@Override
	public void insert(ReviewDTO reviewDTO) throws SQLException {
		int result = rdao.insert(reviewDTO);
		if(result==0)throw new SQLException("등록되지 않았습니다.");

	}

	@Override
	public ReviewDTO selectByGoodsCode(int goodsCode) throws SQLException {
		ReviewDTO rdto = rdao.selectByGoodsCode(goodsCode);
		if(rdto==null) {
			throw new SQLException("상세보기 오류 발생했습니다.");
		}
		
		return rdto;
	}

	@Override
	public void delete(int reviewNO,String path) throws SQLException {
		ReviewDTO riwDB =  rdao.selectByGoodsCode(reviewNO);
		if(rdao.delete(reviewNO)==0) {
			throw new SQLException(reviewNO+"게시물을 삭제할수 없습니다.");
		}
		
		if(riwDB.getFname()!=null) {
			new File(path+"/"+riwDB.getFname()).delete();//파일삭제
		}
	}

	@Override
	public void update(ReviewDTO reviewDTO) throws SQLException {
		
		if(rdao.update(reviewDTO)==0) {
			throw new SQLException("수정되지 않았습니다.");
		}
	}

}
