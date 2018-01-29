package aula;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
public class PessoaBean {
	
	private String paramOperacao;
	private int paramCodigo;
	
	public List<Pessoa> getLstPessoa() {
		List<Pessoa> lstPessoa = new ArrayList<Pessoa>();
		lstPessoa.add(new Pessoa(1, "Pedro", "Rua do Pedro"));
		lstPessoa.add(new Pessoa(2, "José", "Rua do José"));
		lstPessoa.add(new Pessoa(3, "Henrique", "Rua do Henrique"));
		lstPessoa.add(new Pessoa(4, "Fernanda", "Rua da Fernanda"));
		
		return lstPessoa;
	}
	
	public String alterar() {
		System.out.println("Alterar");

		FacesContext fc = FacesContext.getCurrentInstance();
		Map<String,String> params = fc.getExternalContext().getRequestParameterMap();
		
		paramCodigo = Integer.parseInt(params.get("paramCodigo"));
		paramOperacao = "alterar";
		
		return "/paginaTeste";
	}

	public String excluir() {
		System.out.println("Excluir");

		FacesContext fc = FacesContext.getCurrentInstance();
		Map<String,String> params = fc.getExternalContext().getRequestParameterMap();
		
		paramCodigo = Integer.parseInt(params.get("paramCodigo"));
		paramOperacao = "excluir";
		
		return "/paginaTeste";
	}

	public String getParamOperacao() {
		return paramOperacao;
	}

	public void setParamOperacao(String paramOperacao) {
		this.paramOperacao = paramOperacao;
	}

	public int getParamCodigo() {
		return paramCodigo;
	}

	public void setParamCodigo(int paramCodigo) {
		this.paramCodigo = paramCodigo;
	}
	
	
}
