package aula;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sun.security.x509.IssuingDistributionPointExtension;

@WebServlet("/Primos")
public class Teste extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	public Teste() {
		super();		
	}
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		
		out.println("<html>");
			out.println("<head>");
				out.println("<title>Exemplo de números primos</title>");
			out.println("</head>");
			out.println("<body>");
				out.println("Primos: ");
				
				for (int i=1; i<=20; i++) {
					if (ePrimo(i)) {
						out.println(i);						
					};			
				}
			out.println("</body>");
		out.println("</html>");
	}
	
	private boolean ePrimo(int numero) {
		int primo = Integer.valueOf( numero );
		boolean isPrimo = true;
		int divisor = 0;
		
		for (int i = 2; i <= primo; i++) {
			
			if ( ( (primo % i) == 0) && (i != primo) ) {
				isPrimo = false;
				divisor = i;
				break;
			}
			
		}
		
		if (isPrimo) {
			return true;
		} else {
			return false;
		}
	}
}
