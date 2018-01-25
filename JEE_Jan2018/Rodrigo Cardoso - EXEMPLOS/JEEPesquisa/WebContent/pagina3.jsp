<%@page import="aula.Biblioteca"%>
<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% Biblioteca.salvaParamsSessao(request, session); %>
	<form method="POST" action="pagina4.jsp">
	<H1>Pesquisa</H1>
	<br>
	<H3>Agora falta pouco...</H3>
	<br>
	Qual sua editoria preferida: <input type="text" size="20" name="editoraPref"><br>
	Qual a marca de sorvete preferida: <input type="text" size="20" name="marcaSorvetePref"><br>
	<br>
	<INPUT TYPE=submit name=submit value="Próximo">
	</form>
</body>
</html>