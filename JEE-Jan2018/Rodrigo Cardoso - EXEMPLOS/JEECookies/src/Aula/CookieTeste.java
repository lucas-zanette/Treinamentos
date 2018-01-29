package Aula;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CookieTeste")
public class CookieTeste extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CookieTeste() {
        super();
    }

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<head><title>Teste de Cookies</title></head>");
		out.println("</body>");
		out.println("<h3>Teste de Cookies</h3>");
		
		Cookie[] cookies = req.getCookies();
		
		if (cookies != null) {
			for (int i = 0; i < cookies.length; i++) {
				Cookie cookie  =cookies[i];
				out.print("Nome do cookie: " + cookie.getName() + "<br>");
				out.print("Valor do cookie: " + cookie.getValue() + "<br><br>");
			}
		}
		
		String cNome = req.getParameter("cookienome");
		String cValor = req.getParameter("cookievalor");
		
		if (cNome != null && cValor != null) {
			Cookie cookie = new Cookie(cNome, cValor);
			res.addCookie(cookie);
			out.println("<P>");
			out.println("<br>");
			out.println("Nome: " + cNome + "<br>");
			out.println("Valor: " + cValor);
		}
		
		out.println("<P>");
		out.print("<form action=\"CookieTeste\" method=POST>");
		out.println("Nome: <input type=text length=20 name=cookienome><br>");
		out.println("Valor: <input type=text length=20 name=cookievalor><br>");
		out.println("<input type=submit></form>");
		
		out.println("</body>");
		out.println("</html>");
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		doGet(req, res);
	}
	
}
