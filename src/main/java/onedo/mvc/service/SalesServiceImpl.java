package onedo.mvc.service;

import java.sql.SQLException;
import java.util.List;

import onedo.mvc.dao.SalesDAO;
import onedo.mvc.dao.SalesDAOImpl;
import onedo.mvc.dto.SalesDTO;

public class SalesServiceImpl implements SalesService{

	private SalesDAO salesDAO = new SalesDAOImpl();
	
	public List<SalesDTO> selectAll() throws SQLException {
		List<SalesDTO> salesList = salesDAO.selectAll();

		return salesList;
	}

	@Override
	public List<SalesDTO> selectGroupByGoodsCode() throws SQLException {
		List<SalesDTO> salesList = salesDAO.selectGroupByGoodsCode();
		return salesList;
	}

}
