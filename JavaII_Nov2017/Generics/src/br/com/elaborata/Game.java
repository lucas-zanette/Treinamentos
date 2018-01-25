package br.com.elaborata;

public class Game {
	int cod;
	String titulo;
	String diretor;
	public int getCod() {
		return cod;
	}
	public void setCod(int cod) {
		this.cod = cod;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDiretor() {
		return diretor;
	}
	public void setDiretor(String diretor) {
		this.diretor = diretor;
	}
	
	public Game(int cod, String titulo, String diretor) {
		super();
		this.cod = cod;
		this.titulo = titulo;
		this.diretor = diretor;
	}
	
	public String toString(){
		return cod + ". " + titulo + "/";
	}
	
}
