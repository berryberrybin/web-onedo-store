package onedo.mvc.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import onedo.mvc.dto.CartDTO;
import onedo.mvc.dto.GoodsDTO;
import onedo.mvc.service.CartService;
import onedo.mvc.service.CartServiceImpl;
import onedo.mvc.service.GoodsService;
import onedo.mvc.service.GoodsServiceImpl;


//@WebServlet("/cart")
public class CartController implements Controller{
	
	private GoodsService goodsService = new GoodsServiceImpl();
	private CartService cartService = new CartServiceImpl();

	private Map<String, CartDTO> cartMap = new HashMap<>();

	public ModelAndView insert(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		
		String userId = request.getParameter("userId");
		String goodsCode = request.getParameter("goodsCode");
		
		GoodsDTO goods = goodsService.selectByGoodsCode(goodsCode, false);
		
		int amount = Integer.parseInt(request.getParameter("amount"));

		CartDTO cart = null;
		
		if(cartMap.containsKey(userId)) {
			cart = cartMap.get(userId);
		}else {
			cart = new CartDTO(userId);
			cartMap.put(userId, cart);
		}
		
		cartService.insert(cart, goods, amount);
		
		
		return new ModelAndView("cart.html", true); // 원래의 장바구니넣기한 상세페이지 머물러있어야 함!!
	}
	
	

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		return null;
	}
}
