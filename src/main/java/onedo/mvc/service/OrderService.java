package onedo.mvc.service;

import onedo.mvc.dto.CartDTO;
import onedo.mvc.dto.OrdersDTO;

public interface OrderService {
	/**
	 * 주문저장
	 */
	void ordersInsert(OrdersDTO ordersDTO, CartDTO cartDTO) throws Exception;

}
