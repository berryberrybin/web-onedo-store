package onedo.mvc.dto;

public class QnaReplyDTO {
	private int replyNo;
	private String qnaNo;
	private String replyContent;
	
	public QnaReplyDTO() {}

	public QnaReplyDTO(int replyNo, String qnaNo, String replyContent) {
		super();
		this.replyNo = replyNo;
		this.qnaNo = qnaNo;
		this.replyContent = replyContent;
	}

	public int getReplyNo() {
		return replyNo;
	}

	public void setReplyNo(int replyNo) {
		this.replyNo = replyNo;
	}

	public String getQnaNo() {
		return qnaNo;
	}

	public void setQnaNo(String qnaNo) {
		this.qnaNo = qnaNo;
	}

	public String getReplyContent() {
		return replyContent;
	}

	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}
	
}

