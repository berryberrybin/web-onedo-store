package onedo.mvc.dto;

public class QnaReply {
	private int replyNum;
	private String replyContent;
	private String replyRegDate;
	private String parentModelNum;
	
	private QnaReply() {}

	public QnaReply(int replyNum, String replyContent, String replyRegDate, String parentModelNum) {
		super();
		this.replyNum = replyNum;
		this.replyContent = replyContent;
		this.replyRegDate = replyRegDate;
		this.parentModelNum = parentModelNum;
	}

	public int getReplyNum() {
		return replyNum;
	}

	public void setReplyNum(int replyNum) {
		this.replyNum = replyNum;
	}

	public String getReplyContent() {
		return replyContent;
	}

	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}

	public String getReplyRegDate() {
		return replyRegDate;
	}

	public void setReplyRegDate(String replyRegDate) {
		this.replyRegDate = replyRegDate;
	}

	public String getParentModelNum() {
		return parentModelNum;
	}

	public void setParentModelNum(String parentModelNum) {
		this.parentModelNum = parentModelNum;
	}
	
	
}

