<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Página do Censo</title>
</head>
<body>
	<H1>Censo 2018</H1>
	<br>
	<H3>Identifique-se</H3>
	<br>
	<form method="POST" action="pagina2.jsp">
	Nome: <input type="text" size="20" name="nome"><br>
	Endereço: <input type="text" size="20" name="endereco"><br>
	E-mail: <input type="text" size="20" name="email"><br>
	<br>
	<INPUT TYPE=submit name=submit value="envie">
	</form>	
	
</body>
</html>