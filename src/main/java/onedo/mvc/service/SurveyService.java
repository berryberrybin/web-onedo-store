package onedo.mvc.service;

import java.sql.SQLException;
import java.util.List;

import onedo.mvc.dto.GoodsAttrDTO;
import onedo.mvc.dto.GoodsDTO;

public interface SurveyService {
	/**
	 * 추천메소드 호출
	 */
	List<GoodsDTO> survey(GoodsAttrDTO goodsAttrDTO) throws SQLException;
}
