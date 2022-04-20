package onedo.mvc.dto;

public class SalesDTO {
	private int orderCode;
	private int orderLineCode;
	private String goodsName;
	private int goodsCode;
	private int goodsPrice;
	private int orderQuantity;
	private String userId;
	private String orderDate;
	private int orderPrice;

	public SalesDTO(int orderCode, int orderLineCode, String goodsName, int goodsPrice, int orderQuantity, String userId, String orderDate,
			int orderPrice) {
		super();
		this.orderCode = orderCode;
		this.orderLineCode = orderLineCode;
		this.goodsName = goodsName;
		this.goodsPrice = goodsPrice;
		this.orderQuantity = orderQuantity;
		this.userId = userId;
		this.orderDate = orderDate;
		this.orderPrice = orderPrice;
	}

	public SalesDTO(int orderLineCode, String goodsName, int goodsPrice, int orderQuantity) {
		super();
		this.orderLineCode = orderLineCode;
		this.goodsName = goodsName;
		this.goodsPrice = goodsPrice;
		this.orderQuantity = orderQuantity;
	}

	public SalesDTO(int orderCode, String userId, String orderDate, int orderPrice) {
		super();
		this.orderCode = orderCode;
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

	public SalesDTO(String goodsName, int goodsCode, int orderQuantity, String orderDate, int orderPrice, int orderCode,
			int orderLineCode) {
		super();
		this.goodsName = goodsName;
		this.goodsCode = goodsCode;
		this.orderQuantity = orderQuantity;
		this.orderDate = orderDate;
		this.orderPrice = orderPrice;
		this.orderCode = orderCode;
		this.orderLineCode = orderLineCode;
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

	public int getGoodsPrice() {
		return goodsPrice;
	}

	public void setGoodsPrice(int goodsPrice) {
		this.goodsPrice = goodsPrice;
	}

	public int getOrderCode() {
		return orderCode;
	}

	public void setOrderCode(int orderCode) {
		this.orderCode = orderCode;
	}

	public int getOrderLineCode() {
		return orderLineCode;
	}

	public void setOrderLineCode(int orderLineCode) {
		this.orderLineCode = orderLineCode;
	}
}
