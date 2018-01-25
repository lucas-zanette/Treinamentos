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
	<H3>Animais de estimação</H3>
	<br>
	<form method="POST" action="resultado.jsp">
	Nome: <input type="text" size="20" name="PetNome1"><br>
	Espécie: <input type="text" size="20" name="PetEspecie1"><br>
	Raça: <input type="text" size="20" name="PetRaca1"><br>
	<br>
	Nome: <input type="text" size="20" name="PetNome2"><br>
	Espécie: <input type="text" size="20" name="PetEspecie2"><br>
	Raça: <input type="text" size="20" name="PetRaca2"><br>
	<br>
	Nome: <input type="text" size="20" name="PetNome3"><br>
	Espécie: <input type="text" size="20" name="PetEspecie3"><br>
	Raça: <input type="text" size="20" name="PetRaca3"><br>
	<br>
	<INPUT TYPE=submit name=submit value="envie">
	</form>	

</body>
</html>