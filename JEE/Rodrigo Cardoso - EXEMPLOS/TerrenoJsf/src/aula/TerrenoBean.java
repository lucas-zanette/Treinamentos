package aula;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class TerrenoBean {
	private double largura;
	private double comprimento;
	private List<Terreno> terrenos = new ArrayList<Terreno>();

	public void adicionar() {
		this.terrenos.add(new Terreno(largura, comprimento));
	}
	
	public double getMaior() {
		double maior = 0;
		for (Terreno t : terrenos) {
			if (t.getArea() > maior) {
				maior = t.getArea();
			}
		}
		return maior;
	}

	public List<Terreno> getTerrenos() {
		return terrenos;
	}
	
	public double getLargura() {
		return largura;
	}
	public void setLargura(double largura) {
		this.largura = largura;
	}
	public double getComprimento() {
		return comprimento;
	}
	public void setComprimento(double comprimento) {
		this.comprimento = comprimento;
	}

}
