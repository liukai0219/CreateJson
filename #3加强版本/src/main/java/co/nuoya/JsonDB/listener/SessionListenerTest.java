package co.nuoya.JsonDB.listener;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionListenerTest implements HttpSessionListener, HttpSessionAttributeListener {

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		System.out.println("新创建了一个session-----" + se.toString());
		//在线人数加1
		ServletContext context = se.getSession().getServletContext();
		context.setAttribute("onLineCount", (int)context.getAttribute("onLineCount")+1);
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		System.out.println("session被销毁-----" + se.toString());
		//在线人数减1
		ServletContext context = se.getSession().getServletContext();
		context.setAttribute("onLineCount", (int)context.getAttribute("onLineCount")-1);
	}

	@Override
	public void attributeAdded(HttpSessionBindingEvent se) {
		System.out.println("向session添加了属性" + se.getName() + ":" + se.getValue() + "-----" + se.toString());
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent se) {
		System.out.println("从session删除了属性" + se.getName() + ":" + se.getValue() + "-----" + se.toString());
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent se) {
		System.out.println("修改了session属性" + se.getName() + ":" + se.getValue() + "-----" + se.toString());		
	}

}
