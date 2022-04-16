package onedo.mvc.ajaxController;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import onedo.mvc.controller.ModelAndView;
import onedo.mvc.dao.GoodsDAO;
import onedo.mvc.dao.GoodsDAOImpl;
import onedo.mvc.dto.GoodsDTO;
import onedo.mvc.service.GoodsService;
import onedo.mvc.service.GoodsServiceImpl;


public class AjaxGoodsController implements AjaxController {
	GoodsService goodsService = new GoodsServiceImpl();
	private GoodsDAO goodsDAO = new GoodsDAOImpl();
	@Override
	public void handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}
	
	/**
	 * 상품등록&수정
	 * */
	public void insert(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int result =0 ;
		String goodsCode = request.getParameter("goodsCode");
		String goodsType = request.getParameter("goodsType");
		String goodsName = request.getParameter("goodsName");
		String goodsPrice = request.getParameter("goodsPrice");
		String goodsStock = request.getParameter("goodsStock");
		String goodsDetail = request.getParameter("goodsDetail");
		String isSoldout = request.getParameter("isSoldout");
		String goodsView = request.getParameter("goodsView");
		String goodsImg = request.getParameter("goodsImg");
		
		GoodsDTO goodsDTO = new GoodsDTO(Integer.parseInt(goodsCode), goodsType, goodsName, 
				Integer.parseInt(goodsPrice), Integer.parseInt(goodsStock), goodsDetail, 
				Integer.parseInt(isSoldout), Integer.parseInt(goodsView),goodsImg);
		try {
			result = goodsDAO.insert(goodsDTO);
		}catch(Exception e) {
			e.printStackTrace();
		}
		PrintWriter out = response.getWriter();
		out.print(result); //0,1
		
	}
	

	/**
	 * 상품삭제
	 * */
	public void delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}
	
	/**
	 * 상품전체검색
	 * */
	public void selectAll(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		
		List<GoodsDTO> list = null;
		
		try {
			list = goodsService.selectAll();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		PrintWriter out = response.getWriter();
		out.print(list);
		
		
	}
	
	
}
