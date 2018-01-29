package login;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

@ManagedBean
@SessionScoped
public class LoginMB {
       
	private String fldLogin;
	private String fldSenha;
	
	public String getFldLogin() {
		return fldLogin;
	}
	public void setFldLogin(String fldLogin) {
		this.fldLogin = fldLogin;
	}
	public String getFldSenha() {
		return fldSenha;
	}
	public void setFldSenha(String fldSenha) {
		this.fldSenha = fldSenha;
	}
	
	public String login() {
		if (fldLogin.trim().equals("admin") && fldSenha.trim().equals("admin")) {
			LoginDadosModel ldm = new LoginDadosModel(fldLogin.trim());
			HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
			session.setAttribute("loginDados", ldm);
			fldLogin = null;
			fldSenha = null;
			return "pages/TelaPrincipal";
		} else {
			return "LoginInvalido";
		}
	}

}

