package onedo.mvc.dto;

public class OrderLineDTO {
	private int orderLineCode;
	private int orderCode;
	private int goodsCode;
	private int qty;
	
	public OrderLineDTO() {}

	public OrderLineDTO(int orderLineCode, int orderCode, int goodsCode, int qty) {
		super();
		this.orderLineCode = orderLineCode;
		this.orderCode = orderCode;
		this.goodsCode = goodsCode;
		this.qty = qty;
	}

	public int getOrderLineCode() {
		return orderLineCode;
	}

	public void setOrderLineCode(int orderLineCode) {
		this.orderLineCode = orderLineCode;
	}

	public int getOrderCode() {
		return orderCode;
	}

	public void setOrderCode(int orderCode) {
		this.orderCode = orderCode;
	}

	public int getGoodsCode() {
		return goodsCode;
	}

	public void setGoodsCode(int goodsCode) {
		this.goodsCode = goodsCode;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}
	
	
}
