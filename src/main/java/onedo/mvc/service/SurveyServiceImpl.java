package onedo.mvc.service;

import java.sql.SQLException;
import java.util.List;

import onedo.mvc.dao.SurveyDAO;
import onedo.mvc.dao.SurveyDAOImpl;
import onedo.mvc.dto.GoodsAttrDTO;
import onedo.mvc.dto.GoodsDTO;

public class SurveyServiceImpl implements SurveyService {
	private SurveyDAO surveyDao = new SurveyDAOImpl();

	@Override
	public List<GoodsDTO> survey(GoodsAttrDTO goodsAttrDTO) throws SQLException {
		List<GoodsDTO> list = surveyDao.survey(goodsAttrDTO);
		return list;
	}
	
	
	
}
