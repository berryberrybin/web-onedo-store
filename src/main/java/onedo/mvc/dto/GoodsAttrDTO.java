package onedo.mvc.dto;

public class GoodsAttrDTO {
	private int sour;
	private int sweet;
	private int aroma;
	private int body;
	
	public GoodsAttrDTO() {}

	public GoodsAttrDTO(int sour, int sweet, int aroma, int body) {
		super();
		this.sour = sour;
		this.sweet = sweet;
		this.aroma = aroma;
		this.body = body;
	}

	public int getSour() {
		return sour;
	}

	public void setSour(int sour) {
		this.sour = sour;
	}

	public int getSweet() {
		return sweet;
	}

	public void setSweet(int sweet) {
		this.sweet = sweet;
	}

	public int getAroma() {
		return aroma;
	}

	public void setAroma(int aroma) {
		this.aroma = aroma;
	}

	public int getBody() {
		return body;
	}

	public void setBody(int body) {
		this.body = body;
	}
	
	
}
