package onedo.mvc.service;

import java.sql.SQLException;
import java.util.List;

import onedo.mvc.dto.QnaDTO;


public interface QnaService {
	
	/**
	 *  모든레코드 검색하는 메소드 호출
	 * */
    List<QnaDTO> selectAll() throws SQLException;
    
    /**
	 * paging처리
	 * */
    List<QnaDTO> selectAll(int pageNo) throws SQLException;
    
    /**
	   *  레코드 삽입하는 메소드 호출
	   * */
	  void insert(QnaDTO qnaDTO) throws SQLException;
	 
	  
	  /**
	   * 모델번호에 해당하는 레코드 검색하는 메소드 호출
	   * @param : boolean flag - 조회수 증가 여부를 판별하는 매개변수임(true이면 조회수증가 / false이면 조회수 증가 안함)
	   * */
	  QnaDTO selectByQnaCode(int qnaNo)throws SQLException;
		 
		 
	 /**
	   *  모델번호에 해당하는 레코드 삭제 메소드 호출
	   * */
	    void delete(int qnaNo,String qnaPwd ,String path) throws SQLException;
	  
	  
	  /**
	   *  모델번호에 해당하는 레코드 수정  메소드 호출
	   * */
	   void update(QnaDTO qnaDTO) throws SQLException;

	
}
