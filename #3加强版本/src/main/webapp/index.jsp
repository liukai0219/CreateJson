<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="WriteJson" method="get">
		WriteJson:<input type="submit" value="submit" />
	</form>
	
	<form action="ReadJson" method="get">
		ReadJson:<input type="text" name="url" value=""/>
		<input type="submit" value="submit" />
	</form>
	
	<form action="ServletTest" method="get">
		ServletTest:<input type="submit" value="submit" />
	</form>
</body>
</html>