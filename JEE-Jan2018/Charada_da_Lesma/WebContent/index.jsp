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
	int dias = 0;
	int metros = 0;
	int tamanho = 10;

	while ( metros < tamanho ) {		
		metros += 2;
		if ( metros >= tamanho ) {
			
		} else {
			metros -= 1;
		}
		dias ++;		
	}
	%>
	<br>Em <%=dias%> dias a lesma sobe o muro
	<%
	%>
	

</body>
</html>

