package Aula;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/SessionTeste")
public class SessionTeste extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SessionTeste() {
        super();
    }

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		out.println("<html><head>");
		out.println("<title>Teste de Sessao</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h3>Teste de sessão<h3>");
		
		HttpSession session = req.getSession(true);
		
		out.println("Identificador: " + session.getId() + "<br>");
		out.println("Data: " + (new Date(session.getCreationTime())) + "<br>");
		out.println("Último acesso: " + (new Date(session.getLastAccessedTime())) + "<br>");
		
		String nomedado = req.getParameter("nomedado");
		String valordado = req.getParameter("valordado");
		
		if (nomedado != null && valordado != null) {
			session.setAttribute(nomedado, valordado);
		}
		
		out.println("<P>");
		out.println("Dados da sessao: " + "<br>");
		Enumeration valueNames = session.getAttributeNames();
		
		while (valueNames.hasMoreElements()) {
			String name = (String) valueNames.nextElement();
			String value = (String) session.getAttribute(name);
			out.println(name + " = " + value + "<br>");
		}
		
		out.println("<P>");
		out.print("<form action=\"SessionTeste\" method=POST>");
		out.println("Nome: <input type=text length=20 name=nomedado><br>");
		out.println("Valor: <input type=text length=20 name=valordado><br>");
		out.println("<input type=submit></form>");
		
		out.println("</body>");
		out.println("</html>");

	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}

}
