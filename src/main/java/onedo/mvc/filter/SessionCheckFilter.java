package onedo.mvc.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;

// 작성 
// Servlet Filter implementation class SessionCheckFilter
@WebFilter(urlPatterns = { "/*" })
public class SessionCheckFilter extends HttpFilter implements Filter {
	
	public SessionCheckFilter() {}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		
		//사전처리
		//사후처리는 필요 없음  
		chain.doFilter(request, response);
	}

}
