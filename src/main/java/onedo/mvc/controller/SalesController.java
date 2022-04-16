package onedo.mvc.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import onedo.mvc.dto.SalesDTO;
import onedo.mvc.service.SalesService;
import onedo.mvc.service.SalesServiceImpl;

public class SalesController implements Controller {

	private SalesService salesService = new SalesServiceImpl();
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response){
		// TODO Auto-generated method stub
				return null;
	}
	
	
	/**
	 * 상품별 매출 조회
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	
	public ModelAndView selectByGoodsCode(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		List<SalesDTO> salesList = null;
		
		try {
			salesList = salesService.selectGroupByGoodsCode();
		}catch(Exception e){
			e.printStackTrace();
			return new ModelAndView("error/error.jsp");
		}

		request.setAttribute("salesList", salesList);

		String result="";
		for(SalesDTO sales : salesList) {
			if(result!="") {
				result+=",";
			}
			result += "['"+sales.getGoodsName()+"', "+sales.getOrderQuantity()+"]";
		}
		request.setAttribute("result", result);
		

		return new ModelAndView("adminSales.jsp");
	}

public ModelAndView selectByOrderDate(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		List<SalesDTO> salesList = null;
		
		try {
			salesList = salesService.selectGroupByOrderDate();
		}catch(Exception e){
			e.printStackTrace();
			return new ModelAndView("error/error.jsp");
		}

		request.setAttribute("salesList", salesList);

		String result="";
		for(SalesDTO sales : salesList) {
			if(result!="") {
				result+=",";
			}
			result += "['"+sales.getOrderDate()+"', "+sales.getOrderPrice()+"]";
		}
		request.setAttribute("result", result);
		

		return new ModelAndView("adminDailySales.jsp");
	}


}
