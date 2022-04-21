package onedo.mvc.ajaxController;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import onedo.mvc.controller.ModelAndView;
import onedo.mvc.dto.QnaDTO;
import onedo.mvc.dto.ReviewDTO;
import onedo.mvc.service.QnaService;
import onedo.mvc.service.QnaServiceImpl;
import onedo.mvc.service.ReviewService;
import onedo.mvc.service.ReviewServiceImpl;

public class AjaxQnaController implements AjaxController {
	QnaService service = new QnaServiceImpl();
	@Override
	public void handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	/**
	 * 상품코드에 해당하는 모든 문의 검색
	 * */
	public void selectQnaByGoodsCode(HttpServletRequest request, HttpServletResponse response) throws Exception{
		response.setContentType("text/html;charset=UTF-8");
		
		String goodsCode = request.getParameter("goodsCode");
		//String pageNo = request.getParameter("pageNo");
		
		List<QnaDTO> list= service.selectQnaByGoodsCode(Integer.parseInt(goodsCode));
		//List<QnaDTO> list=null;
		//request.setAttribute("pageNo", pageNo);
		
		JSONArray arr = JSONArray.fromObject(list);
		
		PrintWriter out = response.getWriter();
		out.print(arr);
		
	}
}
