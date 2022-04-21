package onedo.mvc.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import onedo.mvc.dto.CartDTO;
import onedo.mvc.dto.CartItemDTO;
import onedo.mvc.dto.GoodsDTO;
import onedo.mvc.dto.UserDTO;
import onedo.mvc.exception.AuthenticationException;
import onedo.mvc.service.CartService;
import onedo.mvc.service.CartServiceImpl;
import onedo.mvc.service.GoodsService;
import onedo.mvc.service.GoodsServiceImpl;

//@WebServlet("/cart")
public class CartController implements Controller {

	private GoodsService goodsService = new GoodsServiceImpl();
	private CartService cartService = CartServiceImpl.getInstance();
	
	public List<CartItemDTO> findCartById(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String userId = request.getParameter("userId");
		CartDTO cart =cartService.getCart(userId);
		List<CartItemDTO> cartItemList = cart.getCartItemList();
		
		return cartItemList;
	}
	
	/**
	 * 장바구니에 물건 담기
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView insert(HttpServletRequest request, HttpServletResponse response) throws Exception {

		
		HttpSession session = request.getSession();
		String userId = null;
		
		if(session.getAttribute("loginUser")==null) {
			//인증 안되었음
			throw new AuthenticationException("로그인 후 상품을 장바구니에 담을 수 있습니다.");
		}else {
		UserDTO dbDTO = (UserDTO)session.getAttribute("loginUser");
		
		userId = dbDTO.getUserId();
		
		
		String goodsCode = request.getParameter("goodsCode");
		GoodsDTO goods = goodsService.selectByGoodsCode(goodsCode, false);
		int goodsQuantity = Integer.parseInt(request.getParameter("quantity"));
		int amount = goodsQuantity;

		CartDTO cart = cartService.getCart(userId);
		cartService.insert(cart, goods, amount);
		}
		return new ModelAndView("front?key=cart&methodName=select&userId="+userId, true); // 원래의 장바구니넣기한 상세페이지 머물러있어야 함!!
	}

	/**
	 * 장바구니에 담긴 상품 중 선택한 상품 장바구니에서 삭제
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */

	public ModelAndView delete(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		UserDTO dbDTO = (UserDTO)session.getAttribute("loginUser");
		
		String userId = dbDTO.getUserId();
		CartDTO cart = cartService.getCart(userId);
		List<CartItemDTO> cartItemList = cart.getCartItemList();
		
		int goodsCode = Integer.parseInt(request.getParameter("goodsCode"));

		cartItemList = cartItemList.stream().filter(cartItem -> !(goodsCode == cartItem.getGoods().getGoodsCode()))
				.collect(Collectors.toList());

		cart.setCartItemList(cartItemList);

		return new ModelAndView("front?key=cart&methodName=select&userId="+userId, true);

	}

	public ModelAndView deleteAll(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		UserDTO dbDTO = (UserDTO)session.getAttribute("loginUser");
		
		String userId = dbDTO.getUserId();
		CartDTO cart = cartService.getCart(userId);
		List<CartItemDTO> cartItemList = cart.getCartItemList();

		cartItemList.clear();
		cart.setCartItemList(cartItemList);

		return new ModelAndView("front?key=cart&methodName=select&userId="+userId, true);

	}

	/**
	 * 장바구니 조회
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ModelAndView select(HttpServletRequest request, HttpServletResponse response) throws Exception, AuthenticationException {
		HttpSession session = request.getSession();
		
		if(session.getAttribute("loginUser")==null) {
			//인증 안되었음
			throw new AuthenticationException("로그인 후 장바구니 조회가 가능합니다.");
		}else {
			UserDTO dbDTO = (UserDTO)session.getAttribute("loginUser");

			String userId = dbDTO.getUserId();

			CartDTO cart =cartService.getCart(userId);

			if (cart == null) {
				// " 장바구니가 비어있습니다"
				request.setAttribute("cartItemList", new ArrayList<>());
			} else {
				List<CartItemDTO> cartItemList = cart.getCartItemList();
				request.setAttribute("cartItemList", cartItemList); // model에 데이터를 담아 보내는 역할

			}

			checkTotalPrice(request);
		}
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

	public ModelAndView increaseAmount(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		UserDTO dbDTO = (UserDTO)session.getAttribute("loginUser");
		
		String userId = dbDTO.getUserId();
		
		String goodsCode = request.getParameter("goodsCode");

		List<CartItemDTO> cartItemList = cartService.getCart(userId).getCartItemList();

		for (CartItemDTO cartItem : cartItemList) {
			if (cartItem.getGoods().getGoodsCode() == Integer.parseInt(goodsCode)) {
				int originAmount = cartItem.getAmount();
				cartItem.setAmount(++originAmount);
			}
		}

		return new ModelAndView("front?key=cart&methodName=select&userId="+userId, true);
	}

	public ModelAndView decreaseAmount(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		UserDTO dbDTO = (UserDTO)session.getAttribute("loginUser");
		
		String userId = dbDTO.getUserId();
		
		String goodsCode = request.getParameter("goodsCode");

		List<CartItemDTO> cartItemList = cartService.getCart(userId).getCartItemList();

		for (CartItemDTO cartItem : cartItemList) {
			if (cartItem.getGoods().getGoodsCode() == Integer.parseInt(goodsCode)) {
				int originAmount = cartItem.getAmount();
				if (originAmount > 1) {
					cartItem.setAmount(--originAmount);
				}
				else {
					cartItem.setAmount(1);
				}
			}

		}

		return new ModelAndView("front?key=cart&methodName=select&userId="+userId, true);
	}

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		return null;
	}
}
