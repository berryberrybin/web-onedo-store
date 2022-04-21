package onedo.mvc.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import onedo.mvc.dto.GoodsAttrDTO;
import onedo.mvc.dto.GoodsDTO;
import onedo.mvc.service.GoodsService;
import onedo.mvc.service.GoodsServiceImpl;

public class GoodsController implements Controller {
	private GoodsService service = new GoodsServiceImpl();
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		return null;
	}
	
	/**
	 * 상품전체검색
	 * */
	public ModelAndView searchSelectAll(HttpServletRequest request, HttpServletResponse response){
		response.setContentType("text/html;charset=UTF-8");
		
		List<GoodsDTO> list = null;
		
		try {
			list = service.selectAll();
		}catch(Exception e){
			e.printStackTrace();
			return new ModelAndView("error/error.jsp");
		}
		
		request.setAttribute("list", list);
		return new ModelAndView("main.jsp");
	}
	
	/**
	 * 판매량 순으로 상품검색
	 * */
	public ModelAndView selectGoodsOrderBySalesRank(HttpServletRequest request, HttpServletResponse response) throws Exception {

		List<GoodsDTO> list = null;

		try {
			list = service.selectGoodsOrderBySalesRank();
		} catch (Exception e) {
			e.printStackTrace();
			return new ModelAndView("error/error.jsp");
		}

		request.setAttribute("list", list);
		return new ModelAndView("main.jsp");
	}
	
	public ModelAndView orderByCondition(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		response.setContentType("text/html;charset=UTF-8");
		
		String orderMethod = request.getParameter("orderMethod");
		
		List<GoodsDTO> list = null;
		try {
			list = service.orderByCondition(Integer.parseInt(orderMethod));
		} catch (Exception e) {
			e.printStackTrace();
			return new ModelAndView("error/error.jsp");
		}

		request.setAttribute("list", list);
		return new ModelAndView("shop.jsp");
	}
	
	/**
	 *  상품이름이나 타입으로 상품검색
	 * */
	public ModelAndView selectMultipleGoods(HttpServletRequest request, HttpServletResponse response){
		String searchField = request.getParameter("searchField");
		String searchValue = request.getParameter("searchValue");
		
		//paging처리하기
		String pageNo = request.getParameter("pageNo"); //현재페이지번호
		if(pageNo==null || pageNo=="") {
			pageNo="1";
		}
		System.out.println("controller의 pageNo = " + pageNo);
		List<GoodsDTO> list = null;
		
		try {
			list =service.selectMultipleGoods(searchField,searchValue,Integer.parseInt(pageNo));
		}catch(Exception e){
			e.printStackTrace();
			return new ModelAndView("error/error.jsp");
		}
		
		request.setAttribute("list", list);
		request.setAttribute("pageNo", pageNo);
		return new ModelAndView("shop.jsp");
	}
	
	/**
	 * 상품코드로검색 =상품상세페이지 조회
	 * */
	public ModelAndView selectByGoodsCode(HttpServletRequest request, HttpServletResponse response){
		response.setContentType("text/html;charset=UTF-8");
		
		String goodsCode = request.getParameter("goodsCode");
		
		//조회수증가여부
		String isIncrement = request.getParameter("isIncrement"); //y이면 증가함, n이면 증가안함
		boolean flag = false;
		if(isIncrement.equals("y")||isIncrement.equals("Y")) flag=true;
		
		GoodsDTO goodsDTO = null;
		try {
			goodsDTO = service.selectByGoodsCode(goodsCode, flag);
		}catch(Exception e){
			e.printStackTrace();
			return new ModelAndView("error/error.jsp");
		}
		
		request.setAttribute("goodsDTO", goodsDTO);
		return new ModelAndView("product-details.jsp");
	}
	
	/** 
	 * 이미지 넣기 insertGoodsImg
	 * */
	public ModelAndView insertGoodsImg(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		
		String saveDir = request.getServletContext().getRealPath("/img");
		int maxSize = 1024 * 1024 * 100;// 100M
		String encoding = "UTF-8";
		
		MultipartRequest m = 
				new MultipartRequest(request, saveDir, maxSize, encoding, new DefaultFileRenamePolicy());

		//전송된 데이터 받기
		String goodsCode = m.getParameter("goodsCode"); //form의 이름과 같게
		
		
		
		GoodsDTO goodsDTO = new GoodsDTO(Integer.parseInt(goodsCode));
		
		System.out.println(goodsCode);
		System.out.println(m.getFilesystemName("goodsImg"));
		//파일첨부를 뺀 데이터들↑ 파일첨부가 되면 ↓
		//getFilesystemName 파일에 대한 정보를 얻어옴. 변경된 이름을 가져오는게 좋음.

	    goodsDTO.setGoodsImg(m.getFilesystemName("goodsImg"));
		  
		service.insertGoodsImg(goodsDTO);
		
		return new ModelAndView("admin/adminGoods.jsp", true);
	}
	
	
}
