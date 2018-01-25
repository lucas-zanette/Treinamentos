<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="POST" action="pagina2.jsp">
	<H1>Dados dos terrenos</H1>
	<br>
	<H3>Terreno 1</H3>
	<br>
	Largura: <input type="text" size="20" name="larg1"><br>
	Comprimento: <input type="text" size="20" name="comp1"><br>
	<br>
	<H3>Terreno 2</H3>
	<br>
	Largura: <input type="text" size="20" name="larg2"><br>
	Comprimento: <input type="text" size="20" name="comp2"><br>
	<br>
	<H3>Terreno 3</H3>
	<br>
	Largura: <input type="text" size="20" name="larg3"><br>
	Comprimento: <input type="text" size="20" name="comp3"><br>
	<br>
	<H3>Outros dados</H3>
	<br>
	Valor do m2: <input type="text" size="20" name="valorM2"><br>
	Saldo em CC: <input type="text" size="20" name="saldoCC"><br>
	<br>
	<INPUT TYPE=submit name=submit value="envie">
	</form>
</body>
</html>