<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Exemplo</title>
</head>
<body>
<H1>Session id: <%= session.getId() %></H1>
	<% 
	int count = 0;
	int dcount = 0;

	Cookie[] cookies = request.getCookies();

	if (cookies != null) {
		for (int i = 0; i < cookies.length; i++) { %>
			Value: <%= cookies[i].getValue() %><br>
			Antiga idade maxima em segundos: <%= cookies[i].getMaxAge() %><br>
			<% cookies[i].setMaxAge(5); %>
			Nova idade maxima em segundos: <%=cookies[i].getMaxAge() %><br>
		<% 
		count++;
		}
	}
	response.addCookie(new Cookie("nome" + ++count, "Valor " + ++dcount));
	%>
</body>
</html>