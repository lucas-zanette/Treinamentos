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
	int d = 30;
	int p = 100;
	
	
	while ( p > 50 ) {
		p /= 2;
		d--;
	}
	%>
	
	em <%=d %> dias ele cobre metade do lago
	
	


</body>
</html>