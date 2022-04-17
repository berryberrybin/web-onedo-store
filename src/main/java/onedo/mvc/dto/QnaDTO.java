package onedo.mvc.dto;

import java.util.List;



public class QnaDTO {
	private int qnaNo;
	private int goodsCode;
	private String userid;		
	private String qnaSubject;
	private String qnaContent;
	private String qnaDate;
	private String qnaImg;
	private String qnaPwd;
	
	
	private String  fname; 
	private int  fsize;

	private List<QnaReply> repliesList;
	
	private int pageCnt;
	
	public  QnaDTO() {}

	
	
	public QnaDTO(int qnaNo, int goodsCode, String userid, String qnaSubject, String qnaContent, String qnaDate,
			String qnaImg, String qnaPwd) {
		super();
		this.qnaNo = qnaNo;
		this.goodsCode = goodsCode;
		this.userid = userid;
		this.qnaSubject = qnaSubject;
		this.qnaContent = qnaContent;
		this.qnaDate = qnaDate;
		this.qnaImg = qnaImg;
		this.qnaPwd = qnaPwd;
	}


	public QnaDTO(String fname, int fsize, List<QnaReply> repliesList, int pageCnt) {
		super();
		this.fname = fname;
		this.fsize = fsize;
		this.repliesList = repliesList;
		this.pageCnt = pageCnt;
	}



	public int getQnaNo() {
		return qnaNo;
	}


	public void setQnaNo(int qnaNo) {
		this.qnaNo = qnaNo;
	}


	public int getGoodsCode() {
		return goodsCode;
	}


	public void setGoodsCode(int goodsCode) {
		this.goodsCode = goodsCode;
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


	public String getQnaDate() {
		return qnaDate;
	}


	public void setQnaDate(String qnaDate) {
		this.qnaDate = qnaDate;
	}


	public String getQnaImg() {
		return qnaImg;
	}


	public void setQnaImg(String qnaImg) {
		this.qnaImg = qnaImg;
	}


	public String getQnaPwd() {
		return qnaPwd;
	}


	public void setQnaPwd(String qnaPwd) {
		this.qnaPwd = qnaPwd;
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
