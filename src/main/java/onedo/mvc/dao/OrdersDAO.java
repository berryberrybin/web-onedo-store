package onedo.mvc.dao;

import onedo.mvc.dto.CartDTO;
import onedo.mvc.dto.OrdersDTO;

public interface OrdersDAO {
	/**
	 * 주문저장
	 */
	int ordersInsert(OrdersDTO ordersDTO, CartDTO cartDTO) throws Exception;
	
	/**
	 * orderLine저장
	 */
	
}
