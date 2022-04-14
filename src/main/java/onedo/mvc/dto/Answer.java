package onedo.mvc.dto;

public class Answer {
	
	private int qnaNo;
	private String answer_content;
	private int answerNo;
	
	public Answer() {}

	public Answer(int qnaNo, String answer_content, int answerNo) {
		super();
		this.qnaNo = qnaNo;
		this.answer_content = answer_content;
		this.answerNo = answerNo;
	}

	public int getQnaNo() {
		return qnaNo;
	}

	public void setQnaNo(int qnaNo) {
		this.qnaNo = qnaNo;
	}

	public String getAnswer_content() {
		return answer_content;
	}

	public void setAnswer_content(String answer_content) {
		this.answer_content = answer_content;
	}

	public int getAnswerNo() {
		return answerNo;
	}

	public void setAnswerNo(int answerNo) {
		this.answerNo = answerNo;
	}
	
	
	
}
