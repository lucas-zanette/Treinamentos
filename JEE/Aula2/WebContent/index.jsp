<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Numeros primos em JSP</title>
</head>
<body>

	Números primos: 
	
	<% 
	
	for (int i=1; i<=20; i++) {

		int primo = Integer.valueOf( i );
		boolean isPrimo = true;
		int divisor = 0;		
		
		for (int j=2; j<=primo; j++) {			
			if ( ( (primo % j) == 0) && (j != primo) ) {
				isPrimo = false;
				divisor = j;				
				break;
			}
				
		}
		
		if (isPrimo) {			
	%>			
			<%=i%>		
		<%}%>
	<%}%>
	
	
	
</body>
</html>