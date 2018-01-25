package aula;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlInputText;

@ManagedBean
@SessionScoped
public class TerrenosBean {
	
	private Double largura;
	private Double comprimento;
	private List<String> terrenos = new ArrayList<String>();
	
	private HtmlInputText inputLargura;
	private HtmlInputText inputComprimento;
	private HtmlCommandButton botaoAdicionar;
	
	public void adicionar() {
	
		this.inputLargura.setDisabled(true);
		this.inputComprimento.setDisabled(true);
		this.botaoAdicionar.setDisabled(true);
		this.botaoAdicionar.setValue("Lista de Terrenos");
	}

	
	
	public Double getLargura() {
		return largura;
	}
	public void setLargura(Double largura) {
		this.largura = largura;
	}

	public Double getComprimento() {
		return comprimento;
	}
	public void setComprimento(Double comprimento) {
		this.comprimento = comprimento;
	}

	public List<String> getTerrenos() {
		return terrenos;
	}
	public void setTerrenos(List<String> terrenos) {
		this.terrenos = terrenos;
	}

	public HtmlInputText getInputLargura() {
		return inputLargura;
	}
	public void setInputLargura(HtmlInputText inputLargura) {
		this.inputLargura = inputLargura;
	}

	public HtmlInputText getInputComprimento() {
		return inputComprimento;
	}
	public void setInputComprimento(HtmlInputText inputComprimento) {
		this.inputComprimento = inputComprimento;
	}

	public HtmlCommandButton getBotaoAdicionar() {
		return botaoAdicionar;
	}
	public void setBotaoAdicionar(HtmlCommandButton botaoAdicionar) {
		this.botaoAdicionar = botaoAdicionar;
	}
}
