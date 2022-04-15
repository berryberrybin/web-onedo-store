package onedo.mvc.dto;

public class NoticeDTO {
	private int noticeNo;
	private String noticeSubject;
	private String noticeContent;
	private int noticeDate;
	private String noticeImg;
	
	private String  fname; 
	private int  fsize;
	private int pageCnt;
	
	public NoticeDTO() {}

	public NoticeDTO(int noticeNo, String noticeSubject, String noticeContent, int noticeDate, String noticeImg) {
		super();
		this.noticeNo = noticeNo;
		this.noticeSubject = noticeSubject;
		this.noticeContent = noticeContent;
		this.noticeDate = noticeDate;
		this.noticeImg = noticeImg;
	}
	

	public NoticeDTO(int noticeNo, String noticeSubject, String noticeContent, int noticeDate, String noticeImg,
			String fname, int fsize, int pageCnt) {
		super();
	
		this.fname = fname;
		this.fsize = fsize;
	
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

	public int getNoticeDate() {
		return noticeDate;
	}

	public void setNoticeDate(int noticeDate) {
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
	
	
}
