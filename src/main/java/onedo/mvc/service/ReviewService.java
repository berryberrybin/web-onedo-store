package onedo.mvc.service;

import java.sql.SQLException;
import java.util.List;

import onedo.mvc.dto.ReviewDTO;

public interface ReviewService {
	/**
	 *  모든레코드 검색하는 메소드 호출
	 * */
    List<ReviewDTO> selectAll() throws SQLException;
    
    /**
	 * paging처리
	 * */
    List<ReviewDTO> selectAll(int pageNo) throws SQLException;
	  
	  /**
	   *  레코드 삽입하는 메소드 호출
	   * */
	  void insert(ReviewDTO reviewDTO) throws SQLException;
	 
	  
	  /**
	   * 상품번호에 해당하는 상품후기 검색하는 메소드 호출
	   * */
	  List<ReviewDTO> selectByGoodsCode(int goodsCode)throws SQLException;
		 
		 
	 /**
	   *  모델번호에 해당하는 레코드 삭제 메소드 호출
	   * */
	    void delete(int reviewNO,String path) throws SQLException;
	  
	  
	  /**
	   *  모델번호에 해당하는 레코드 수정  메소드 호출
	   * */
	   void update(ReviewDTO reviewDTO) throws SQLException;
	   
	   /**
	    * 상세보기
	    * */
	   ReviewDTO selectByReviewCode(int reviewNO)throws SQLException;
}
