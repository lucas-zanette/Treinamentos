<%@page import="java.sql.Connection"%>
<%@page import="aula.BdFactory"%>
<%@page import="java.sql.ResultSet"%>
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
	<% 
	Biblioteca.salvaParamNaSessao(session, request);
	int codPessoa = Biblioteca.salvaCenso(session);
	%>

	<H1>Censo 2018</H1><br>
	<br>
	<H3>Suas respostas foram:</H3><br>
	<br>
	<%
	Connection con = BdFactory.getConnection();
	ResultSet rs = BdFactory.getInstance().execSql(con, "select * from pessoa where codigo = ?", codPessoa);

	while (rs.next()) {
		%>
		Nome: <%= rs.getString("nome") %> <br>
		Endereço: <%= rs.getString("endereco") %> <br>
		E-mail: <%= rs.getString("email") %> <br>
		<br>
		<%
	}
	%>

	<H3>Seus eletrodomésticos:</H3><br>
	<br>
	<%
	rs = BdFactory.getInstance().execSql(con, "select * from eletro where codPessoa = ?", codPessoa);
	
	while (rs.next()) {
		%>
		Nome: <%= rs.getString("nome") %> <br>
		Quantidade: <%= rs.getInt("qtd") %> <br>
		<br>
		<%
	}
	%>

	<H3>Seus pets:</H3><br>
	<br>
	<%
	rs = BdFactory.getInstance().execSql(con, "select * from pet where codPessoa = ?", codPessoa);
	
	while (rs.next()) {
		%>
		Nome: <%= rs.getString("nome") %> <br>
		Espécie: <%= rs.getString("especie") %> <br>
		Raça: <%= rs.getString("raca") %> <br>
		<br>
		<%
	}
	%>

	<br>
	Essa pesquisa foi respondida por <%= BdFactory.getInstance().execSelect(con, "select count(*) from pessoa") %> pessoas.

	<%
	con.close();
	%>
</body>
</html>