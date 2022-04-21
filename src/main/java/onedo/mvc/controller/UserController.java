package onedo.mvc.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import onedo.mvc.dto.QnaDTO;
import onedo.mvc.dto.SalesDTO;
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
			userService.dorCheck(userId); //휴면회원 검증
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
	 * 전체 회원 검색
	 * */
	public ModelAndView userSelectAll (HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		response.setContentType("text/html;charset=UTF-8");
		
		List<UserDTO> list = userService.selectAll();

		request.setAttribute("list", list);
		return new ModelAndView("user/userTest.jsp");
	}
	
	/**
	 * 회원 수정
	 * */
	public ModelAndView userUpdate (HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		response.setContentType("text/html;charset=UTF-8");

		
		String userId = request.getParameter("userId");
		String userPwd = request.getParameter("userPwd");
		String userName = request.getParameter("userName");
		String userPhone = request.getParameter("userPhone");
		String userAddr = request.getParameter("userAddr");
		String birth = request.getParameter("birth");
		String gender = request.getParameter("gender");
		
		UserDTO userDTO = new UserDTO(userId,userPwd,userName,userPhone,userAddr,birth,gender);
		userService.update(userDTO);
		
		return new ModelAndView("user/modifyOk.jsp");
	}
	
	/**
	 * 마이페이지
	 * */
	public ModelAndView myPage (HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		response.setContentType("text/html;charset=UTF-8");

		
		String pageNo = request.getParameter("pageNo"); //현재 페이지 번호 
		if(pageNo==null || pageNo.equals("")) {
			pageNo="1";
		}
		
		System.out.println(pageNo);

		//세션에 저장된 유저 아이디 불러오기
		HttpSession session = request.getSession();
		UserDTO dbDTO = (UserDTO)session.getAttribute("loginUser");
		String userId = dbDTO.getUserId();
		
		/*
		 * //가져온 아이디로 DB호출 List<SalesDTO> myList = userService.selectMyOrder(userId);
		 */
		
		//페이징 처리 DB 호출 
		List<SalesDTO> myList = userService.selectMyOrder(userId,Integer.parseInt(pageNo));
		request.setAttribute("pageNo", pageNo); //뷰에서 사용하기 위해서 ${pageNo}
		request.setAttribute("myList", myList); 
		System.out.println(myList);
		 
		/*
		 * System.out.println(myList); request.setAttribute("myList", myList);
		 */
		
		//return new ModelAndView("front?key=user&methodName=myPage&pageNo="+pageNo);
		return new ModelAndView("user/myPage.jsp");
	}
	
	
	/**
	 * 마이페이지 주문 상세페이지
	 * */
	public ModelAndView myOrderLine (HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		response.setContentType("text/html;charset=UTF-8");
		
		//주문번호를 받아온다
		String orderCode = request.getParameter("orderCode");
		
		//세션에 저장된 유저 아이디 불러오기
		HttpSession session = request.getSession();
		UserDTO dbDTO = (UserDTO)session.getAttribute("loginUser");
		String userId = dbDTO.getUserId();
		
		//주문번호 클릭 - 해당 주문번호의 주문 상세 띄우는 DB 이동 
		List<SalesDTO> myList = userService.selectMyOrderLine(userId, Integer.parseInt(orderCode));
		
		request.setAttribute("orderLine", myList);
		return new ModelAndView("user/myOrderLine.jsp");
	}
	
	/**
	 * 마이페이지 내가 쓴 글 보기 페이지
	 * */
	public ModelAndView myBoard (HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		response.setContentType("text/html;charset=UTF-8");

		//세션에 저장된 유저 아이디 불러오기
		HttpSession session = request.getSession();
		UserDTO dbDTO = (UserDTO)session.getAttribute("loginUser");
		String userId = dbDTO.getUserId();
		
		//가져온 아이디로 DB 호출
		List<QnaDTO> myBoard = userService.selectMyBoard(userId);
		
		request.setAttribute("myBoard", myBoard);
		return new ModelAndView("user/myBoardPage.jsp");
	}
	
	
	
	
	
}
