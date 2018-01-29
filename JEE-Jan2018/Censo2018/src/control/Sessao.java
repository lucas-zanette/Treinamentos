package control;

import java.io.FileNotFoundException;
import java.util.Enumeration;
import java.util.Formatter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class Sessao {
	public static void salvaParamsSessao(HttpServletRequest request, HttpSession session) {
		Enumeration params = request.getParameterNames();
		while (params.hasMoreElements()) {
			String param = (String) params.nextElement();
			String valor = (String) request.getParameter(param);

			//Guardo na sessão todos os parâmetros, menos o botão (submit).
			if (!param.equals("submit"))
				session.setAttribute(param, valor);
		}
	}
	
	public static void salvaTexto(String arq, String s) {
		try {
			Formatter f = new Formatter(arq);
			f.format("%s", s);
			f.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
