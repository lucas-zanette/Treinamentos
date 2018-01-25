package taglibs;

import java.io.IOException;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class MinhaTagParam extends SimpleTagSupport {
	private String mensagem;
	
	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public void doTag() throws IOException {
		JspWriter out = getJspContext().getOut();
		out.println("<H1>Essa taglib recebeu o parametro: " + getMensagem() + "</H1>");
	}

}
