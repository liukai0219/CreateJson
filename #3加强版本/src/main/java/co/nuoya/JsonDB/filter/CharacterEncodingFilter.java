package co.nuoya.JsonDB.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import com.mysql.jdbc.StringUtils;

import co.nuoya.JsonDB.util.Utils;

public class CharacterEncodingFilter implements Filter {
	private String encoding = "";
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		encoding = filterConfig.getInitParameter("CharacterEncoding");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		if (!StringUtils.isNullOrEmpty(encoding)) {
			Utils.getFileLogger().debug("原字符编码为：{}",request.getCharacterEncoding());
			request.setCharacterEncoding(encoding);
			response.setCharacterEncoding(encoding);//不设置的话默认为ISO-8859-1
			Utils.getFileLogger().debug("设置字符编码为：{}",encoding);
		}
		chain.doFilter(request, response);
		Utils.getFileLogger().debug("response字符编码为：{}",response.getCharacterEncoding());
	}

	@Override
	public void destroy() {
		encoding = "";
	}

}
