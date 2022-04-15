package onedo.mvc.service;

import java.io.File;
import java.sql.SQLException;
import java.util.List;

import onedo.mvc.dao.FaqDAO;
import onedo.mvc.dao.FaqDAOImpl;
import onedo.mvc.dto.FaqDTO;
import onedo.mvc.dto.ReviewDTO;

public class FaqServiceImpl implements FaqService {
	private FaqDAO fdao = new FaqDAOImpl();

	@Override
	public List<FaqDTO> selectAll() throws SQLException {
		List<FaqDTO> list = fdao.selectAll();
		
		return list;
	}

	@Override
	public List<FaqDTO> selectAll(int pageNo) throws SQLException {
		List<FaqDTO> list = fdao.getBoardList(pageNo);
		
		return list;
	}

	@Override
	public void insert(FaqDTO faqDTO) throws SQLException {
		int result = fdao.insert(faqDTO);
		if(result==0)throw new SQLException("등록되지 않았습니다.");
	}

	@Override
	public FaqDTO selectByFaqCode(int faqNo) throws SQLException {
		FaqDTO fdto = fdao.selectByFaqCode(faqNo);
		if(fdto==null) {
			throw new SQLException("상세보기 오류 발생했습니다.");
		}
		
		return fdto;
	}

	@Override
	public void delete(int faqNo,String path) throws SQLException {
		FaqDTO faqDB =  fdao.selectByFaqCode(faqNo);
		if(fdao.delete(faqNo)==0) {
			throw new SQLException(faqNo+"게시물을 삭제할수 없습니다.");
		}
		
		if(faqDB.getFname()!=null) {
			new File(path+"/"+faqDB.getFname()).delete();//파일삭제
		}

	}

	@Override
	public void update(FaqDTO faqDTO) throws SQLException {
		if(fdao.update(faqDTO)==0) {
			throw new SQLException("수정되지 않았습니다.");
		}
	}

}
