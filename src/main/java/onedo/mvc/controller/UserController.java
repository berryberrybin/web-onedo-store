package onedo.mvc.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import onedo.mvc.dto.UserDTO;
import onedo.mvc.service.UserService;
import onedo.mvc.service.UserServiceImpl;

public class UserController implements Controller {
	private UserService userService = new UserServiceImpl();

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		return null;
	}
	
	/**
	 * 회원 가입
	 * */
	public ModelAndView join (HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		String userId = request.getParameter("userId");
		String userPwd = request.getParameter("userPwd");
		String userName = request.getParameter("userName");
		String userPhone = request.getParameter("userPhone");
		String userAddr = request.getParameter("userAddr");
		String birth = request.getParameter("birth");
		String gender = request.getParameter("gender");
		
		userService.userJoin(new UserDTO(userId,userPwd,userName,userPhone,userAddr,birth,gender));
		
		request.setAttribute("userName", userName);
		request.setAttribute("userId", userId);
		return new ModelAndView("user/signupOk.jsp",true);
	}
	
	/**
	 * 로그인
	 * */
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
			//넘어오는 userId, pwd 받기
			String userId = request.getParameter("userId");
			String userPwd = request.getParameter("userPwd");
			
			//서비스 호출
			UserDTO dbDTO = userService.loginCheck(new UserDTO(userId,userPwd));
			
			//로그인 성공 ↓
			
			//그 결과를 받아서 성공했다면, sessionScope에 loginUser,loginName 저장한다
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", dbDTO); //${loginUser.userId}
			session.setAttribute("loginName", dbDTO.getUserName());
			
			//index.jsp 이동 -> redirect 
			return new ModelAndView("index.jsp", true);
	}
	
	/**
	 * 로그아웃
	 * */
	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		//모든 세션의 정보를 삭제
		HttpSession session = request.getSession();
		session.invalidate();
		
		return new ModelAndView("index.jsp", true);
	}
	
	/**
	 * 아이디 비밀번호 찾기
	 * */
	public ModelAndView userFind (HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	/**
	 * 전체 회원 검색
	 * */
	public ModelAndView userSelectAll (HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		response.setContentType("text/html;charset=UTF-8");
		
		List<UserDTO> list = userService.selectAll();

		request.setAttribute("list", list);
		return new ModelAndView("user/userAllTest.jsp");
	}
	
	/**
	 * 회원 수정
	 * */
	public void userUpdate (HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		String userId = request.getParameter("userId");
		String userPwd = request.getParameter("userPwd");
		String userName = request.getParameter("userName");
		String userPhone = request.getParameter("userPhone");
		String userAddr = request.getParameter("userAddr");
		String birth = request.getParameter("birth");
		String gender = request.getParameter("gender");
		
		UserDTO userDTO = new UserDTO(userId,userPwd,userName,userPhone,userAddr,birth,gender);
		userService.update(userDTO);
		
		/*
		 * try { userService.selectAll(); }catch(Exception e){ e.printStackTrace(); }
		 * request.setAttribute("list", list);
		 */
	}
	
	
	/**
	 * 회원 삭제
	 * */
	public void userDelete (HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		String userId = request.getParameter("userId");
		
		/*
		 * try { userService.delete(); }catch(Exception e){ e.printStackTrace(); }
		 * request.setAttribute("list", list);
		 */

	}
	
	/**
	 * 휴면 회원 (2일때 휴면 처리)
	 * */
	
	
	

}
