package onedo.mvc.dto;

public class OrdersDTO {
	private int stateNo;
	private String userId;
	private String orderDate;
	private String orderAddr;
	private String orderPhone;
	private int orderPrice;

	public OrdersDTO() {}
	
	public OrdersDTO(String userId, String orderAddr, String orderPhone, int orderPrice) {
		super();

		this.userId = userId;
		this.orderAddr = orderAddr;
		this.orderPhone = orderPhone;
		this.orderPrice = orderPrice;
	}



	public int getStateNo() {
		return stateNo;
	}

	public void setStateNo(int stateNo) {
		this.stateNo = stateNo;
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

	public String getOrderAddr() {
		return orderAddr;
	}

	public void setOrderAddr(String orderAddr) {
		this.orderAddr = orderAddr;
	}

	public String getOrderPhone() {
		return orderPhone;
	}

	public void setOrderPhone(String orderPhone) {
		this.orderPhone = orderPhone;
	}

	public int getOrderPrice() {
		return orderPrice;
	}

	public void setOrderPrice(int orderPrice) {
		this.orderPrice = orderPrice;
	}


	

}
