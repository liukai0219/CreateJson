<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="WriteJson" method="get">
		WriteJson1：<input type="submit" value="submit" />
	</form>
	
	<form action="ReadJson" method="get">
		ReadJson：<input type="text" name="url" value=""/>
		<input type="submit" value="submit" />
	</form>
	
	<form action="ServletTest" method="get">
		ServletTest：
		<table>
		  <tr><td><input type="checkbox" value="0" id="allCheck" name="checks"> 全选</td></tr>
		  <tr><td></td></tr>
		  <tr><td><input type="checkbox" value="A" name="checks"> A</td></tr>
		  <tr><td></td></tr>
		  <tr><td><input type="checkbox" value="B" name="checks"> B</td></tr>
		  <tr><td></td></tr>
		  <tr><td><input type="checkbox" value="C" name="checks"> C</td></tr>
		  <tr><td></td></tr>
		  <tr><td><input type="checkbox" value="D" name="checks"> D</td></tr>
		</table>
		<input type="text" name="testname"/> 
		<input type="submit" value="submit" />
	</form>
</body>
</html>