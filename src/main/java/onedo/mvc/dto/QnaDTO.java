package onedo.mvc.dto;

import java.util.List;



public class QnaDTO {
	private int qnaNo;
	private String userid;		
	private String qnaSubject;
	private String qnaContent;
	private int qnaDate;
	private String qnaImg;
	private int qnaPwd;
	private int goodsCode;
	private String  fname; 
	private int  fsize;

	private List<QnaReply> repliesList;
	
	private int pageCnt;
	
	public  QnaDTO() {}

	public QnaDTO(int qnaNo, String userid, String qnaSubject, String qnaContent, int qnaDate, String qnaImg,
			int qnaPwd, int goodsCode) {
		super();
		this.qnaNo = qnaNo;
		this.userid = userid;
		this.qnaSubject = qnaSubject;
		this.qnaContent = qnaContent;
		this.qnaDate = qnaDate;
		this.qnaImg = qnaImg;
		this.qnaPwd = qnaPwd;
		this.goodsCode = goodsCode;
	}
	
	

	public QnaDTO(int qnaNo, String userid, String qnaSubject, String qnaContent, int qnaDate, String qnaImg,
			int qnaPwd, int goodsCode, String fname, int fsize, int pageCnt) {
		super();
		
		this.fname = fname;
		this.fsize = fsize;
		this.pageCnt = pageCnt;
	}

	public int getQnaNo() {
		return qnaNo;
	}

	public void setQnaNo(int qnaNo) {
		this.qnaNo = qnaNo;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getQnaSubject() {
		return qnaSubject;
	}

	public void setQnaSubject(String qnaSubject) {
		this.qnaSubject = qnaSubject;
	}

	public String getQnaContent() {
		return qnaContent;
	}

	public void setQnaContent(String qnaContent) {
		this.qnaContent = qnaContent;
	}

	public int getQnaDate() {
		return qnaDate;
	}

	public void setQnaDate(int qnaDate) {
		this.qnaDate = qnaDate;
	}

	public String getQnaImg() {
		return qnaImg;
	}

	public void setQnaImg(String qnaImg) {
		this.qnaImg = qnaImg;
	}

	public int getQnaPwd() {
		return qnaPwd;
	}

	public void setQnaPwd(int qnaPwd) {
		this.qnaPwd = qnaPwd;
	}

	public int getGoodsCode() {
		return goodsCode;
	}

	public void setGoodsCode(int goodsCode) {
		this.goodsCode = goodsCode;
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

	public int getPageCnt() {
		return pageCnt;
	}

	public void setPageCnt(int pageCnt) {
		this.pageCnt = pageCnt;
	}

	public List<QnaReply> getRepliesList() {
		return repliesList;
	}

	public void setRepliesList(List<QnaReply> repliesList) {
		this.repliesList = repliesList;
	}
	
	
	
}
