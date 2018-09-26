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
		String checksFormSession = (String) session.getAttribute("checks");
		String reasonFormSession = (String) session.getAttribute("reason");
		String checksFormReq = (String) request.getAttribute("checks");
		String reasonFormReq = (String) request.getAttribute("reason");
	%>
	从session取到的数据：<br>
	喜欢的项目：<%=checksFormSession %><br>
	理由：<%=reasonFormSession %><br>
	从req取到的数据：<br>
	喜欢的项目：<%=checksFormReq %><br>
	理由：<%=reasonFormReq %><br>
</body>
</html>