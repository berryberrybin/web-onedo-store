package onedo.mvc.controller;


/**
 * 각각의 Controller의 구현체들이 실행된 후 
 * 이동해야하는 페이지정보와 이동방식에 대한 속성을  관리할 객체
 * 
 */
public class ModelAndView {
	private String viewName; // 뷰이름 - 이동해야할 페이지 
	private boolean isRedirect; // 이동방식 (true이면 redirect방식 , false이면 forward방식 으로 이동 )

	
	// 생성자 
	public ModelAndView() {}
	
	public ModelAndView(String viewName) {
		super();
		this.viewName = viewName;
	}
	
	public ModelAndView(String viewName, boolean isRedirect) {
		this(viewName);
		this.isRedirect = isRedirect;
	}

	public String getViewName() {
		return viewName;
	}

	public void setViewName(String viewName) {
		this.viewName = viewName;
	}

	public boolean isRedirect() {
		return isRedirect;
	}

	public void setRedirect(boolean isRedirect) {
		this.isRedirect = isRedirect;
	}


	
	

}
