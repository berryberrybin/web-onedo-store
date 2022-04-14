package onedo.mvc.dto;

public class GoodsTypeDTO {
	private String goodsType;
	private String goodsName;
	
	public GoodsTypeDTO() {}

	public GoodsTypeDTO(String goodsType, String goodsName) {
		super();
		this.goodsType = goodsType;
		this.goodsName = goodsName;
	}

	public String getGoodsType() {
		return goodsType;
	}

	public void setGoodsType(String goodsType) {
		this.goodsType = goodsType;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	
	
	
	

}
