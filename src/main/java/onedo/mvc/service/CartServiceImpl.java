package onedo.mvc.service;

import java.util.HashMap;
import java.util.Map;

import onedo.mvc.dto.CartDTO;
import onedo.mvc.dto.CartItemDTO;
import onedo.mvc.dto.GoodsDTO;

public class CartServiceImpl implements CartService {

	//싱글턴 패턴 
	private static CartService instance = new CartServiceImpl();
	private Map<String, CartDTO> cartMap = new HashMap<>();

	private CartServiceImpl() { }
	
	public static CartService getInstance() {
		return instance;
	}
	
	@Override
	public CartDTO getCart(String userId) {
		
		if(!cartMap.containsKey(userId)) {
			cartMap.put(userId, new CartDTO(userId));
		}
		return cartMap.get(userId);
	}
	
	@Override
	public void insert(CartDTO cart, GoodsDTO goods, int amount) {
		CartItemDTO cartItem = new CartItemDTO(goods, amount);

		// 상세주문페이지에서 특정 물건을 장바구니에 담을때 이미 있는 품목이면 수량 누적
		if (cart.getCartItemList().contains(cartItem)) { 
			// cartItem과 GoodsItem은 내가 정의한 객체이므로 hasCode() 및 equals()를 재정의 해야 함  
			int i = cart.getCartItemList().indexOf(cartItem);
			int originAmount = cart.getCartItemList().get(i).getAmount();
			cart.getCartItemList().get(i).setAmount(originAmount + amount);
		} else {
			cart.addCartItem(cartItem);
		}

	}
	
	

}
