package aula;

public class Terreno {
	private double largura;
	private double comprimento;
	
	public Terreno(double largura, double comprimento) {
		super();
		this.largura = largura;
		this.comprimento = comprimento;
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
	public double getArea() {
		return largura * comprimento;
	}

}
