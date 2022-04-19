package onedo.mvc.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import onedo.mvc.dto.ReviewDTO;
import onedo.mvc.service.ReviewService;
import onedo.mvc.service.ReviewServiceImpl;

public class ReviewController implements Controller {
	private ReviewService revService = new ReviewServiceImpl();
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 *  전체검색하기 
	 * */
	public ModelAndView select(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String pageNo = request.getParameter("pageNo");//현재페이지번호 
		if(pageNo==null || pageNo.equals("")) {
			pageNo="1";
		}
		
		List<ReviewDTO> revList = revService.selectAll(Integer.parseInt(pageNo));
		
		 request.setAttribute("list", revList);
		    request.setAttribute("pageNo", pageNo); //뷰에서 사용하기 위해서 ${pageNo}
	
		    return null; // 전체검색 후 위치 변경
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
	  		String reviewNo = m.getParameter("review_no"); 
	  		String userId = m.getParameter("user_id"); 
	  		String reviewSubject = m.getParameter("review_subject"); 
	  		String reviewContent = m.getParameter("review_content"); 
	  		String reviewDate = m.getParameter("review_date"); 
	  		String reviewImg = m.getParameter("review_img"); 
	  		String reviewScore = m.getParameter("review_score"); 
	  		String goodsCode = m.getParameter("goods_code"); 
	  		
	  		ReviewDTO elec = new ReviewDTO(Integer.parseInt(reviewNo),Integer.parseInt(goodsCode),userId,reviewSubject,reviewContent,reviewDate,reviewImg,Integer.parseInt(reviewScore));
	  		
	  		//파일첨부가되었다면...
	  		if(m.getFilesystemName("file") != null) {
	  			//파일이름 저장
	  			elec. setFname(m.getFilesystemName("file"));
	  			
	  			//파일크기 저장
	  			elec.setFsize((int)m.getFile("file").length());
	  		}
	  		
	  		revService.insert(elec);
	  		
	  		
	  		return new ModelAndView("front", true);
	  	}
	    
	/**
	 * 상품코드에 해당하는 후기 검색
	 * */
	/*public ModelAndView selectByGoodsCode(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String goodsCode = request.getParameter("goodsCode");
		String pageNo = request.getParameter("pageNo");
		
		List<ReviewDTO> list= revService.selectByGoodsCode(Integer.parseInt(goodsCode));
		 request.setAttribute("list", list);
		 request.setAttribute("pageNo", pageNo);
		 
	   return new ModelAndView("elec/read.jsp");
	}*/
	
	/**
	 * 수정폼
	 * */
	public ModelAndView updateForm(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String goodsCode = request.getParameter("goodsCode");
		//selectByReviewNo메소드 필요
		/*ReviewDTO elec = revService.selectByGoodsCode(Integer.parseInt(goodsCode));
		request.setAttribute("elec", elec);*/
		
		
	   return new ModelAndView("elec/update.jsp");
	}
	/**
	 * 수정하기 
	 * */
	public ModelAndView update(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String reviewNo = request.getParameter("reviewNo"); 
		String userId = request.getParameter("userId"); 
		String reviewSubject = request.getParameter("reviewSubject"); 
		String reviewContent = request.getParameter("reviewContent"); 
		String reviewDate = request.getParameter("reviewDate"); 
		String reviewImg = request.getParameter("reviewImg"); 
		String reviewScore = request.getParameter("reviewScore"); 
		String goodsCode = request.getParameter("goodsCode"); 
	 
		
		ReviewDTO reviewDTO = new ReviewDTO(Integer.parseInt(reviewNo),Integer.parseInt(goodsCode),userId,reviewSubject,reviewContent,reviewDate,reviewImg,Integer.parseInt(reviewScore));
			
		revService.update(reviewDTO);
		//selectByReviewNo메소드 필요
		//ReviewDTO dbrev = revService.selectByGoodsCode(Integer.parseInt(reviewNo));
		//request.setAttribute("elec", dbrev);
		
	return null;
	}
	/**
	 * 삭제하기
	 * */
	public ModelAndView delete(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String reviewNO  = request.getParameter("reviewNO");
		
		String path = request.getServletContext().getRealPath("/save");
		
		revService.delete(Integer.parseInt(reviewNO), path);
		
	return null;	
	}	
	
}
