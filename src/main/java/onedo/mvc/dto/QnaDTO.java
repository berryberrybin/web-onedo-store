package onedo.mvc.dto;

public class QnaDTO {
	private int qnaNo;
	private String qnaWriter;
	private int qnaPwd;
	private String qnaSubject;
	private String qnaContent;
	private int qnaDate;
	private String qnaImg;
	private int goodsCode;
	
	public  QnaDTO() {}

	public QnaDTO(int qnaNo, String qnaWriter, int qnaPwd, String qnaSubject, String qnaContent, int qnaDate,
			String qnaImg, int goodsCode) {
		super();
		this.qnaNo = qnaNo;
		this.qnaWriter = qnaWriter;
		this.qnaPwd = qnaPwd;
		this.qnaSubject = qnaSubject;
		this.qnaContent = qnaContent;
		this.qnaDate = qnaDate;
		this.qnaImg = qnaImg;
		this.goodsCode = goodsCode;
	}

	public int getQnaNo() {
		return qnaNo;
	}

	public void setQnaNo(int qnaNo) {
		this.qnaNo = qnaNo;
	}

	public String getQnaWriter() {
		return qnaWriter;
	}

	public void setQnaWriter(String qnaWriter) {
		this.qnaWriter = qnaWriter;
	}

	public int getQnaPwd() {
		return qnaPwd;
	}

	public void setQnaPwd(int qnaPwd) {
		this.qnaPwd = qnaPwd;
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

	public int getGoodsCode() {
		return goodsCode;
	}

	public void setGoodsCode(int goodsCode) {
		this.goodsCode = goodsCode;
	}

	
}
