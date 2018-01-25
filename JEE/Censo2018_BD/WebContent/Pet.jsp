<%@page import="control.BD_Gerenciado"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="control.BdFactory"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
	//resgata ultimo codigo da pessoa
	Integer codigoPessoa = (Integer) session.getAttribute("cod");
	
	//gravar os dados da pessoa
	//Connection con = BdFactory.getInstance().getConnection();
	Connection con = BD_Gerenciado.getConnection();
	
	PreparedStatement ps;
	
	try {
		ps = con.prepareStatement("insert into Eletro (nome, qtd, codigopessoa) values (?, ?, ?)");		
		ps.setString(1, request.getParameter("nome"));
		ps.setString(2, request.getParameter("qtd"));
		ps.setInt(3, codigoPessoa);

		ps.execute();		
		
	} catch  (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}	
	
	con.close();
   	%>
		
	<form method="POST" action="Resultado.jsp">
	<H1>Pet</H1>
	<br>
	Nome: <input type="text" size="20" name="nome"><br>
	Espécie: <input type="text" size="20" name="especie"><br>
	Raça: <input type="text" size="20" name="raca"><br>
	<br>
		
	<INPUT TYPE=submit name=submit value="Próximo">
	</form>	
	
</body>
</html>