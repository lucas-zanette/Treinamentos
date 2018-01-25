public class Terreno {
	
	private double largura;
	private double comprimento;
	private double valor;

	
	
	public Terreno(double largura, double comprimento, double valor) {
		super();
		this.largura = largura;
		this.comprimento = comprimento;
		this.valor = valor;
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
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	
//	public double getPreco() {
//		
//	}
	
	public double getArea(){
		return largura * comprimento;
	}
	 
}
