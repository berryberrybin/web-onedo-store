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
import onedo.mvc.dto.ReviewDTO;
import onedo.mvc.service.ReviewService;
import onedo.mvc.service.ReviewServiceImpl;

public class AjaxReviewController implements AjaxController {
	ReviewService service = new ReviewServiceImpl();
	@Override
	public void handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

	}

	/**
	 * 상품코드에 해당하는 모든 후기 검색
	 * */
	public void selectByGoodsCode(HttpServletRequest request, HttpServletResponse response) throws Exception{
		response.setContentType("text/html;charset=UTF-8");
		
		String goodsCode = request.getParameter("goodsCode");
		//String pageNo = request.getParameter("pageNo");
		
		List<ReviewDTO> list= service.selectByGoodsCode(Integer.parseInt(goodsCode));
		//request.setAttribute("pageNo", pageNo);
		
		JSONArray arr = JSONArray.fromObject(list);
		
		System.out.println(list);
		PrintWriter out = response.getWriter();
		out.print(arr);
		
		
	}
}
