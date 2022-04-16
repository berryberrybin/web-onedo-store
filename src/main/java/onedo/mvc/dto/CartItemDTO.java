package onedo.mvc.dto;

import java.util.Objects;

public class CartItemDTO {
	private GoodsDTO goods;
	private int amount;
	private int totalPrice;
	
	public CartItemDTO(GoodsDTO goods, int amount) {
		super();
		this.goods = goods;
		this.amount = amount;
		totalPrice = goods.getGoodsPrice()*amount;
	}
	
	
	public int getTotalPrice() {
		return totalPrice;
	}

	public GoodsDTO getGoods() {
		return goods;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
		totalPrice = goods.getGoodsPrice()*amount;
	}

	@Override
	public String toString() {
		return "CartItemDTO [goods=" + goods + ", amount=" + amount + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(goods);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CartItemDTO other = (CartItemDTO) obj;
		return Objects.equals(goods, other.goods);
	}
	
}
