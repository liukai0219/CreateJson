package co.nuoya.JsonDB.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.nuoya.JsonDB.model.Customer;
import co.nuoya.JsonDB.service.CustomerService;
import co.nuoya.JsonDB.service.CustomerServiceImpl;
import co.nuoya.JsonDB.util.Utils;

public class WriteJson extends HttpServlet{
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("name", "Tom");
		req.setAttribute("name", "ABC");
		req.removeAttribute("name");
		
		HttpSession session = req.getSession();
		session.setAttribute("name", "Tom");
		session.setAttribute("name", "ABC");
		session.removeAttribute("name");
		
		ServletContext context = req.getServletContext();
		context.setAttribute("name", "Tom");
		context.setAttribute("name", "ABC");
		context.removeAttribute("name");
		
		session.setAttribute("result", writeJson());
		session.setAttribute("onLineCount", context.getAttribute("onLineCount").toString());
		session.setAttribute("totalReqCount", context.getAttribute("totalReqCount").toString());
		resp.sendRedirect("./writeResult.jsp");
	}
	
	public String writeJson() {
		Utils.getFileLogger().info("writeJson start");
		CustomerService custService = new CustomerServiceImpl();
		List<Customer> resultCust = custService.findCustomer(null);
		String result = Utils.writeListToJson(resultCust);
		Utils.getFileLogger().info("result : {}", result);
		Utils.getFileLogger().info("writeJson end");
		return result;
	}
}
