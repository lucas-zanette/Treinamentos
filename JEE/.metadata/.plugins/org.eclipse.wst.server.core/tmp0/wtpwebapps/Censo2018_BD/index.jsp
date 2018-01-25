<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="tl" uri="WEB-INF/definicaoTagsAux.tld" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Informações do Censo</title>
</head>
<body>

	<tl:MinhaTag />

	
	<form method="POST" action="eletro.jsp">
	<H1>Pessoa</H1>
	<br>
	<H3>Se identifique</H3>
	<br>
	Nome: <input type="text" size="20" name="nome"><br>
	Endereço: <input type="text" size="20" name="endereco"><br>
	E-mail: <input type="text" size="20" name="email"><br>
	<br>
	
	<INPUT TYPE=submit name=submit value="Próximo">
	</form>	

</body>
</html>