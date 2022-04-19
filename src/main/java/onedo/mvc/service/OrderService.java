package onedo.mvc.service;

import onedo.mvc.dto.OrdersDTO;

public interface OrderService {
	/**
	 * 주문저장
	 */
	void orders(OrdersDTO ordersDTO) throws Exception;

}
