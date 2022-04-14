package onedo.mvc.dto;

public class GoodsTypeDTO {
	private String goodsCode;
	private String goodsType;
	
	public GoodsTypeDTO() {}

	public GoodsTypeDTO(String goodsCode, String goodsType) {
		super();
		this.goodsCode = goodsCode;
		this.goodsType = goodsType;
	}

	public String getGoodsCode() {
		return goodsCode;
	}

	public void setGoodsCode(String goodsCode) {
		this.goodsCode = goodsCode;
	}

	public String getGoodsType() {
		return goodsType;
	}

	public void setGoodsType(String goodsType) {
		this.goodsType = goodsType;
	}
	
	
	
	

}
