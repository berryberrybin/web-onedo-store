package onedo.mvc.dto;

public class SalesDTO {
	private String goodsName;
	private int goodsCode;
	private int goods_price;
	private int orderQuantity;
	private String userId;
	private String orderDate;
	private int orderPrice;

	public SalesDTO(int goodsCode, int goods_price, int orderQuantity, String userId, String orderDate,
			int orderPrice) {
		super();
		this.goodsCode = goodsCode;
		this.goods_price = goods_price;
		this.orderQuantity = orderQuantity;
		this.userId = userId;
		this.orderDate = orderDate;
		this.orderPrice = orderPrice;
	}
	
	
	
	

	public SalesDTO(String orderDate, int orderPrice) {
		super();
		this.orderDate = orderDate;
		this.orderPrice = orderPrice;
	}





	public SalesDTO(String goodsName, int goodsCode, int orderQuantity) {
		super();
		this.goodsName = goodsName;
		this.goodsCode = goodsCode;
		this.orderQuantity = orderQuantity;
	}





	public String getGoodsName() {
		return goodsName;
	}





	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}





	public int getGoodsCode() {
		return goodsCode;
	}

	public void setGoodsCode(int goodsCode) {
		this.goodsCode = goodsCode;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public int getOrderPrice() {
		return orderPrice;
	}

	public void setOrderPrice(int orderPrice) {
		this.orderPrice = orderPrice;
	}

	public int getOrderQuantity() {
		return orderQuantity;
	}

	public void setOrderQuantity(int orderQuantity) {
		this.orderQuantity = orderQuantity;
	}

	public int getGoods_price() {
		return goods_price;
	}

	public void setGoods_price(int goods_price) {
		this.goods_price = goods_price;
	}

}
