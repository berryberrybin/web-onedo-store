package onedo.mvc.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpFilter;

/**
 * Servlet Filter implementation class EncodingFilter
 */

/**
 * web.xml문서 기준으로 
 * <filter></filter>
 * <filter-mapping></filter-mapping>
 * 이를 대신해주는 것이 @webFilter
 */
@WebFilter(
		urlPatterns = { "/*" }, 
		initParams = { 
				@WebInitParam(name = "encoding", value = "UTF-8")
		})
public class EncodingFilter extends HttpFilter implements Filter {

	private String encodingValue;
	public void init(FilterConfig fConfig) throws ServletException {
		encodingValue=fConfig.getInitParameter("encoding");
		System.out.println("test ="+ encodingValue);
	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		//사전처리
		request.setCharacterEncoding(encodingValue);

		chain.doFilter(request, response);

		//사후처리는 필요 없음  
		
	}

	
}
