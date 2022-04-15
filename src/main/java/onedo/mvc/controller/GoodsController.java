package onedo.mvc.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import onedo.mvc.dto.GoodsDTO;
import onedo.mvc.service.GoodsService;

public class GoodsController implements Controller {
	private GoodsService service;
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		return null;
	}
	
	/**
	 * 상품전체검색
	 * */
	public ModelAndView searchSelectAll(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		
		List<GoodsDTO> list = null;
		
		try {
			list = service.selectAll();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		request.setAttribute("list", list);
		return new ModelAndView("index.jsp");
	}
	
	/**
	 * 타입으로상품검색 =selectByGoodsType
	 * */
	public ModelAndView selectGoodsByType(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String goodsType = request.getParameter("goodsType");
		List<GoodsDTO> list = null;
		
		try {
			list =service.selectByGoodsType(goodsType);
		}catch(Exception e) {
			e.printStackTrace();
			//오류메시지
		}
		
		request.setAttribute("list", list);
		return new ModelAndView("shop.jsp");
	}
	
	
	/**
	 * 상품상세보기
	 * */
	public ModelAndView viewDetail(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String goodsCode = request.getParameter("goodsCode");
		GoodsDTO goodsDTO=null;
		
		try {
			goodsDTO=service.selectByGoodsCode(goodsCode, true);
		}catch(Exception e) {
			e.printStackTrace();
			//오류메시지
		}
		System.out.println(goodsDTO);
		request.setAttribute("goods", goodsDTO);
		return new ModelAndView("product-details.jsp");
	}
	
	/**
	 * ++
	 * */
	

}
