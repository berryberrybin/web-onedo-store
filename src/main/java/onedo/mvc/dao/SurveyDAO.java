package onedo.mvc.dao;

import java.sql.SQLException;
import java.util.List;

import onedo.mvc.dto.GoodsAttrDTO;

public interface SurveyDAO {
	/**
	 * 설문조사
	 */
	List<GoodsAttrDTO> survey(int sour, int body, int sweet, int aroma) throws SQLException;
}
