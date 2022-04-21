package onedo.mvc.dto;

import java.util.List;

public class OrdersDTO {
	private int orderCode;
	private int stateNo;
	private String userId;
	private String orderDate;
	private String orderAddr;
	private String orderPhone;
	private int orderPrice;
	private List<OrderLineDTO> lineDTO;

	public OrdersDTO() {}
	
	public OrdersDTO(String userId, String orderAddr, String orderPhone, int orderPrice) {
		super();

		this.userId = userId;
		this.orderAddr = orderAddr;
		this.orderPhone = orderPhone;
		this.orderPrice = orderPrice;
	}

	public OrdersDTO(int orderCode, int stateNo, String userId, String orderDate, String orderAddr, String orderPhone,
			int orderPrice, List<OrderLineDTO> lineDTO) {
		super();
		this.orderCode = orderCode;
		this.stateNo = stateNo;
		this.userId = userId;
		this.orderDate = orderDate;
		this.orderAddr = orderAddr;
		this.orderPhone = orderPhone;
		this.orderPrice = orderPrice;
		this.lineDTO = lineDTO;
	}

	public int getOrderCode() {
		return orderCode;
	}

	public void setOrderCode(int orderCode) {
		this.orderCode = orderCode;
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

	public List<OrderLineDTO> getLineDTO() {
		return lineDTO;
	}

	public void setLineDTO(List<OrderLineDTO> lineDTO) {
		this.lineDTO = lineDTO;
	}

	
}
