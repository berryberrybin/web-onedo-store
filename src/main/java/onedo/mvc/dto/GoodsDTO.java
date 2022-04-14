package onedo.mvc.dto;

public class GoodsDTO {
	   private String goodsCode;
	   private GoodsTypeDTO goodsTypeDto;
	   private String goodsName;
	   private int goodsPrice;
	   private int goodsStock;
	   private String goodsDetail;
	   private int isSoldout; 
	   private int goodsView;
	   private String goodsImg;
	   
	   public GoodsDTO() {}

	public GoodsDTO(String goodsCode, GoodsTypeDTO goodsTypeDto, String goodsName, int goodsPrice, int goodsStock,
			String goodsDetail, int isSoldout, int goodsView, String goodsImg) {
		super();
		this.goodsCode = goodsCode;
		this.goodsTypeDto = goodsTypeDto;
		this.goodsName = goodsName;
		this.goodsPrice = goodsPrice;
		this.goodsStock = goodsStock;
		this.goodsDetail = goodsDetail;
		this.isSoldout = isSoldout;
		this.goodsView = goodsView;
		this.goodsImg = goodsImg;
	}

	public String getGoodsCode() {
		return goodsCode;
	}

	public void setGoodsCode(String goodsCode) {
		this.goodsCode = goodsCode;
	}

	public GoodsTypeDTO getGoodsTypeDto() {
		return goodsTypeDto;
	}

	public void setGoodsTypeDto(GoodsTypeDTO goodsTypeDto) {
		this.goodsTypeDto = goodsTypeDto;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public int getGoodsPrice() {
		return goodsPrice;
	}

	public void setGoodsPrice(int goodsPrice) {
		this.goodsPrice = goodsPrice;
	}

	public int getGoodsStock() {
		return goodsStock;
	}

	public void setGoodsStock(int goodsStock) {
		this.goodsStock = goodsStock;
	}

	public String getGoodsDetail() {
		return goodsDetail;
	}

	public void setGoodsDetail(String goodsDetail) {
		this.goodsDetail = goodsDetail;
	}

	public int getIsSoldout() {
		return isSoldout;
	}

	public void setIsSoldout(int isSoldout) {
		this.isSoldout = isSoldout;
	}

	public int getGoodsView() {
		return goodsView;
	}

	public void setGoodsView(int goodsView) {
		this.goodsView = goodsView;
	}

	public String getGoodsImg() {
		return goodsImg;
	}

	public void setGoodsImg(String goodsImg) {
		this.goodsImg = goodsImg;
	}
	   

	
	

	
	   
}


