package aula;

public class Terreno {
	private double largura;
	private double comprimento;
	private double valorM2;
	
	public Terreno(double largura, double comprimento, double valorM2) {
		super();
		this.largura = largura;
		this.comprimento = comprimento;
		this.valorM2 = valorM2;
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
	
	public double getPreco() {
		return getArea() * getValorM2();
	}
	public double getValorM2() {
		return valorM2;
	}
	public void setValorM2(double valorM2) {
		this.valorM2 = valorM2;
	}
}
