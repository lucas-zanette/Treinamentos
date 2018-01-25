<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="banco.BdFactory"%>
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
	String sabor;
	String marca;
	
	Connection con = BdFactory.getInstance().getConnection();
	PreparedStatement ps;
	try {
		ps = con.prepareStatement("insert into pesquisa_sorvete (sabor, marca) values (?, ?)");
		ps.setString(1, request.getParameter("sabor"));
		ps.setString(2, request.getParameter("marca"));

		ps.execute();
	} catch  (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	ps = con.prepareStatement("select count(*) qtdsabor, sabor from pesquisa_sorvete group by sabor");
   	ResultSet rs = ps.executeQuery();
   	%>
   	<h1>Sabor</h1>
   	<%
   	String qtdsabor;
   	while(rs.next()) {  
       	sabor = rs.getString("sabor");
       	qtdsabor = rs.getString("qtdsabor");
		%>		        	
    		<lin>Sabor: <%= sabor %> <%= qtdsabor %> </lin><br>			    		
		<%   
   	}
	    	
    ps = con.prepareStatement("select count(*) qtdmarca, marca from pesquisa_sorvete group by marca");        
   	rs = ps.executeQuery();
   	%>
   	<h1>Marca</h1>
   	<%
   	String qtdmarca;
   	while(rs.next()) {  
       		        	
       	marca = rs.getString("marca");
       	qtdmarca = rs.getString("qtdmarca");        	
		%>		        	
    		<lin>Marca: <%= marca %> <%= qtdmarca %></lin><br>
		<%  
   	}
    	
	ps = con.prepareStatement("select count(sabor) qtdsabor, sabor from pesquisa_sorvete group by sabor order by qtdsabor desc");
   	rs = ps.executeQuery();
   	%>
   	<h2>Sabor mais Votado</h2>
   	<%   	
   	if (rs.next()) {  
       	sabor = rs.getString("sabor");
		%>		        	
    		<lin>Sabor: <%=sabor%> </lin>			    		
		<%   
   	}
   	
	ps = con.prepareStatement("select count(marca) qtdmarca, marca from pesquisa_sorvete group by marca order by qtdmarca desc");
   	rs = ps.executeQuery();
   	%>
   	<h2>Marca mais Votada</h2>
   	<%   	
   	if (rs.next()) {  
       	marca = rs.getString("marca");
		%>		        	
    		<lin>Marca: <%=marca%> </lin>			    		
		<%   
   	}
   	
   	rs.close();
	con.close();
	%>
	<br>
	<br>
	<FORM TYPE=POST ACTION=index.jsp>
	<INPUT TYPE=submit name=submit value="Retorna">	
	</FORM>

</body>
</html>