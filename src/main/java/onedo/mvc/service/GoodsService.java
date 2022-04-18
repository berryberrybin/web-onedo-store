package onedo.mvc.service;

import java.sql.SQLException;
import java.util.List;

import onedo.mvc.dto.GoodsDTO;

public interface GoodsService {
	
	/**
	 * GoodsDAOImpl의 모든레코드 검색하는 메소드 호출
	 */
	List<GoodsDTO> selectAll() throws SQLException;

	/**
	 * GoodsDAOImpl의 레코드 삽입하는 메소드 호출
	 */
	int insert(GoodsDTO goodsDTO) throws SQLException;

	/**
	 * GoodsDAOImpl의 상품코드에 해당하는 레코드 검색하는 메소드 호출
	 * 
	 * @param : boolean flag - 조회수 증가 여부를 판별하는 매개변수임(true이면 조회수증가 / false이면 조회수 증가
	 *          안함) : 수정, 수정완료로 상세보기를 할 때 조회수가 늘어날 수 있기 때문에 판별 필요. 사용자가 상세보기 누를 때만
	 *          작동을 해야 함
	 */
	GoodsDTO selectByGoodsCode(String goodsCode, boolean flag) throws SQLException;

	/**
	 * GoodsDAOImpl의 상품코드에 해당하는 레코드 삭제 메소드 호출 path를 넣은 이유 : 레코드가 삭제되면 레코드의 첨부된
	 * 파일도 없애려고 save파일 경로 찾기
	 */
	void delete(String goodsCode, String password, String path) throws SQLException;

	/**
	 * GoodsDAOImpl의 상품코드에 해당하는 레코드 수정 메소드 호출
	 */
	void update(GoodsDTO goodsDTO) throws SQLException;

	/**
	 *  상품이름이나 타입으로 상품검색
	 * */
	List<GoodsDTO> selectMultipleGoods(String searchField, String searchValue, int pageNo) throws SQLException;
}
