package onedo.mvc.dao;

import java.sql.SQLException;
import java.util.List;

import onedo.mvc.dto.QnaDTO;
import onedo.mvc.dto.QnaReplyDTO;


public interface QnaDAO {

	  /**
	  * 레코드 전체 검색
	  * */
		List<QnaDTO> selectAll() throws SQLException;
		 /**
		  * 레코드 전체 검색(페이지처리)
		  * */
		   List<QnaDTO> getBoardList(int pageNo) throws SQLException;
		 /**
		  * 모델번호에 해당하는 레코드 검색
		  * */
		   QnaDTO selectByQnaCode(int qnaNo) throws SQLException;
		/**
		 * 레코드 삽입
		 * @return : 1-삽입성공 , 0 - 삽입실패
		 * */
		  int insert(QnaDTO qnaDTO) throws SQLException;
		  
		  /**
		   * 글번호 에 해당하는 레코드 삭제
		   * @return : 1-삭제성공 , 0 - 삭제실패
		   * */
		  int delete(int qnaNo,String password) throws SQLException;
		  
		  /**
		    * 모델번호에 해당하는 레코드 수정
		    * @return : 1-수정성공 , 0 - 수정실패
		    * */
		  int update(QnaDTO qnaDTO) throws SQLException;
		  
		  /**
		   * 해당하는 댓글정보가져오기
		   * */
		  List<QnaReplyDTO> selectRepliesByModelNum(String modelNum) throws SQLException;
	  
	
	  

}
