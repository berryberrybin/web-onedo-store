package onedo.mvc.service;

import java.sql.SQLException;
import java.util.List;

import onedo.mvc.dto.NoticeDTO;
import onedo.mvc.dto.ReviewDTO;

public interface NoticeService {
	/**
	 *  모든레코드 검색하는 메소드 호출
	 * */
    List<NoticeDTO> selectAll() throws SQLException;
    
    /**
	 * paging처리
	 * */
    List<NoticeDTO> selectAll(int pageNo) throws SQLException;
    
    /**
	   *  레코드 삽입하는 메소드 호출
	   * */
	  void insert(NoticeDTO noticeDTO) throws SQLException;
	 
	  
	  /**
	   * 모델번호에 해당하는 레코드 검색하는 메소드 호출
	   * @param : boolean flag - 조회수 증가 여부를 판별하는 매개변수임(true이면 조회수증가 / false이면 조회수 증가 안함)
	   * */
	  NoticeDTO selectByNoticeCode(int noticeNo)throws SQLException;
		 
		 
	 /**
	   *  모델번호에 해당하는 레코드 삭제 메소드 호출
	   * */
	    void delete(int noticeNo,String path) throws SQLException;
	  
	  
	  /**
	   *  모델번호에 해당하는 레코드 수정  메소드 호출
	   * */
	   void update(NoticeDTO noticeDTO) throws SQLException;
}
