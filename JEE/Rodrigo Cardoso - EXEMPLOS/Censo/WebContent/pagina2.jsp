<%@page import="aula.Biblioteca"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Página do Censo</title>
</head>
<body>
	<% Biblioteca.salvaParamNaSessao(session, request); %>
	
	<H1>Censo 2018</H1>
	<br>
	<H3>Eletrodomésticos</H3>
	<br>
	<form method="POST" action="pagina3.jsp">
	Nome: <input type="text" size="20" name="EletroNome1"><br>
	Qtd: <input type="text" size="20" name="EletroQtd1"><br>
	<br>
	Nome: <input type="text" size="20" name="EletroNome2"><br>
	Qtd: <input type="text" size="20" name="EletroQtd2"><br>
	<br>
	Nome: <input type="text" size="20" name="EletroNome3"><br>
	Qtd: <input type="text" size="20" name="EletroQtd3"><br>
	<br>
	<INPUT TYPE=submit name=submit value="envie">
	</form>	

</body>
</html>