package onedo.mvc.dao;

import java.util.List;

import onedo.mvc.dto.CartDTO;
import onedo.mvc.dto.OrdersDTO;
import onedo.mvc.dto.SalesDTO;

public interface OrdersDAO {
	/**
	 * 주문저장
	 */
	int ordersInsert(OrdersDTO ordersDTO, CartDTO cartDTO) throws Exception;
	
	/**
	 * 주문목록가져오기
	 */
	List<SalesDTO> selectAll() throws Exception;
	
}
