<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<H1>Pesquisa página 3/3</H1>
	<%
		String nome = request.getParameter("nome");
		String endereco = request.getParameter("endereco");
		String cidade = request.getParameter("cidade");
		String idade = request.getParameter("idade");
		
		if (nome != null && nome.length() > 0) 
			session.setAttribute("nome", nome);
		
		if (endereco != null && endereco.length() > 0)
			session.setAttribute("endereco", endereco);
		
		if (cidade != null && cidade.length() > 0)
			session.setAttribute("cidade", cidade);

		if (idade != null && idade.length() > 0)
			session.setAttribute("idade", idade);
	%>
	<H1>Responda</H1>
	Qual editora preferida: <input type="text" size="20" name="livro"><br>
	Qual marca de sorvete preferida: <input type="text" size="20" name="sorvete"><br>
	<br>	
	

	<FORM TYPE=POST ACTION=resultado.jsp>
	<INPUT TYPE=submit name=submit value="Proxima">	
	</FORM>

	<FORM TYPE=POST ACTION=pagina2.jsp>
	<INPUT TYPE=submit name=submit value="Retorna">	
	</FORM>


</body>
</html>