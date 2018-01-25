<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Insert title here</title>
</head>
<body>
<H1>Formulario</H1>
<H1>Id da sessao: <%= session.getId() %></H1>
<H3><li>Essa sessao foi criada em <%=session.getCreationTime() %></li></H3>
<H3><li>Antigo intervalo de inatividade = <%= session.getMaxInactiveInterval() %></li></H3>

<% session.setMaxInactiveInterval(10); %>

<H3><li>Novo intervalo de inatividade = <%= session.getMaxInactiveInterval() %></li></H3>

<%
	Enumeration atribs = session.getAttributeNames();
	while (atribs.hasMoreElements()) {
		String atrib = (String) atribs.nextElement();
		String valor = (String) session.getAttribute(atrib); %>
		<li><%= atrib %> = <%= valor %></li>
	<% } %>

	<form method="POST" action="sessao2.jsp">
	Nome: <input type="text" size="20" name="nome"><br>
	Telefone: <input type="text" size="20" name="telefone"><br>
	<INPUT TYPE=submit name=submit value="envie">
	</form>	
</body>
</html>
