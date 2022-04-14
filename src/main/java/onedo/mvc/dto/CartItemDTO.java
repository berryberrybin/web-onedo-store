package onedo.mvc.dto;

import java.util.Objects;

public class CartItemDTO {
	private GoodsDTO goods;
	private int amount;
	
	public CartItemDTO(GoodsDTO goods, int amount) {
		super();
		this.goods = goods;
		this.amount = amount;
	}
	
	public GoodsDTO getGoods() {
		return goods;
	}
	public void setGoods(GoodsDTO goods) {
		this.goods = goods;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
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
