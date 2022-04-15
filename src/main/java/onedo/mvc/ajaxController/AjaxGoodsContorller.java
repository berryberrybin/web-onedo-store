package onedo.mvc.ajaxController;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import onedo.mvc.controller.ModelAndView;
import onedo.mvc.dto.GoodsDTO;
import onedo.mvc.service.GoodsService;

public class AjaxGoodsContorller implements AjaxController {
	private GoodsService service;
	@Override
	public void handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}
	
	/**
	 * 상품등록
	 * */
	public void insert(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}
	
	/**
	 * 상품수정
	 * */
	public void update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}
	

	/**
	 * 상품삭제
	 * */
	public void delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}
	
	
	
	/**
	 * 상품코드로검색 =selectByGoodsCode
	 * */
	public void searchselectByGoodsCode(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		
		String goodsCode = request.getParameter("goodsCode");
		GoodsDTO goodsDTO = null;
		
		try {
			goodsDTO = service.selectByGoodsCode(goodsCode, false);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		PrintWriter out = response.getWriter();
		out.print(goodsDTO);
	}
	
	

}
