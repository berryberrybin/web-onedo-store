package onedo.mvc.ajaxController;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import onedo.mvc.dto.UserDTO;
import onedo.mvc.service.UserService;
import onedo.mvc.service.UserServiceImpl;

public class AjaxUserController implements AjaxController {
	private UserService userService = new UserServiceImpl();
	
	@Override
	public void handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

	}
	/**
	 * 전체검색
	 */
	public void selectAll(HttpServletRequest request, HttpServletResponse response) throws Exception{
		List<UserDTO> list = userService.selectAll();
	}

}
