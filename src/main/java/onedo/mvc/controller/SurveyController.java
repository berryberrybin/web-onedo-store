package onedo.mvc.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import onedo.mvc.dto.GoodsAttrDTO;
import onedo.mvc.service.SurveyService;
import onedo.mvc.service.SurveyServiceImpl;


public class SurveyController implements Controller {
	private SurveyService surveyService = new SurveyServiceImpl();

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub3
		return null;
	}
	
	/**
	 * 설문조사
	 */
	public ModelAndView survey(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String sour = request.getParameter("sour");
		String body = request.getParameter("body");
		String sweet = request.getParameter("sweet");
		String aroma = request.getParameter("aroma");
		System.out.println("sour = " + sour + " body = " + body + " sweet = " + sweet + " aroma = " + aroma);
		
		List<GoodsAttrDTO> list = surveyService.survey(Integer.parseInt(sour), Integer.parseInt(body), Integer.parseInt(sweet), Integer.parseInt(aroma));
		
		request.setAttribute("list", list);
		
		ModelAndView mv = new ModelAndView("survey/recommened.jsp");
		
		return mv;
	}

}
