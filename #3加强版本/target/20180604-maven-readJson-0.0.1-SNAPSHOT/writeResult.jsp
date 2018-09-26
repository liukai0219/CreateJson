<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String result = (String) session.getAttribute("result");
		String onLineCount = (String) session.getAttribute("onLineCount");
		String totalReqCount = (String) session.getAttribute("totalReqCount");
	%>
	执行结果：<%=result %><br>
	在线人数：<%=onLineCount %><br>
	总访问人数：<%=totalReqCount %><br>
</body>
</html>