package onedo.mvc.service;

import java.sql.SQLException;
import java.util.List;

import onedo.mvc.dao.GoodsDAO;
import onedo.mvc.dao.GoodsDAOImpl;
import onedo.mvc.dto.GoodsDTO;

public class GoodsServiceImpl implements GoodsService {
	private GoodsDAO goodsDAO = new GoodsDAOImpl();
	
	/**
	 * 상품전체검색
	 * */
	@Override
	public List<GoodsDTO> selectAll() throws SQLException {
        List<GoodsDTO> list = goodsDAO.selectAll();
        
		return list;
	}
	
	/**
	 * 상품등록
	 * */
	@Override
	public int insert(GoodsDTO goodsDTO) throws SQLException {
		int result = goodsDAO.insert(goodsDTO);
		if (result == 0) throw new SQLException("등록 실패");
		return result;
	}

	/**
	 * 상품검색,상세보기
	 * */
	@Override
	public GoodsDTO selectByGoodsCode(String goodsCode, boolean flag) throws SQLException {
		GoodsDTO goodsDTO = goodsDAO.selectByGoodsCode(Integer.parseInt(goodsCode));
		
		if(flag) {
			//조회수 증가
			goodsDAO.increamentGoodsView(Integer.parseInt(goodsCode));
		}
		
		return goodsDTO;
	}
	
	/**
	 *  상품이름이나 타입으로 상품검색
	 * */
	public List<GoodsDTO> selectMultipleGoods(String searchField, String searchValue, int pageNo) throws SQLException {
		List<GoodsDTO> list = goodsDAO.selectMultipleGoods(searchField, searchValue, pageNo);
		System.out.println("service의 pageNo = " + pageNo);
		return list;
	}

	/**
	 * 상품삭제 --품절이면 안보이게
	 * */
	@Override
	public void delete(String goodsCode, String password, String path) throws SQLException {
		// TODO Auto-generated method stub

	}

	/**
	 * 상품수정
	 * */
	@Override
	public void update(GoodsDTO goodsDTO) throws SQLException {
		int result = goodsDAO.update(goodsDTO);
		if (result == 0) throw new SQLException("수정 실패");

	}
	
	
}
