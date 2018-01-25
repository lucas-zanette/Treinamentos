package br.com.elaborata;

public class Filme {
	int cod;
	String nome;
	String estilo;	
	
	public Filme(int cod, String nome, String estilo) {
		super();
		this.cod = cod;
		this.nome = nome;
		this.estilo = estilo;
	}
	
	public int getCod() {
		return cod;
	}
	public void setCod(int cod) {
		this.cod = cod;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEstilo() {
		return estilo;
	}
	public void setEstilo(String estilo) {
		this.estilo = estilo;
	}
	
	public String toString(){
		return cod + ". " + estilo + " /n";
	}
	
}
