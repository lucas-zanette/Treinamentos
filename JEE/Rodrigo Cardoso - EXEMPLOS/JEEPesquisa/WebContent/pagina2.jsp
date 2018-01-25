<%@page import="aula.Biblioteca"%>
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
	<form method="POST" action="pagina3.jsp">
	<H1>Pesquisa</H1>
	<br>
	<H3>Diga suas preferências</H3>
	<br>
	Livro preferido: <input type="text" size="20" name="livroPref"><br>
	Sorvete preferido: <input type="text" size="20" name="sorvetePref"><br>
	Cor preferida: <input type="text" size="20" name="corPref"><br>
	<br>
	<INPUT TYPE=submit name=submit value="Próximo">
	</form>
</body>
</html>