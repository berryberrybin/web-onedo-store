package onedo.mvc.service;

import java.sql.SQLException;
import java.util.List;

import onedo.mvc.dto.GoodsAttrDTO;

public interface SurveyService {
	/**
	 * 추천메소드 호출
	 */
	List<GoodsAttrDTO> survey(int sour, int body, int sweet, int aroma) throws SQLException;
}
