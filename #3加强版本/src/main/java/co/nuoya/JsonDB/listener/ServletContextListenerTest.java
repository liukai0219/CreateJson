package co.nuoya.JsonDB.listener;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ServletContextListenerTest implements ServletContextListener, ServletContextAttributeListener {

	@Override
	public void attributeAdded(ServletContextAttributeEvent scae) {
		System.out.println("向ServletContext添加了属性" + scae.getName() + ":" + scae.getValue() + "-----" + scae.toString());
	}

	@Override
	public void attributeRemoved(ServletContextAttributeEvent scae) {
		System.out.println("从ServletContext删除了属性" + scae.getName() + ":" + scae.getValue() + "-----" + scae.toString());
	}

	@Override
	public void attributeReplaced(ServletContextAttributeEvent scae) {
		System.out.println("修改ServletContext属性" + scae.getName() + ":" + scae.getValue() + "-----" + scae.toString());
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("服务器初始化！" + "-----" + sce.toString());
		//初始化在线人数
		sce.getServletContext().setAttribute("onLineCount", 0);
		//初始化访问次数
		sce.getServletContext().setAttribute("totalReqCount", 0);
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("服务器停止！" + "-----" + sce.toString());
	}

}
