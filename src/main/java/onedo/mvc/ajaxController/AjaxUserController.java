package onedo.mvc.ajaxController;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import net.sf.json.JSONArray;

import onedo.mvc.dao.UserDAO;
import onedo.mvc.dao.UserDAOImpl;

import onedo.mvc.dto.UserDTO;
import onedo.mvc.service.UserService;
import onedo.mvc.service.UserServiceImpl;

public class AjaxUserController implements AjaxController {
	private UserService userService = new UserServiceImpl();
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


	/**
	 * 전체검색
	 */
	public void selectAll(HttpServletRequest request, HttpServletResponse response) throws Exception{
		response.setContentType("text/html;charset=UTF-8");

		List<UserDTO> list = userService.selectAll();
		
		JSONArray arr = JSONArray.fromObject(list);
		
		PrintWriter out = response.getWriter();
		out.print(arr);
	}
	
	/**
	 * 유저타입 변경하기
	 */
	public void typeUpdate(HttpServletRequest request, HttpServletResponse response) throws Exception{
		response.setContentType("text/html;charset=UTF-8");
		
		String userId = request.getParameter("id");
		String userType = request.getParameter("type");
		System.out.println(userType);
		System.out.println(userId);
		int result = userService.typeUpdate(userId, userType);
		
		PrintWriter out = response.getWriter();
		out.print(result);
	}
}
