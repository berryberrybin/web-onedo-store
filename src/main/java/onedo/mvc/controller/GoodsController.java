package onedo.mvc.controller;

import java.io.IOException;

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
		return new ModelAndView("product-details.html");
	}
	
	/**
	 * ++
	 * */
	

}
