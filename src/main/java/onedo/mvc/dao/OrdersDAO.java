package onedo.mvc.dao;

import onedo.mvc.dto.OrdersDTO;

public interface OrdersDAO {
	/**
	 * 주문저장
	 */
	int orders(OrdersDTO ordersDTO) throws Exception;
}
