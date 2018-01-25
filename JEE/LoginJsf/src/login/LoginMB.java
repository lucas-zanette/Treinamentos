package login;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import control.BD_Gerenciado;

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
		Connection con = BD_Gerenciado.getConnection();
		String sql = "select 1 from usuario where login = ? and senha = md5(?);";		
	   	ResultSet rs = BD_Gerenciado.execSql(con, sql, fldLogin, fldSenha);
	   	
	   	try {
			if (rs.next()) {
			   	DadosLogin dl = new DadosLogin();
			   	dl.setLogin(fldLogin);
			   	
			   	HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
			   	session.setAttribute("dadosLogin", dl);
			   	
			   	return "pages/TelaPrincipal";
			} else {
				return "LoginInvalido";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   	
	   	return "LoginInvalido";
	}
	
	public String logoff(){
		HttpSessio session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		session.setAttribute("dadosLogin",  null);
		return "/Login";
	}
	
}
