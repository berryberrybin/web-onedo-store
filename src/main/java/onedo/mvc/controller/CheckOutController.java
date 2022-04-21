package onedo.mvc.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import onedo.mvc.dto.CartDTO;
import onedo.mvc.dto.CartItemDTO;
import onedo.mvc.dto.UserDTO;
import onedo.mvc.service.CartService;
import onedo.mvc.service.CartServiceImpl;
import onedo.mvc.service.GoodsService;
import onedo.mvc.service.GoodsServiceImpl;

//@WebServlet("/cart")
public class CheckOutController implements Controller {

	private GoodsService goodsService = new GoodsServiceImpl();
	private CartService cartService = CartServiceImpl.getInstance();

	/**
	 * checkout조회
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView select(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		UserDTO dbDTO = (UserDTO) session.getAttribute("loginUser");

		session.setAttribute("userId", dbDTO.getUserId());
		session.setAttribute("userName", dbDTO.getUserName());
		session.setAttribute("userPhone", dbDTO.getUserPhone());
		session.setAttribute("userAddr", dbDTO.getUserAddr());
		
	
		String userId = dbDTO.getUserId();
		CartDTO cart = cartService.getCart(userId);

		if (cart == null) {
			// " 장바구니가 비어있습니다"
			request.setAttribute("cartItemList", new ArrayList<>());
		} else {
			List<CartItemDTO> cartItemList = cart.getCartItemList();
			request.setAttribute("cartItemList", cartItemList); // model에 데이터를 담아 보내는 역할

		}

		checkTotalPrice(request);

		return new ModelAndView("checkout.jsp");
	}

	/**
	 * 결제금액 및 배송비 체크
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	public void checkTotalPrice(HttpServletRequest request) throws Exception {
				HttpSession session = request.getSession();
		UserDTO dbDTO = (UserDTO)session.getAttribute("loginUser");
		
		String userId = dbDTO.getUserId();
		
		List<CartItemDTO> cartItemList = cartService.getCart(userId).getCartItemList();
		int sumTotalItemPrice = cartItemList.stream().mapToInt(cartItem -> cartItem.getTotalPrice()).sum();
		
		
		int deliveryPrice = (sumTotalItemPrice > 0 && sumTotalItemPrice < 50000) ? 3000 : 0;
		
		int paymentPrice = sumTotalItemPrice + deliveryPrice;
		
		request.setAttribute("totalItemPrice", sumTotalItemPrice);
		request.setAttribute("deliveryPrice", deliveryPrice); 
		request.setAttribute("paymentPrice", paymentPrice);
	}

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		return null;
	}
}
