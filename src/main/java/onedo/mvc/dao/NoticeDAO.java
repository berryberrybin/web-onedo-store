package onedo.mvc.dao;

import java.sql.SQLException;
import java.util.List;

import onedo.mvc.dto.NoticeDTO;


public interface NoticeDAO {
	
	
	  /**
	  * 레코드 전체 검색
	  * */
		List<NoticeDTO> selectAll() throws SQLException;
		 /**
		  * 레코드 전체 검색(페이지처리)
		  * */
		   List<NoticeDTO> getBoardList(int pageNo) throws SQLException;
		 /**
		  * 모델번호에 해당하는 레코드 검색
		  * */
		   NoticeDTO selectByNoticeCode(int noticeNo) throws SQLException;
		/**
		 * 레코드 삽입
		 * @return : 1-삽입성공 , 0 - 삽입실패
		 * */
		  int insert(NoticeDTO noticeDTO) throws SQLException;
		  
		  /**
		   * 글번호 에 해당하는 레코드 삭제
		   * @return : 1-삭제성공 , 0 - 삭제실패
		   * */
		  int delete(int noticeNo) throws SQLException;
		  
		  /**
		    * 모델번호에 해당하는 레코드 수정
		    * @return : 1-수정성공 , 0 - 수정실패
		    * */
		  int update(NoticeDTO noticeDTO) throws SQLException;
	  
}
