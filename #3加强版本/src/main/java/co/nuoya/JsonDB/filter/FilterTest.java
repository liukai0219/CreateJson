package co.nuoya.JsonDB.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class FilterTest implements Filter {
	private String i = "";
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		i = "Filter属性在init方法中被初始化了！";
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
			System.out.println("doFilter : " + i);
			chain.doFilter(request, response);
			System.out.println("after servlet service doFilter : " + i);
	}

	@Override
	public void destroy() {
	}

}
