<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
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

	double valorM2;
	double saldoCC;
	
	valorM2	= Double.parseDouble(request.getParameter("valorM2"));
	saldoCC = Double.parseDouble(request.getParameter("saldoCC"));
			
 	List<Terreno> lst = new ArrayList<Terreno>();

 	Terreno t = new Terreno(t.setLargura(Double.parseDouble(request.getParameter("largura1"))), 
 							t.setComprimento(Double.parseDouble(request.getParameter("comprimento1"))), 
 							valorM2); 	
 	lst.add(t);

 	
	
	double area1 = largura1 * comprimento1;
	double area2 = largura2 * comprimento2;
	double area3 = largura3 * comprimento3;

	double m2_terreno1 = valor1 / area1;
	double m2_terreno2 = valor2 / area2;
	double m2_terreno3 = valor3 / area3;

	
	
		
	
		%>
		<h1>Terreno 1</h1>
		<lin>Area: <%=largura1%></lin><br>
		<lin>Valor: <%=comprimento1%></lin><br>
		<%
		
		%>
		<h1>Terreno 2</h1>
		<lin>Area: <%=largura1%></lin><br>
		<lin>Valor: <%=comprimento1%></lin><br>
		<%
		
		%>
		<h1>Terreno 3</h1>
		<lin>Area: <%=largura1%></lin><br>
		<lin>Valor: <%=comprimento1%></lin><br>
		<%
				
%>

<br>

<form type=POST action=index.jsp>
<input type=submit name=submit value="Retorna">
</form>


</body>
</html>