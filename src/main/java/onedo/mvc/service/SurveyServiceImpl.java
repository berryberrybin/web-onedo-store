package onedo.mvc.service;

import java.sql.SQLException;
import java.util.List;

import onedo.mvc.dao.SurveyDAO;
import onedo.mvc.dao.SurveyDAOImpl;
import onedo.mvc.dto.GoodsAttrDTO;

public class SurveyServiceImpl implements SurveyService {
	private SurveyDAO surveyDao = new SurveyDAOImpl();

	@Override
	public List<GoodsAttrDTO> survey(int sour, int body, int sweet, int aroma) throws SQLException {
		List<GoodsAttrDTO> list = surveyDao.survey(sour, body, sweet, aroma);
		return list;
	}
	
	
	
}
