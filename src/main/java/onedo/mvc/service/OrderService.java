package onedo.mvc.service;

import java.util.List;

import onedo.mvc.dto.CartDTO;
import onedo.mvc.dto.OrdersDTO;
import onedo.mvc.dto.SalesDTO;

public interface OrderService {
	/**
	 * 주문저장
	 */
	void ordersInsert(OrdersDTO ordersDTO, CartDTO cartDTO) throws Exception;

	/**
	 * 주문목록가져오기
	 */
	List<SalesDTO> selectAll() throws Exception;
}
