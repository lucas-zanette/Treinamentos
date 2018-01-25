<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Insert title here</title>
</head>
<body>
<H1>Id da sessao: <%= session.getId() %></H1>
<%
	String nome = request.getParameter("nome");
	String telefone = request.getParameter("telefone");
	
	if (nome != null && nome.length() > 0) 
		session.setAttribute("nome", nome);
	
	if (telefone != null && telefone.length() > 0)
		session.setAttribute("telefone", telefone);
%>
<FORM TYPE=POST ACTION=sessao1.jsp>
<INPUT TYPE=submit name=submit value="Retorna">
</FORM>
</body>
</html>