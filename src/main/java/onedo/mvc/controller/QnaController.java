package onedo.mvc.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import onedo.mvc.dto.QnaDTO;
import onedo.mvc.dto.UserDTO;
import onedo.mvc.service.QnaService;
import onedo.mvc.service.QnaServiceImpl;

public class QnaController implements Controller {
	private QnaService qnaService = new QnaServiceImpl();

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 전체검색하기
	 */
	public ModelAndView qnaSelectAll(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String pageNo = request.getParameter("pageNo");//현재페이지번호 
		if(pageNo==null || pageNo.equals("")) {
			pageNo="1";
		}
		 

		List<QnaDTO> list = qnaService.selectAll(Integer.parseInt(pageNo));

	
		 request.setAttribute("pageNo", pageNo); //뷰에서 사용하기 위해서 ${pageNo}
		 

		request.setAttribute("list", list);
		return new ModelAndView("board/Qna.jsp"); // 전체검색 후 위치 변경
		

	}

	/**
	 * 등록하기
	 */
	public ModelAndView insert(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		UserDTO dbDTO = (UserDTO)session.getAttribute("loginUser");
		
		String userId = dbDTO.getUserId();
		
		String saveDir = request.getServletContext().getRealPath("/save");
		int maxSize = 1024 * 1024 * 100;// 100M
		String encoding = "UTF-8";
		
		MultipartRequest m = new MultipartRequest(request, saveDir, maxSize, encoding, new DefaultFileRenamePolicy());

		// 전송된 데이터 받기
		
		String goodsCode = m.getParameter("goodsCode");
		String qnaSubject = m.getParameter("qnaSubject");
		String qnaContent = m.getParameter("qnaContent");
		String qnaImg = m.getParameter("qnaImg");
		String qnaPwd = m.getParameter("qnaPwd");
		
		
		QnaDTO qdto = new QnaDTO(Integer.parseInt(goodsCode),userId, qnaSubject, qnaContent, qnaPwd);
		
		// 파일첨부가되었다면...
		if (m.getFilesystemName("file") != null) {
			// 파일이름 저장
			qdto.setFname(m.getFilesystemName("file"));

			// 파일크기 저장
			qdto.setFsize((int) m.getFile("file").length());
		}

		qnaService.insert(qdto);

		return new ModelAndView("board/Qna.jsp", true);
	}

	/**
	 * 상세보기
	 */
	public ModelAndView selectByQnaCode(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String qnaNo = request.getParameter("qnaNo");
		String pageNo = request.getParameter("pageNo");

		System.out.println(qnaNo+pageNo+"QnaController");
		
		QnaDTO qnaDTO = qnaService.selectByQnaCode(Integer.parseInt(qnaNo));
		
		request.setAttribute("qnaDTO", qnaDTO);
		request.setAttribute("pageNo", pageNo);
		
		
		return new ModelAndView("board/Qnaread.jsp");
		
	}

	/**
	 * 수정폼
	 */
	public ModelAndView updateForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String qnaNo = request.getParameter("qnaNo");
		System.out.println(qnaNo+"수정폼");
		
		QnaDTO qnaDTO = qnaService.selectByQnaCode(Integer.parseInt(qnaNo));
		request.setAttribute("qnaDTO", qnaDTO);

		return new ModelAndView("board/Qnaupdate.jsp");
	}

	/**
	 * 수정하기
	 */
	public ModelAndView update(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String goodsCode = request.getParameter("goodsCode");
		String qnaSubject = request.getParameter("qnaSubject");
		String qnaContent = request.getParameter("qnaContent");
		String qnaImg = request.getParameter("qnaImg");
		String qnaPwd = request.getParameter("qnaPwd");
		
		System.out.println("QnaController");
		
		QnaDTO qnaDTO = new QnaDTO(Integer.parseInt(goodsCode),qnaSubject,qnaContent,qnaImg,qnaPwd);

		qnaService.update(qnaDTO);

		String qnaNo= request.getParameter("qnaNo");
		
		QnaDTO dbrev = qnaService.selectByQnaCode(Integer.parseInt(qnaNo));
		request.setAttribute("qnaDTO", dbrev);

		return new ModelAndView("board/Qnaread.jsp");
	}

	/**
	 * 삭제하기
	 */
	public ModelAndView delete(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String qnaNo = request.getParameter("qnaNo");
		String qnaPwd  = request.getParameter("qnaPwd");
		
		System.out.println(qnaNo+"deletecontroller1");
		
		String path = request.getServletContext().getRealPath("/save");
		
		System.out.println(qnaNo+qnaPwd+"delete값1");
		
		System.out.println(qnaNo+"deletecontroller2");
		
		qnaService.delete(Integer.parseInt(qnaNo),qnaPwd, path);
		
		System.out.println(qnaNo+qnaPwd+"delete값2");
		System.out.println(qnaNo+"deletecontroller3");
		
		return new ModelAndView("board/Qna.jsp", true);
	}

}
