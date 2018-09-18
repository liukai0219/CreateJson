package co.nuoya.JsonDB.action;

import java.io.IOException;
import java.util.Arrays;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.nuoya.JsonDB.util.Utils;

public class ServletTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("ServletTest init");
		super.init(config);
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Utils.getFileLogger().debug("req字符编码：{}",req.getCharacterEncoding());
		Utils.getFileLogger().debug("resp字符编码：{}",resp.getCharacterEncoding());
		
		/**
		 * 属性（attribute）在服务器端的组件中利用requst.setAttribute()设置的
		 * 既可以读取亦可以修改，读取可以使用request.setAttribute(),设置可使用request.getAttribute()
		 * 值可以是任意一个Object类型
		 */
		Utils.getFileLogger().debug("返回请求中指定属性的值：{},{}",req.getAttribute("attri1"),req.getAttribute("attri2"));
		Utils.getFileLogger().debug("请求内容的长度：{}",req.getContentLength());
		Utils.getFileLogger().debug("返回请求数据体的MIME类型：{}",req.getContentType());
		/**
		 * 参数（parameter）是从客户端（浏览器）中由用户提供的，若是GET方法是从URL中 提供
		 * 只能读取不能修改，读取可以使用request.getParameter()读取
		 * 在服务器获取时都以String类型看待
		 */
		Utils.getFileLogger().debug("返回指定的参数的值：{}",req.getParameter("testname"));
		//用于能返回多个结果的组件，如checkbox
		Utils.getFileLogger().debug("返回指定参数的值数组：{}",Arrays.toString(req.getParameterValues("checks")));
		Utils.getFileLogger().debug("返回这个请求所用的协议：{}",req.getProtocol());
		Utils.getFileLogger().debug("返回发送请求者的IP地址：{}",req.getRemoteAddr());
		Utils.getFileLogger().debug("返回发送请求者的主机名称：{}",req.getRemoteHost());
		Utils.getFileLogger().debug("返回发送请求者的端口：{}",req.getRemotePort());
		Utils.getFileLogger().debug("返回发送请求者的用户名：{}",req.getRemoteUser());
		Utils.getFileLogger().debug("返回请求所使用的URL的模式：{}",req.getScheme());
		Utils.getFileLogger().debug("返回接收请求的服务器的主机名：{}",req.getServerName());
		Utils.getFileLogger().debug("返回接收请求的端口号：{}",req.getServerPort());
		Utils.getFileLogger().debug("返回发送请求URL：{}",req.getServletPath());
		
		
		
		System.out.println("ServletTest doGet");
		resp.getWriter().append("hello world!");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("ServletTest doPost");
		resp.getWriter().append("hello world!");
	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("ServletTest doDelete");
		super.doDelete(req, resp);
	}
	
	@Override
	protected void doHead(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("ServletTest doHead");
		super.doHead(req, resp);
	}
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("ServletTest doPut");
		super.doPut(req, resp);
	}
	
	@Override
	protected void doOptions(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("ServletTest doOptions");
		super.doOptions(req, resp);
	}
	
	@Override
	protected void doTrace(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("ServletTest doTrace");
		super.doTrace(req, resp);
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("ServletTest service");
		super.service(req, resp);
	}
	
}
