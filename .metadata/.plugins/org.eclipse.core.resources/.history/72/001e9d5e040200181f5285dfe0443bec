package login;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter(filterName="/LoginFilter", urlPatterns="/pages/*")
public class LoginFilter implements Filter {

    public LoginFilter() {
    }

	public void init(FilterConfig fConfig) throws ServletException {
	}

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		HttpSession session = req.getSession();
		
		DadosLogin dl = (DadosLogin) session.getAttribute("dadosLogin");
		
		if (dl == null) {
			resp.sendRedirect(req.getContextPath() + "/Login.jsf");
		} else {
			chain.doFilter(request, response);
		}	
	}

	@Override
	public void destroy() {
	}

}
