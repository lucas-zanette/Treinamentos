<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>População do Brasil - EUA</title>
</head>
<body>

	
	<%
	int i = 2016;
	int j = 0;
	
	double brasil=207;
	double eua=323;
	
	while (brasil < eua) {
		brasil = brasil*1.1;
		eua = eua*1.03;
		i++;
		j++;
		%>
		<br>ano: <%=i%> 
		<br>população Brasil <%=brasil%>
		<br>popuçação EUA    <%=eua%>
		<br>
		<%
	}
	%>
	
	<br>Brasil passará os EUA em população em <%=j%> anos

</body>
</html>