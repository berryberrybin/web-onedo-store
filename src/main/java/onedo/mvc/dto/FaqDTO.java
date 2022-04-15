package onedo.mvc.dto;

public class FaqDTO {
	private	int faqNo;
	private String faqSubject;
	private String faqContent;
	
	private String  fname; 
	private int  fsize;
	private int pageCnt;
	
	public FaqDTO() {}

	public FaqDTO(int faqNo, String faqSubject, String faqContent) {
		super();
		this.faqNo = faqNo;
		this.faqSubject = faqSubject;
		this.faqContent = faqContent;
	}
	
	

	public FaqDTO(int faqNo, String faqSubject, String faqContent, String fname, int fsize, int pageCnt) {
		super();
	
		this.fname = fname;
		this.fsize = fsize;
		this.pageCnt = pageCnt;
	}

	public int getFaqNo() {
		return faqNo;
	}

	public void setFaqNo(int faqNo) {
		this.faqNo = faqNo;
	}

	public String getFaqSubject() {
		return faqSubject;
	}

	public void setFaqSubject(String faqSubject) {
		this.faqSubject = faqSubject;
	}

	public String getFaqContent() {
		return faqContent;
	}

	public void setFaqContent(String faqContent) {
		this.faqContent = faqContent;
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
