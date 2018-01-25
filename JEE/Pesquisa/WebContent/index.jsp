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

	<h3>Se identifique</h3>
	
	<%
	session.getId();
	session.getCreationTime();
	session.setMaxInactiveInterval(360);

	session.getMaxInactiveInterval();
	
	Enumeration atribs = session.getAttributeNames();
	while (atribs.hasMoreElements()) {
		String atrib = (String) atribs.nextElement();
		String valor = (String) session.getAttribute(atrib); 
		atrib = valor;
	}
	%>
		
	<form method="POST" action="pagina2.jsp">
		Nome: <input type="text" size="20" name="nome"><br>
		Endereco: <input type="text" size="20" name="endereco"><br>
		Cidade: <input type="text" size="20" name="cidade"><br>		
		Idade: <input type="text" size="20" name="idade"><br>
		<br>
		
		<FORM TYPE=POST ACTION=pagina3.jsp>
		<INPUT TYPE=submit name=submit value="Proxima">	
		</FORM>
	
		<FORM TYPE=POST ACTION=pagina1.jsp>
		<INPUT TYPE=submit name=submit value="Retorna">	
		</FORM>
	</form>
	


</body>
</html>