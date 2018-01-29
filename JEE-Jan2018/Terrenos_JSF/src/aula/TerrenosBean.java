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
	private List<Double> terrenos = new ArrayList<Double>();
	private Double maior;
	
	private HtmlInputText inputLargura;
	private HtmlInputText inputComprimento;
	private HtmlCommandButton botaoAdicionar;
	
	public String adicionar() {
		
		double area = largura*comprimento; 
		terrenos.add(area);
		
		//Desativa campo e botão quando muitos nomes forem adicionados.
		if (this.terrenos.size() > 5) {
			this.inputLargura.setDisabled(true);
			this.inputComprimento.setDisabled(true);
			this.botaoAdicionar.setDisabled(true);
			this.botaoAdicionar.setValue("Lista de Terrenos");
		}
		
		if (terrenos.size() == 1) {
			maior = area;
		} else if (area > maior) {
			maior = area; 
		}		
		return "";
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
	public List<Double> getTerrenos() {
		return terrenos;
	}
	public void setTerrenos(List<Double> terrenos) {
		this.terrenos = terrenos;
	}
	public Double getMaior() {
		return maior;
	}
	public void setMaior(Double maior) {
		this.maior = maior;
	}	
}
