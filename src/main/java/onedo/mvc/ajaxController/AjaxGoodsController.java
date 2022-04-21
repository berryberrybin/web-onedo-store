package onedo.mvc.ajaxController;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import net.sf.json.JSONArray;

import onedo.mvc.dao.GoodsDAO;
import onedo.mvc.dao.GoodsDAOImpl;
import onedo.mvc.dto.GoodsAttrDTO;
import onedo.mvc.dto.GoodsDTO;
import onedo.mvc.service.GoodsService;
import onedo.mvc.service.GoodsServiceImpl;


public class AjaxGoodsController implements AjaxController {
	GoodsService goodsService = new GoodsServiceImpl();
    GoodsDAO goodsDAO = new GoodsDAOImpl();
	
	@Override
	public void handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}
	
	/**
	 * 상품등록
	 * */
	public void insert(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		int result =0 ;
		
		//goodsDTO에 들어갈 내용
		String goodsType = request.getParameter("goodsType");
		String goodsName = request.getParameter("goodsName");
		String goodsPrice = request.getParameter("goodsPrice");
		String goodsStock = request.getParameter("goodsStock");
		String goodsDetail = request.getParameter("goodsDetail");
		String isSoldout = request.getParameter("isSoldout");
		
		//goodsAttrDTO에 들어갈 내용
		String sour = request.getParameter("sour");
		String sweet = request.getParameter("sweet");
		String aroma = request.getParameter("aroma");
		String body = request.getParameter("body");
		
		System.out.println("sour"+sour);
		
		GoodsAttrDTO goodsAttrDTO = new GoodsAttrDTO(Integer.parseInt(sour),
				Integer.parseInt(sweet), Integer.parseInt(aroma), Integer.parseInt(body));
		
	    GoodsDTO goodsDTO = new GoodsDTO(goodsType,goodsName, Integer.parseInt(goodsPrice), Integer.parseInt(goodsStock),
	    goodsDetail, Integer.parseInt(isSoldout), goodsAttrDTO ); 
	    
	    result =goodsService.insert(goodsDTO, goodsAttrDTO); 

	    PrintWriter out = response.getWriter(); 
	    out.print(result); //0,1
	    
	}
	
	/**
	 * 상품 수정
	 * */
	public void update(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		//goodsDTO에 들어갈 내용
		String goodsCode = request.getParameter("goodsCode");
		String goodsType = request.getParameter("goodsType");
		String goodsName = request.getParameter("goodsName");
		String goodsPrice = request.getParameter("goodsPrice");
		String goodsStock = request.getParameter("goodsStock");
		String goodsDetail = request.getParameter("goodsDetail");
		String isSoldout = request.getParameter("isSoldout");
		
		//goodsAttrDTO에 들어갈 내용
		String sour = request.getParameter("sour");
		String sweet = request.getParameter("sweet");
		String aroma = request.getParameter("aroma");
		String body = request.getParameter("body");
		
		GoodsAttrDTO goodsAttrDTO = new GoodsAttrDTO(Integer.parseInt(goodsCode), 
				Integer.parseInt(sour), Integer.parseInt(sweet), Integer.parseInt(aroma), Integer.parseInt(body));
		
	    GoodsDTO goodsDTO = new GoodsDTO(Integer.parseInt(goodsCode), goodsType,
	    goodsName, Integer.parseInt(goodsPrice), Integer.parseInt(goodsStock),
	    goodsDetail, Integer.parseInt(isSoldout)); 
	    
	    int result = goodsService.update(goodsDTO, goodsAttrDTO); 

	    PrintWriter out = response.getWriter(); 
	    out.print(result);
	   
	    
	}
	
	

	/**
	 * 상품삭제 (soldout의 상태를 2로 변경)
	 * */
	public void delete(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
	   
		String goodsCode = request.getParameter("goodsCode");
	    //System.out.println("goodsCode = " + goodsCode);
	    
	    goodsService.delete(Integer.parseInt(goodsCode));
		
	}
	
	/**
	 * 상품조회(전체)
	 * */
	public void selectAll(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		response.setContentType("text/html;charset=UTF-8");
		
		List<GoodsDTO> list = null;
		
		list = goodsService.selectAll();
		System.out.println("sour = "+list.get(0).getGoodsAttrDTO().getSour());
		System.out.println("sweet = "+list.get(0).getGoodsAttrDTO().getSweet());
		System.out.println("aroma = "+list.get(0).getGoodsAttrDTO().getAroma());
		System.out.println("body = "+list.get(0).getGoodsAttrDTO().getBody());
	
		//System.out.println(list);
		JSONArray arr = JSONArray.fromObject(list);
		
		
		PrintWriter out = response.getWriter();
		out.print(arr);
		
		
		
	}
	
	

	
}
