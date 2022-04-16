package onedo.mvc.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import onedo.mvc.dto.CartDTO;
import onedo.mvc.dto.CartItemDTO;
import onedo.mvc.dto.GoodsDTO;
import onedo.mvc.service.CartService;
import onedo.mvc.service.CartServiceImpl;
import onedo.mvc.service.GoodsService;
import onedo.mvc.service.GoodsServiceImpl;

//@WebServlet("/cart")
public class CartController implements Controller {

	private GoodsService goodsService = new GoodsServiceImpl();
	private CartService cartService = new CartServiceImpl();

	private Map<String, CartDTO> cartMap = new HashMap<>();

	/**
	 * 장바구니에 물건 담기
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView insert(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String userId = request.getParameter("userId");
		String goodsCode = request.getParameter("goodsCode");
		GoodsDTO goods = goodsService.selectByGoodsCode(goodsCode, false);
		int amount = Integer.parseInt(request.getParameter("amount"));

		CartDTO cart = null;

		if (cartMap.containsKey(userId)) {
			cart = cartMap.get(userId);
		} else {
			cart = new CartDTO(userId);
			cartMap.put(userId, cart);
		}

		cartService.insert(cart, goods, amount);

		return new ModelAndView("cart.jsp", true); // 원래의 장바구니넣기한 상세페이지 머물러있어야 함!!
	}

	/**
	 * 장바구니에 담긴 상품 중 선택한 상품 장바구니에서 삭제 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	
	public ModelAndView delete(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String userId = request.getParameter("userId");
		CartDTO cart = cartMap.get(userId);
		List<CartItemDTO> cartItemList = cart.getCartItemList();
		int goodsCode = Integer.parseInt(request.getParameter("goodsCode"));
		
		cartItemList = cartItemList.stream()
		.filter(cartItem -> !(goodsCode==cartItem.getGoods().getGoodsCode()))
		.collect(Collectors.toList());
		
		cart.setCartItemList(cartItemList);
	
		request.setAttribute("cartItemList", cartItemList);
		checkTotalPrice(request);

		return new ModelAndView("cart.jsp");

	}

	
	/**
	 * 장바구니 조회
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView select(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String userId = request.getParameter("userId");

		CartDTO cart = cartMap.get(userId);

		if (cart == null) {
			// " 장바구니가 비어있습니다"
			request.setAttribute("cartItemList", new ArrayList<>());
		} else {
			List<CartItemDTO> cartItemList = cart.getCartItemList();
			request.setAttribute("cartItemList", cartItemList); // model에 데이터를 담아 보내는 역할
			
		}

		checkTotalPrice(request);

		return new ModelAndView("cart.jsp");
	}

	/**
	 * 결제금액 및 배송비 체크
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	public void checkTotalPrice(HttpServletRequest request) throws Exception {

		String userId = request.getParameter("userId");
		if (!cartMap.containsKey(userId)) {
			request.setAttribute("totalItemPrice", 0);
			request.setAttribute("deliveryPrice", 0);
			request.setAttribute("paymentPrice", 0);
			return;
		}
		List<CartItemDTO> cartItemList = cartMap.get(userId).getCartItemList();
		int sumTotalItemPrice = cartItemList.stream().mapToInt(cartItem -> cartItem.getTotalPrice()).sum();
		int deliveryPrice = sumTotalItemPrice > 50000 ? 0 : 3000;
		request.setAttribute("totalItemPrice", sumTotalItemPrice);
		request.setAttribute("deliveryPrice", deliveryPrice);
		request.setAttribute("paymentPrice", (sumTotalItemPrice - deliveryPrice));
	}

	public ModelAndView increaseAmount(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String userId = request.getParameter("userId");
		String goodsCode = request.getParameter("goodsCode");

		List<CartItemDTO> cartItemList = cartMap.get(userId).getCartItemList();

		for (CartItemDTO cartItem : cartItemList) {
			if (cartItem.getGoods().getGoodsCode() == Integer.parseInt(goodsCode)) {
				int originAmount = cartItem.getAmount();
				cartItem.setAmount(++originAmount);
			}

		}
		request.setAttribute("cartItemList", cartItemList);
		checkTotalPrice(request);

		return new ModelAndView("cart.jsp");
	}

	public ModelAndView decreaseAmount(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String userId = request.getParameter("userId");
		String goodsCode = request.getParameter("goodsCode");

		List<CartItemDTO> cartItemList = cartMap.get(userId).getCartItemList();

		for (CartItemDTO cartItem : cartItemList) {
			if (cartItem.getGoods().getGoodsCode() == Integer.parseInt(goodsCode)) {
				int originAmount = cartItem.getAmount();
				if(originAmount>0) {
					cartItem.setAmount(--originAmount);
				}else {
					cartItem.setAmount(0);
				}
			}

		}
		request.setAttribute("cartItemList", cartItemList);
		checkTotalPrice(request);

		return new ModelAndView("cart.jsp");
	}

	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		return null;
	}
}
