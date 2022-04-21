package onedo.mvc.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import onedo.mvc.dto.FaqDTO;
import onedo.mvc.service.FaqService;
import onedo.mvc.service.FaqServiceImpl;

public class FaqController implements Controller{
	private FaqService faqService = new FaqServiceImpl();

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 *  전체검색하기 
	 * */
	public ModelAndView faqSelectAll(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String pageNo = request.getParameter("pageNo");//현재페이지번호 
		if(pageNo==null || pageNo.equals("")) {
			pageNo="1";
		}
		 
		
		List<FaqDTO> list = faqService.selectAll(Integer.parseInt(pageNo));
		
		request.setAttribute("pageNo", pageNo);
		
		 request.setAttribute("list", list);
		 return new ModelAndView("board/Faq.jsp") ; // 전체검색 후 위치 변경
			
			 
		
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
	  		String faqNo = m.getParameter("faq_no"); 
	  		String faqSubject = m.getParameter("faq_subject"); 
	  		String faqContent = m.getParameter("faq_content"); 

	  		FaqDTO elec = new FaqDTO(Integer.parseInt(faqNo),faqSubject,faqContent);
	  		
	  		//파일첨부가되었다면...
	  		if(m.getFilesystemName("file") != null) {
	  			//파일이름 저장
	  			elec. setFname(m.getFilesystemName("file"));
	  			
	  			//파일크기 저장
	  			elec.setFsize((int)m.getFile("file").length());
	  		}
	  		
	  		faqService.insert(elec);
	  		
	  		
	  		return new ModelAndView("front", true);
	  	}
	
	/**
	 * 상세보기
	 * */
	public ModelAndView selectByFaqCode(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String faqNo = request.getParameter("faqNo");
		String pageNo = request.getParameter("pageNo");
		
		FaqDTO faqDTO = faqService.selectByFaqCode(Integer.parseInt(faqNo));
		 request.setAttribute("faqDTO", faqDTO);
		 request.setAttribute("pageNo", pageNo);
		 
	   return new ModelAndView("board/Faqread.jsp");
	}
	
	/**
	 * 수정폼
	 * */
	public ModelAndView updateForm(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String faqNo = request.getParameter("faqNo");
		FaqDTO elec = faqService.selectByFaqCode(Integer.parseInt(faqNo));
		request.setAttribute("elec", elec);
		
		
	   return new ModelAndView("elec/update.jsp");
	}
	
	/**
	 * 수정하기 
	 * */
	public ModelAndView update(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String faqNo = request.getParameter("faqNo"); 
		String userId = request.getParameter("userId"); 
		String faqSubject = request.getParameter("faqSubject"); 
		String faqContent = request.getParameter("faqContent"); 
		
		FaqDTO faqDTO = new FaqDTO();
			
		faqService.update(faqDTO);
		
		FaqDTO dbfaq = faqService.selectByFaqCode(Integer.parseInt(faqNo));
		request.setAttribute("elec", dbfaq);
		
	return null;
	}
	
	/**
	 * 삭제하기
	 * */
	public ModelAndView delete(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String faqNo  = request.getParameter("faqNo");
		
		String path = request.getServletContext().getRealPath("/save");
		
		faqService.delete(Integer.parseInt(faqNo), path);
		
	return null;	
	}	
	
	
}
