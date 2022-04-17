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
	 * 타입으로상품검색 =selectByGoodsType
	 * */
	public ModelAndView selectGoodsByType(HttpServletRequest request, HttpServletResponse response){
		String goodsType = request.getParameter("goodsType");
		List<GoodsDTO> list = null;
		
		try {
			list =service.selectByGoodsType(goodsType);
		}catch(Exception e){
			e.printStackTrace();
			return new ModelAndView("error/error.jsp");
		}
		
		request.setAttribute("list", list);
		return new ModelAndView("shop.jsp");
	}
	
	/**
	 * 상품코드로검색 =selectByGoodsCode
	 * */
	public ModelAndView selectByGoodsCode(HttpServletRequest request, HttpServletResponse response){
		response.setContentType("text/html;charset=UTF-8");
		
		String goodsCode = request.getParameter("goodsCode");
		GoodsDTO goodsDTO = null;
		
		try {
			goodsDTO = service.selectByGoodsCode(goodsCode, false);
		}catch(Exception e){
			e.printStackTrace();
			return new ModelAndView("error/error.jsp");
		}
		
		request.setAttribute("goodsDTO", goodsDTO);
		return new ModelAndView("product-details.jsp");
	}
	
	/**
	 * ++
	 * */
	

}
