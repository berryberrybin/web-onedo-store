package onedo.mvc.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import onedo.mvc.dto.QnaDTO;
import onedo.mvc.dto.ReviewDTO;
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
	 *  전체검색하기 
	 * */
	public ModelAndView qnaSelectAll(HttpServletRequest request, HttpServletResponse response) throws Exception{
		/*
		 * String pageNo = request.getParameter("pageNo");//현재페이지번호 if(pageNo==null ||
		 * pageNo.equals("")) { pageNo="1"; }
		 */
		response.setContentType("text/html;charset=UTF-8");
		
		List<QnaDTO> list = qnaService.selectAll();
		
		 try {
			 list = qnaService.selectAll();
			}catch(Exception e){
				e.printStackTrace();
			}
		/*
		 * request.setAttribute("pageNo", pageNo); //뷰에서 사용하기 위해서 ${pageNo}
		 */		 
			request.setAttribute("list", list);
		    return new ModelAndView("board/qnaAllTest.jsp") ; // 전체검색 후 위치 변경
	}
	
	/**
	 * 등록하기
	 * */
	public ModelAndView insert(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String saveDir= request.getServletContext().getRealPath("/save");
		int maxSize =1024*1024*100;//100M
	    String encoding="UTF-8";
	    MultipartRequest m = 
				new MultipartRequest(request, saveDir,maxSize,encoding , new DefaultFileRenamePolicy());
	  
	    //전송된 데이터 받기 
	  		String qnaNo = m.getParameter("qna_no"); 
	  		String userId = m.getParameter("user_id"); 
	  		String qnaSubject = m.getParameter("qna_subject"); 
	  		String qnaContent = m.getParameter("qna_content"); 
	  		String qnaDate = m.getParameter("qna_date"); 
	  		String qnaImg = m.getParameter("qna_img"); 
	  		String qnaPwd = m.getParameter("qna_pwd"); 
	  		String goodsCode = m.getParameter("goods_code"); 
	  		
	  		QnaDTO elec = new QnaDTO(Integer.parseInt(qnaNo),userId,qnaSubject,qnaContent,Integer.parseInt(qnaDate),qnaImg,Integer.parseInt(qnaPwd),Integer.parseInt(goodsCode));
	  		
	  		//파일첨부가되었다면...
	  		if(m.getFilesystemName("file") != null) {
	  			//파일이름 저장
	  			elec. setFname(m.getFilesystemName("file"));
	  			
	  			//파일크기 저장
	  			elec.setFsize((int)m.getFile("file").length());
	  		}
	  		
	  		qnaService.insert(elec);
	  		
	  		
	  		return new ModelAndView("front", true);
	  	}
	
	/**
	 * 상세보기
	 * */
	public ModelAndView selectByQnaCode(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String qnaNo = request.getParameter("qnaNo");
		String pageNo = request.getParameter("pageNo");
		
		QnaDTO reviewDTO = qnaService.selectByQnaCode(Integer.parseInt(qnaNo));
		 request.setAttribute("elec", reviewDTO);
		 request.setAttribute("pageNo", pageNo);
		 
	   return new ModelAndView("elec/read.jsp");
	}
	
	/**
	 * 수정폼
	 * */
	public ModelAndView updateForm(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String qnaNo = request.getParameter("qnaNo");
		QnaDTO elec = qnaService.selectByQnaCode(Integer.parseInt(qnaNo));
		request.setAttribute("elec", elec);
		
		
	   return new ModelAndView("elec/update.jsp");
	}
	
	/**
	 * 수정하기 
	 * */
	public ModelAndView update(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String qnaNo = request.getParameter("qnaNo"); 
		String userId = request.getParameter("userId"); 
		String qnaSubject = request.getParameter("qnaSubject"); 
		String qnaContent = request.getParameter("qnaContent"); 
		String qnaDate = request.getParameter("qnaDate"); 
		String qnaImg = request.getParameter("qnaImg"); 
		String qnaPwd = request.getParameter("qnaPwd"); 
		String goodsCode = request.getParameter("goodsCode"); 
	 
		
		QnaDTO qnaDTO = new QnaDTO(Integer.parseInt(qnaNo),userId,qnaSubject,qnaContent,Integer.parseInt(qnaDate),qnaImg,Integer.parseInt(qnaPwd),Integer.parseInt(goodsCode));
			
		qnaService.update(qnaDTO);
		
		QnaDTO dbrev = qnaService.selectByQnaCode(Integer.parseInt(qnaNo));
		request.setAttribute("elec", dbrev);
		
	return null;
	}
	
	/**
	 * 삭제하기
	 * */
	public ModelAndView delete(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String reviewNO  = request.getParameter("reviewNO");
		
		String path = request.getServletContext().getRealPath("/save");
		
		qnaService.delete(Integer.parseInt(reviewNO), path);
		
	return null;	
	}	

}
