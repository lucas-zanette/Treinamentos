package aula;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

@ManagedBean
@SessionScoped
public class LoginBean {
	private String login;
	private String senha;
	
	public String login() {
		try {
			Connection con = Biblioteca.getConnection();
			String sql = "select 1 from usuario where login = ? and senha = md5(?);";
			ResultSet rs = Biblioteca.execSql(con, sql, login, senha);

			if (rs.next()) {
				//A senha está correta.
				DadosLogin dl = new DadosLogin();
				dl.setLogin(login);

				HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
				session.setAttribute("dadosLogin", dl);
				
				return "pages/TelaPrincipal";
			} else {
				//Senha inválida.
				return "LoginInvalido";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "LoginInvalido";
	}

	public String logoff() {
		HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		session.setAttribute("dadosLogin", null);
		return "/Login";
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
}
