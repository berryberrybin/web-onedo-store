package onedo.mvc.service;

import java.io.File;
import java.sql.SQLException;
import java.util.List;

import onedo.mvc.dao.NoticeDAO;
import onedo.mvc.dao.NoticeDAOImpl;
import onedo.mvc.dto.NoticeDTO;

public class NoticeServiceImpl implements NoticeService {
	private NoticeDAO ndao = new NoticeDAOImpl();
	
	@Override
	public List<NoticeDTO> selectAll() throws SQLException {
		List<NoticeDTO> list = ndao.selectAll();
		
		return list;
	}

	@Override
	public List<NoticeDTO> selectAll(int pageNo) throws SQLException {
		List<NoticeDTO> list = ndao.getBoardList(pageNo);
		
		return list;
	}

	@Override
	public void insert(NoticeDTO noticeDTO) throws SQLException {
		int result = ndao.insert(noticeDTO);
		if(result==0)throw new SQLException("등록되지 않았습니다.");

	}

	@Override
	public NoticeDTO selectByNoticeCode(int noticeNo) throws SQLException {
		NoticeDTO ndto = ndao.selectByNoticeCode(noticeNo);
		if(ndto==null) {
			throw new SQLException("상세보기 오류 발생했습니다.");
		}
		
		return ndto;
	}

	@Override
	public void delete(int noticeNo, String path) throws SQLException {
		NoticeDTO notDB = ndao.selectByNoticeCode(noticeNo);
		if(ndao.delete(noticeNo)==0) {
			throw new SQLException(noticeNo+"게시물을 삭제할수 없습니다.");
		}
		if(notDB.getFname()!=null) {
			new File(path+"/"+notDB.getFname()).delete();//파일삭제
		}
	}

	@Override
	public void update(NoticeDTO noticeDTO) throws SQLException {
		if(ndao.update(noticeDTO)==0) {
			throw new SQLException("수정되지 않았습니다.");
		}

	}

}
