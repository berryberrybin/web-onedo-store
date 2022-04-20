package onedo.mvc.dao;

import java.sql.SQLException;
import java.util.List;

import onedo.mvc.dto.GoodsAttrDTO;
import onedo.mvc.dto.GoodsDTO;

public interface SurveyDAO {
	/**
	 * 설문조사
	 */
	List<GoodsDTO> survey(GoodsAttrDTO goodsAttrDTO) throws SQLException;
}
