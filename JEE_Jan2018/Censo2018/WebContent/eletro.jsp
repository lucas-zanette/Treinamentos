<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="control.BdFactory"%>
<%@page import="java.sql.Connection"%>
<%@page import="control.Sessao"%>
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
	
	//gravar os dados da pessoa
	Connection con = BdFactory.getInstance().getConnection();
	PreparedStatement ps;
	try {
		ps = con.prepareStatement("insert into Pessoas (nome, endereco, email) values (?, ?, ?)");		
		ps.setString(1, request.getParameter("nome"));
		ps.setString(2, request.getParameter("endereco"));
		ps.setString(3, request.getParameter("email"));

		ps.execute();		
		
	} catch  (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}	
	
	//resgata ultimo codigo da pessoa
	ps = con.prepareStatement("select last_insert_id();");
	ResultSet rs = ps.executeQuery();
	int codPessoa = 0;
	if (rs.next()) {
   		codPessoa = rs.getInt(1);
	}
    
   	//salva na sessao o codigo da pessoa
	session.setAttribute("cod", new Integer(codPessoa));
   	
   	ps.close();
   	con.close();
	
	%>
	<form method="POST" action="pet.jsp">
	<H1>Eletro</H1>
	<br>
	Nome: <input type="text" size="20" name="nome"><br>
	Quantidade: <input type="text" size="20" name="qtd"><br>	
	<br>
		
	<INPUT TYPE=submit name=submit value="Próximo">
	</form>

</body>
</html>