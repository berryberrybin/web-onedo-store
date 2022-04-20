package onedo.mvc.service;

import java.util.List;

import onedo.mvc.dao.OrdersDAO;
import onedo.mvc.dao.OrdersDAOImpl;
import onedo.mvc.dto.CartDTO;
import onedo.mvc.dto.CartItemDTO;
import onedo.mvc.dto.OrdersDTO;
import onedo.mvc.exception.AuthenticationException;

public class OrderServiceImpl implements OrderService {
	private OrdersDAO ordersDAO = new OrdersDAOImpl(); 
	@Override
	public void ordersInsert(OrdersDTO ordersDTO, CartDTO cartDTO) throws Exception {
		int result = ordersDAO.ordersInsert(ordersDTO, cartDTO);
		
		if(result==0) {
			throw new AuthenticationException("결제에 실패했습니다.");
		}

	}

}
