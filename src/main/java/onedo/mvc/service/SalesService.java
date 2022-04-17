package onedo.mvc.service;

import java.sql.SQLException;
import java.util.List;

import onedo.mvc.dto.SalesDTO;



public interface SalesService {
	
	List<SalesDTO> selectAll() throws SQLException;

	List<SalesDTO> selectGroupByGoodsCode() throws SQLException;
	List<SalesDTO> selectGroupByOrderDate() throws SQLException;
	
}
