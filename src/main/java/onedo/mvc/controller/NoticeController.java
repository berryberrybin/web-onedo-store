package onedo.mvc.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import onedo.mvc.dto.NoticeDTO;
import onedo.mvc.dto.ReviewDTO;
import onedo.mvc.service.NoticeService;
import onedo.mvc.service.NoticeServiceImpl;

public class NoticeController implements Controller {
		private NoticeService notService = new NoticeServiceImpl();
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 *  전체검색하기 
	 * */
	public ModelAndView noticeSelectAll(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		String pageNo = request.getParameter("pageNo");//현재페이지번호 
		if(pageNo==null || pageNo.equals("")) {
			pageNo="1";
		}
		 
		List<NoticeDTO> list = notService.selectAll(Integer.parseInt(pageNo));
		
		 request.setAttribute("list", list);
			
			  request.setAttribute("pageNo", pageNo); //뷰에서 사용하기 위해서 ${pageNo}
			 
		 return new ModelAndView("board/Notice.jsp") ;
	}
	
	/**
	 * 등록하기
	 */
	public ModelAndView insert(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String saveDir= request.getServletContext().getRealPath("/save");
		int maxSize =1024*1024*100;//100M
	    String encoding="UTF-8";
	    MultipartRequest m = 
				new MultipartRequest(request, saveDir,maxSize,encoding , new DefaultFileRenamePolicy());
	  
	    //전송된 데이터 받기 
	  
	    String noticeSubject = m.getParameter("notice_subject");
	    String noticeContent = m.getParameter("notice_content");
	    String noticeImg = m.getParameter("notice_img");
	    
	    NoticeDTO ndto = new NoticeDTO(noticeSubject,noticeContent,noticeImg);
	    
	  //파일첨부가되었다면...
  		if(m.getFilesystemName("file") != null) {
  			//파일이름 저장
  			ndto. setFname(m.getFilesystemName("file"));
  			
  			//파일크기 저장
  			ndto.setFsize((int)m.getFile("file").length());
  		}
  		
  		notService.insert(ndto);
  		
  		
  		return new ModelAndView("board/Notice.jsp", true);
  	}
	
	/**
	 * 상세보기
	 * */
	public ModelAndView selectByNoticeCode(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String noticeNo = request.getParameter("noticeNo");
		String pageNo = request.getParameter("pageNo");
		
		NoticeDTO noticeDTO = notService.selectByNoticeCode(Integer.parseInt(noticeNo));
		 request.setAttribute("noticeDTO", noticeDTO);
		 request.setAttribute("pageNo", pageNo);
		 
	   return new ModelAndView("board/Noticeread.jsp");
	}
	
	/**
	 * 수정폼
	 * */
	public ModelAndView updateForm(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String noticeNo = request.getParameter("noticeNo");
		NoticeDTO elec = notService.selectByNoticeCode(Integer.parseInt(noticeNo));
		request.setAttribute("elec", elec);
		
		
	   return new ModelAndView("elec/update.jsp");
	}
	
	/**
	 * 수정하기 
	 * */
	public ModelAndView update(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		String noticeNo = request.getParameter("noticeNo");
		String noticeSubject = request.getParameter("noticeSubject");
		String noticeContent = request.getParameter("noticeContent");
		String noticeDate = request.getParameter("noticeDate");
		String noticeImg = request.getParameter("noticeImg");
	 
		
		NoticeDTO noticeDTO = new NoticeDTO();
			
		notService.update(noticeDTO);
		
		NoticeDTO dbnot = notService.selectByNoticeCode(Integer.parseInt(noticeNo));
		request.setAttribute("elec", dbnot);
		
	return null;
	}
	
	/**
	 * 삭제하기
	 * */
	public ModelAndView delete(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String noticeNo  = request.getParameter("noticeNo");
		
		String path = request.getServletContext().getRealPath("/save");
		
		notService.delete(Integer.parseInt(noticeNo), path);
		
	return null;	
	}	
}
