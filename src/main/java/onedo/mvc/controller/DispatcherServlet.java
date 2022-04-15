package onedo.mvc.controller;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 사용자의 모든 요청을 처리할 진입점 Controller 역할을 함 FrontController 역할과 유사
 */

@WebServlet(urlPatterns = "/front", loadOnStartup = 1)
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Map<String, Controller> map;
	Map<String, Class<?>> clzMap;

	@Override
	public void init() throws ServletException {
		map = (Map<String, Controller>) super.getServletContext().getAttribute("map");
		clzMap = (Map<String, Class<?>>) super.getServletContext().getAttribute("clzMap");
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String key = request.getParameter("key");
		String methodName = request.getParameter("methodName");
		
		if(key==null || key.equals("")) {
			key="goods";
		}
		
		if(methodName==null || methodName.equals("")) {
			methodName="searchSelectAll";
		}
		System.out.println("key = " + key + " methodName = " + methodName);
		
		try {
			Class<?> clz = clzMap.get(key);
			Method method = clz.getMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
			Controller controller = map.get(key);
			ModelAndView mv = (ModelAndView) method.invoke(controller, request, response);

			if (mv.isRedirect()) { //따로 true를 설정하지 않아서 false로 들어옴  = forward방식으로 보냄 
				response.sendRedirect(mv.getViewName());
			} else {
				request.getRequestDispatcher(mv.getViewName()).forward(request, response); 
				//getRequestDispatcher 는  viewResolver역할 - view이름을 통해 해당 view를 찾음 
				//request에 model을 담아서 전달 
				
				
			}
		} catch (Exception e) {
			e.printStackTrace();
			//추가 
			request.setAttribute("errorMsg", e.getCause().getMessage());
			request.getRequestDispatcher("error/error.jsp").forward(request, response);
		}
	}
}
