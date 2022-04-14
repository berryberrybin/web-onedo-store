package onedo.mvc.dao;

import java.sql.SQLException;
import java.util.List;

import onedo.mvc.dto.GoodsDTO;


public interface GoodsDAO {
	
	/**
	 * 상품 전체 검색
	 */
	List<GoodsDTO> selectAll() throws SQLException;
	
	/**
	 * 상품 전체 검색(페이지처리)
	 */
	List<GoodsDTO> getBoardList(int pageNo) throws SQLException;

	/**
	 * 상품코드에 해당하는 상품검색
	 */
	GoodsDTO selectBygoodsCode(int goodsCode) throws SQLException;

	/**
	 * 조회수를 증가하는 기능 update Goods set goods_view = goods_view + 1 where goods_code=?
	 */
	int increamentByReadgoodsCode(int goodsCode) throws SQLException;

	/**
	 * 상품등록
	 * @return : 1-삽입성공 , 0 - 삽입실패
	 */
	int insert(GoodsDTO goodsDTO) throws SQLException;

	/**
	 * 상품코드에 해당하는 레코드 삭제
	 * 
	 * @return : 1-삭제성공 , 0 - 삭제실패
	 */
	int delete(int goodsCode, String password) throws SQLException;

	/**
	 * 상품코드에 해당하는 레코드 수정
	 * 
	 * @return : 1-수정성공 , 0 - 수정실패
	 */
	int update(GoodsDTO goodsDTO) throws SQLException;

	/**
	 * 상품 정렬하기
	 * */
	

}
