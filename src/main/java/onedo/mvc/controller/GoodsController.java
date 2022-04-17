package onedo.mvc.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
	 *  상품이름이나 타입으로 상품검색
	 * */
	public ModelAndView selectMulipleGoods(HttpServletRequest request, HttpServletResponse response){
		String searchField = request.getParameter("searchField");
		String searchValue = request.getParameter("searchValue");
		List<GoodsDTO> list = null;
		
		try {
			list =service.selectMulipleGoods(searchField,searchValue);
		}catch(Exception e){
			e.printStackTrace();
			return new ModelAndView("error/error.jsp");
		}
		
		request.setAttribute("list", list);
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
}
