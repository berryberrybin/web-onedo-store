package onedo.mvc.ajaxController;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import onedo.mvc.dao.UserDAO;
import onedo.mvc.dao.UserDAOImpl;

public class AjaxUserController implements AjaxController {
	private UserDAO userDAO = new UserDAOImpl();

	@Override
	public void handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

	}
	
	/**
	 * 아이디 중복 체크
	 * */
	public void idCheck(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		
		String userId = request.getParameter("userId");
		boolean result = userDAO.idCheck(userId);
		
		PrintWriter out = response.getWriter();
		
		if(result) out.print("사용이 불가능한 아이디 입니다");
		else out.print("사용 가능한 아이디 입니다");

	}
}

