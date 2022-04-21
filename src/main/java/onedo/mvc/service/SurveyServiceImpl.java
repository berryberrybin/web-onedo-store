package onedo.mvc.service;

import java.sql.SQLException;
import java.util.List;

import onedo.mvc.dao.GoodsDAO;
import onedo.mvc.dao.GoodsDAOImpl;
import onedo.mvc.dao.SurveyDAO;
import onedo.mvc.dao.SurveyDAOImpl;
import onedo.mvc.dto.GoodsAttrDTO;
import onedo.mvc.dto.GoodsDTO;

public class SurveyServiceImpl implements SurveyService {
	private SurveyDAO surveyDao = new SurveyDAOImpl();
	private GoodsDAO goodsDAO = new GoodsDAOImpl();
	@Override
	public List<GoodsDTO> survey(GoodsAttrDTO goodsAttrDTO) throws SQLException {
		List<GoodsDTO> list = surveyDao.survey(goodsAttrDTO);
		if(list.isEmpty()) {
			list = goodsDAO.selectGoodsOrderBySalesRank();
		}
		return list;
	}
	
	
	
}
