package login;

public class LoginDadosModel {
	
	private String nomeUsuario;
	
	public LoginDadosModel() {
		
	}

	public LoginDadosModel(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

}
