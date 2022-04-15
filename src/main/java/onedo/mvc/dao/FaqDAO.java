package onedo.mvc.dao;

import java.sql.SQLException;
import java.util.List;

import onedo.mvc.dto.FaqDTO;

public interface FaqDAO {
	
	 /**
	  * 레코드 전체 검색
	  * */
		List<FaqDTO> selectAll() throws SQLException;
		 /**
		  * 레코드 전체 검색(페이지처리)
		  * */
		   List<FaqDTO> getBoardList(int pageNo) throws SQLException;
		 /**
		  * 모델번호에 해당하는 레코드 검색
		  * */
		   FaqDTO selectByFaqCode(int faqNo) throws SQLException;
		/**
		 * 레코드 삽입
		 * @return : 1-삽입성공 , 0 - 삽입실패
		 * */
		  int insert(FaqDTO faqDTO) throws SQLException;
		  
		  /**
		   * 글번호 에 해당하는 레코드 삭제
		   * @return : 1-삭제성공 , 0 - 삭제실패
		   * */
		  int delete(int faqNo) throws SQLException;
		  
		  /**
		    * 모델번호에 해당하는 레코드 수정
		    * @return : 1-수정성공 , 0 - 수정실패
		    * */
		  int update(FaqDTO faqDTO) throws SQLException;
	  
}
