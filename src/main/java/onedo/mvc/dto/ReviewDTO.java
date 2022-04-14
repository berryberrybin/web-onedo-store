package onedo.mvc.dto;

public class ReviewDTO {

	private int reviewNo;
	private String reviewWriter;
	private String reviewSubject;
	private String reviewContent;
	private int reviewDate;
	private String reviewImg;
	private String reviewScore;
	private int goodsCode;

	public  ReviewDTO() {}

	public ReviewDTO(int reviewNo, String reviewWriter, String reviewSubject, String reviewContent, int reviewDate,
			String reviewImg, String reviewScore, int goodsCode) {
		super();
		this.reviewNo = reviewNo;
		this.reviewWriter = reviewWriter;
		this.reviewSubject = reviewSubject;
		this.reviewContent = reviewContent;
		this.reviewDate = reviewDate;
		this.reviewImg = reviewImg;
		this.reviewScore = reviewScore;
		this.goodsCode = goodsCode;
	}

	public int getReviewNo() {
		return reviewNo;
	}

	public void setReviewNo(int reviewNo) {
		this.reviewNo = reviewNo;
	}

	public String getReviewWriter() {
		return reviewWriter;
	}

	public void setReviewWriter(String reviewWriter) {
		this.reviewWriter = reviewWriter;
	}

	public String getReviewSubject() {
		return reviewSubject;
	}

	public void setReviewSubject(String reviewSubject) {
		this.reviewSubject = reviewSubject;
	}

	public String getReviewContent() {
		return reviewContent;
	}

	public void setReviewContent(String reviewContent) {
		this.reviewContent = reviewContent;
	}

	public int getReviewDate() {
		return reviewDate;
	}

	public void setReviewDate(int reviewDate) {
		this.reviewDate = reviewDate;
	}

	public String getReviewImg() {
		return reviewImg;
	}

	public void setReviewImg(String reviewImg) {
		this.reviewImg = reviewImg;
	}

	public String getReviewScore() {
		return reviewScore;
	}

	public void setReviewScore(String reviewScore) {
		this.reviewScore = reviewScore;
	}

	public int getGoodsCode() {
		return goodsCode;
	}

	public void setGoodsCode(int goodsCode) {
		this.goodsCode = goodsCode;
	}

	

	
}
