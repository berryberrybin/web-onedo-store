package onedo.mvc.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import onedo.mvc.dto.CartDTO;
import onedo.mvc.dto.CartItemDTO;
import onedo.mvc.dto.UserDTO;
import onedo.mvc.dto.OrdersDTO;
import onedo.mvc.service.CartService;
import onedo.mvc.service.CartServiceImpl;
import onedo.mvc.service.OrderService;
import onedo.mvc.service.OrderServiceImpl;

public class OrdersController implements Controller {
	private OrderService orderService = new OrderServiceImpl();
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * 결제저장
	 */
	public ModelAndView orders(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		HttpSession session = request.getSession();
		UserDTO dbDTO = (UserDTO)session.getAttribute("loginUser");
		
		String userId = dbDTO.getUserId();
		System.out.println(userId);
		
		CartService cartService = CartServiceImpl.getInstance();
		CartDTO cartDto =cartService.getCart(userId);
		
		List<CartItemDTO> cartList = cartDto.getCartItemList();
        System.out.println("cartList : " + cartList.get(0).getGoods().getGoodsName());
        String orderCode = request.getParameter("orderCode");
        String orderPrice = request.getParameter("orderPrice");
        String userAddr = request.getParameter("userAddr");
        String userPhone = request.getParameter("userPhone");
		System.out.println(orderCode + orderPrice + userAddr + userPhone);
		
		orderService.orders(new OrdersDTO(Integer.parseInt(orderCode), userId, userAddr, userPhone, Integer.parseInt(orderPrice))); 
		
		
		
		
		ModelAndView mv = new ModelAndView("orders/ordersTest.jsp");
		
		return mv;
	}

}
