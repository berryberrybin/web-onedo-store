package onedo.mvc.service;

import java.sql.SQLException;
import java.util.List;

import onedo.mvc.dto.ReviewDTO;

public interface ReviewService {
	/**
	 * ElectronicsDAOImpl의 모든레코드 검색하는 메소드 호출
	 * */
    List<ReviewDTO> selectAll() throws SQLException;
    
    /**
	 * paging처리
	 * */
    List<ReviewDTO> selectAll(int pageNo) throws SQLException;
	  
	  /**
	   * ElectronicsDAOImpl의 레코드 삽입하는 메소드 호출
	   * */
	  void insert(ReviewDTO reviewDTO) throws SQLException;
	 
	  
	  /**
	   * ElectronicsDAOImpl의 모델번호에 해당하는 레코드 검색하는 메소드 호출
	   * @param : boolean flag - 조회수 증가 여부를 판별하는 매개변수임(true이면 조회수증가 / false이면 조회수 증가 안함)
	   * */
	  ReviewDTO selectByGoodsCode(int goodsCode)throws SQLException;
		 
		 
	 /**
	   * ElectronicsDAOImpl의 모델번호에 해당하는 레코드 삭제 메소드 호출
	   * */
	    void delete(int reviewNO,String path) throws SQLException;
	  
	  
	  /**
	   * ElectronicsDAOImpl의 모델번호에 해당하는 레코드 수정  메소드 호출
	   * */
	   void update(ReviewDTO reviewDTO) throws SQLException;
}
