package onedo.mvc.dto;

import java.util.List;

public class ReviewDTO {

	private int reviewNo;
	private int goodsCode;
	private String userId;
	private String reviewSubject;
	private String reviewContent;
	private String reviewDate;
	private String reviewImg;
	private int reviewScore;
	
	private String  fname; 
	private int  fsize;
	
	private List<ReviewDTO> repliesList;
	private int pageCnt;
	
	public  ReviewDTO() {}

	public ReviewDTO(int reviewNo, int goodsCode, String userId, String reviewSubject, String reviewContent, String reviewDate,
			String reviewImg, int reviewScore) {
		super();
		this.reviewNo = reviewNo;
		this.goodsCode = goodsCode;
		this.userId = userId;
		this.reviewSubject = reviewSubject;
		this.reviewContent = reviewContent;
		this.reviewDate = reviewDate;
		this.reviewImg = reviewImg;
		this.reviewScore = reviewScore;
		
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

	public String getReviewDate() {
		return reviewDate;
	}

	public void setReviewDate(String reviewDate) {
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

	public List<ReviewDTO> getRepliesList() {
		return repliesList;
	}

	public void setRepliesList(List<ReviewDTO> repliesList) {
		this.repliesList = repliesList;
	}

	

	
}
