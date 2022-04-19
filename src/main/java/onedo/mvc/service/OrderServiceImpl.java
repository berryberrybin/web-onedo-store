package onedo.mvc.service;

import onedo.mvc.dao.OrdersDAO;
import onedo.mvc.dao.OrdersDAOImpl;
import onedo.mvc.dto.OrdersDTO;
import onedo.mvc.exception.AuthenticationException;

public class OrderServiceImpl implements OrderService {
	private OrdersDAO ordersDAO = new OrdersDAOImpl(); 
	@Override
	public void orders(OrdersDTO ordersDTO) throws Exception {
		int result = ordersDAO.orders(ordersDTO);
		if(result==0) {
			throw new AuthenticationException("결제에 실패했습니다.");
		}

	}

}
