package onedo.mvc.dto;

import java.util.ArrayList;
import java.util.List;

public class CartDTO {

	private String userId;
	private List<CartItemDTO> cartItemList = new ArrayList<>();
	
	
	public void addCartItem(CartItemDTO cartItem) {
		cartItemList.add(cartItem);	}
	
	public CartDTO(String userId) {
		this.userId = userId;
	}
	
	
	
	public String getUserId() {
		return userId;
	}
	
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public List<CartItemDTO> getCartItemList() {
		return cartItemList;
	}
	

		
}
