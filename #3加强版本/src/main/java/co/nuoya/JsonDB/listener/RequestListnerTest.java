package co.nuoya.JsonDB.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

public class RequestListnerTest implements ServletRequestListener, ServletRequestAttributeListener {

	@Override
	public void attributeAdded(ServletRequestAttributeEvent srae) {
		System.out.println("向request添加了属性" + srae.getName() + ":" + srae.getValue() + "-----" + srae.toString());
	}

	@Override
	public void attributeRemoved(ServletRequestAttributeEvent srae) {
		System.out.println("从request删除属性" + srae.getName() + ":" + srae.getValue() + "-----" + srae.toString());
	}

	@Override
	public void attributeReplaced(ServletRequestAttributeEvent srae) {
		System.out.println("修改了request的属性" + srae.getName() + ":" + srae.getValue() + "-----" + srae.toString());
	}

	@Override
	public void requestDestroyed(ServletRequestEvent sre) {
		System.out.println("請求已經結束！" + "-----" + sre.toString());

	}

	@Override
	public void requestInitialized(ServletRequestEvent sre) {
		System.out.println("客戶端向服務器發起了請求" + "-----" + sre.toString());
		ServletContext context = sre.getServletContext();
		context.setAttribute("totalReqCount", (int)context.getAttribute("totalReqCount") + 1);
	}

}
