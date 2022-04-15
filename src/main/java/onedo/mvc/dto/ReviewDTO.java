package onedo.mvc.dto;

public class ReviewDTO {

	private int reviewNo;
	private String userId;
	private String reviewSubject;
	private String reviewContent;
	private int reviewDate;
	private String reviewImg;
	private int reviewScore;
	private int goodsCode;
	
	private String  fname; 
	private int  fsize;

	private int pageCnt;
	
	public  ReviewDTO() {}

	public ReviewDTO(int reviewNo, String userId, String reviewSubject, String reviewContent, int reviewDate,
			String reviewImg, int reviewScore, int goodsCode) {
		super();
		this.reviewNo = reviewNo;
		this.userId = userId;
		this.reviewSubject = reviewSubject;
		this.reviewContent = reviewContent;
		this.reviewDate = reviewDate;
		this.reviewImg = reviewImg;
		this.reviewScore = reviewScore;
		this.goodsCode = goodsCode;
		
	}
	

	public ReviewDTO(int reviewNo, String userId, String reviewSubject, String reviewContent, int reviewDate,
			String reviewImg, int reviewScore, int goodsCode, String fname, int fsize, int pageCnt) {
		this(reviewNo,userId,reviewSubject,reviewContent,reviewDate,reviewImg,reviewScore,goodsCode);
		this.fname = fname;
		this.fsize = fsize;
		
	}

	public int getReviewNo() {
		return reviewNo;
	}

	public void setReviewNo(int reviewNo) {
		this.reviewNo = reviewNo;
	}

	

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
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

	public int getReviewScore() {
		return reviewScore;
	}

	public void setReviewScore(int reviewScore) {
		this.reviewScore = reviewScore;
	}

	public int getGoodsCode() {
		return goodsCode;
	}

	public void setGoodsCode(int goodsCode) {
		this.goodsCode = goodsCode;
	}

	public int getPageCnt() {
		return pageCnt;
	}

	public void setPageCnt(int pageCnt) {
		this.pageCnt = pageCnt;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public int getFsize() {
		return fsize;
	}

	public void setFsize(int fsize) {
		this.fsize = fsize;
	}

	

	
}
