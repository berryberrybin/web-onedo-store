package onedo.mvc.dto;

import java.util.List;

public class NoticeDTO {
	private int noticeNo;
	private String noticeSubject;
	private String noticeContent;
	private String noticeDate;
	private String noticeImg;
	
	private String fname; 
	private int  fsize;
	private int pageCnt;
	
	private List<NoticeDTO> repliesList;
	
	public NoticeDTO() {}

	
	

	public NoticeDTO(int noticeNo, String noticeSubject, String noticeContent, String noticeDate, String noticeImg) {
		super();
		this.noticeNo = noticeNo;
		this.noticeSubject = noticeSubject;
		this.noticeContent = noticeContent;
		this.noticeDate = noticeDate;
		this.noticeImg = noticeImg;
	}



	public NoticeDTO(String noticeSubject, String noticeContent) {
		super();
		this.noticeSubject = noticeSubject;
		this.noticeContent = noticeContent;
	}




	public NoticeDTO(int noticeNo, String noticeSubject, String noticeContent) {
		super();
		this.noticeNo = noticeNo;
		this.noticeSubject = noticeSubject;
		this.noticeContent = noticeContent;
	}




	public int getNoticeNo() {
		return noticeNo;
	}




	public void setNoticeNo(int noticeNo) {
		this.noticeNo = noticeNo;
	}




	public String getNoticeSubject() {
		return noticeSubject;
	}




	public void setNoticeSubject(String noticeSubject) {
		this.noticeSubject = noticeSubject;
	}




	public String getNoticeContent() {
		return noticeContent;
	}




	public void setNoticeContent(String noticeContent) {
		this.noticeContent = noticeContent;
	}




	public String getNoticeDate() {
		return noticeDate;
	}




	public void setNoticeDate(String noticeDate) {
		this.noticeDate = noticeDate;
	}




	public String getNoticeImg() {
		return noticeImg;
	}




	public void setNoticeImg(String noticeImg) {
		this.noticeImg = noticeImg;
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

	public List<NoticeDTO> getRepliesList() {
		return repliesList;
	}

	public void setRepliesList(List<NoticeDTO> repliesList) {
		this.repliesList = repliesList;
	}
	
	
	
}
