package taglibs;

import java.io.IOException;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class MinhaTag extends SimpleTagSupport {
	public void doTag() throws IOException {
		JspWriter out = getJspContext().getOut();
		out.println("<H1>Essa taglib nao usa parametros.</H1>");
	}
}
