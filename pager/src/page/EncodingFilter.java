package page;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * @ClassName: EncodingFilter.java
 * @Description: 字符编码过滤器
 * @version: "1.8.0_131"
 * @author: 寇爽
 * @date: 2017年11月21日 下午7:47:25
 */
public class EncodingFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {

		request.setCharacterEncoding("UTF-8");
	    response.setCharacterEncoding("UTF-8");
	    chain.doFilter(request,response);

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
