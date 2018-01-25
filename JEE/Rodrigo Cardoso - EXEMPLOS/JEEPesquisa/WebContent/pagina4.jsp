<%@page import="java.util.Enumeration"%>
<%@page import="aula.Biblioteca"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Pesquisa</title>
</head>
<body>
	<% Biblioteca.salvaParamsSessao(request, session); %>
	<H3>Suas respostas foram registradas. Obrigado!</H3><br>
	<br>
	<%
	String s = "";
	Enumeration atribs = session.getAttributeNames();
	while (atribs.hasMoreElements()) {
		String atrib = (String) atribs.nextElement();
		String valor = (String) session.getAttribute(atrib);%>
		<li><%= atrib %> = <%= valor %></li>
		<%s = s + atrib + " = " + valor + "\n";
	} 
	
	Biblioteca.salvaTexto("/home/aluno/" + session.getId() + ".txt", s);
	%>
</body>
</html>