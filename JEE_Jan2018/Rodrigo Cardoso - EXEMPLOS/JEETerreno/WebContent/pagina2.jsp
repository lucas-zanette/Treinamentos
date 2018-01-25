<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="aula.OrdenaTerreno"%>
<%@page import="java.util.Collections"%>
<%@page import="aula.Terreno"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<H1>Resultado</H1>
	<br>
	<%
	double valorM2;
	double saldoCC;
	
	valorM2 = Double.parseDouble(request.getParameter("valorM2"));
	saldoCC = Double.parseDouble(request.getParameter("saldoCC"));
	
	List<Terreno> lst = new ArrayList<Terreno>();

	Terreno t = new Terreno(
			Double.parseDouble(request.getParameter("larg1")),
			Double.parseDouble(request.getParameter("comp1")),
			valorM2
			);
	lst.add(t);

	t = new Terreno(
			Double.parseDouble(request.getParameter("larg2")),
			Double.parseDouble(request.getParameter("comp2")),
			valorM2
			);
	lst.add(t);

	t = new Terreno(
			Double.parseDouble(request.getParameter("larg3")),
			Double.parseDouble(request.getParameter("comp3")),
			valorM2
			);
	lst.add(t);
	
	for (int i = 1; i <= lst.size(); i++) {
		t = lst.get(i - 1);
		%>
		<H3>Terreno <%=i %></H3>
		<br>
		<lin>Largura: <%=t.getLargura()%></lin><br>
		<lin>Comporimento: <%=t.getComprimento()%></lin><br>
		<lin>Area: <%=t.getArea()%></lin><br>
		<lin>Preco: <%=t.getPreco()%></lin><br>
		<br>
		<%
	}
	%>
	<H1>Outros dados</H1>
	<br>
	<lin>Valor do m2: <%=valorM2 %></lin><br>
	<lin>Saldo em CC: <%=saldoCC %></lin><br>
	<br>
	<H1>Sugestao de compra</H1>
	<br>
	<%
	//Ordena a lista.
	Collections.sort(lst, new OrdenaTerreno());
	
	//Mostra em tela quais terrenos comprar.
	for (Terreno o : lst) {
		if (saldoCC > o.getPreco()) {
			//Atualiza o saldo da conta.
			saldoCC -= o.getPreco();
			
			//Mostra em tela qual o terreno.
			%>
			<lin><%=o.getLargura() + " x " + o.getComprimento() + " (Area de " + o.getArea() + " m2, e preco de R$ " + o.getPreco() + ")" %></lin><br>
			<%
		} else {
			break;
		}
	}
	%>
	<br>
	<lin>Saldo remanescente: <%=saldoCC %></lin>	
</body>
</html>