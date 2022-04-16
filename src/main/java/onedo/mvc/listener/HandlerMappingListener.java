package onedo.mvc.listener;

import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import onedo.mvc.ajaxController.AjaxController;
import onedo.mvc.controller.Controller;

//서버가 start될때 각각의 controller의 구현체를 미리 생성해서 Map에 저장하는 역할
 
@WebListener
public class HandlerMappingListener implements ServletContextListener {

	public void contextInitialized(ServletContextEvent sce) {

		Map<String, Controller> map = new HashMap<String, Controller>();

		Map<String, Class<?>> clzMap = new HashMap<String, Class<?>>();
		
		Map<String, AjaxController> ajaxMap = new HashMap<String, AjaxController>();

		Map<String, Class<?>> ajaxClzMap = new HashMap<String, Class<?>>();

		
		ServletContext application = sce.getServletContext();
		String fileName = application.getInitParameter("fileName");

		ResourceBundle rb = ResourceBundle.getBundle(fileName);
		try {
			for (String key : rb.keySet()) {
				String value = rb.getString(key);
				System.out.println(key + " = " + value);

				Class<?> className = Class.forName(value);
				Controller controller=null;
				AjaxController ajaxController=null;
				if(className.getDeclaredConstructor().newInstance() instanceof Controller) {
					controller = (Controller) className.getDeclaredConstructor().newInstance();
					map.put(key, controller);
					clzMap.put(key, className);
				}else if(className.getDeclaredConstructor().newInstance() instanceof AjaxController) {
					ajaxController = (AjaxController) className.getDeclaredConstructor().newInstance();
					ajaxMap.put(key, ajaxController);
					ajaxClzMap.put(key, className);
				}


			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		application.setAttribute("map", map);
		application.setAttribute("clzMap", clzMap);
		application.setAttribute("ajaxMap", ajaxMap);
		application.setAttribute("ajaxClzMap", ajaxClzMap);
		application.setAttribute("path", application.getContextPath());//${path}
	}
}




































