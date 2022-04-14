package onedo.mvc.dto;

public class FaqDTO {
	private	int faqNo;
	private String faqSubject;
	private String faqContent;
	
	public FaqDTO() {}

	public FaqDTO(int faqNo, String faqSubject, String faqContent) {
		super();
		this.faqNo = faqNo;
		this.faqSubject = faqSubject;
		this.faqContent = faqContent;
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
	
	
}
