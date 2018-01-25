package br.com.elaborata;

import java.io.FileNotFoundException;

public class Main {

	public static void main(String[] args) {
		
		GeraLog<Game> lg = new GeraLog<Game>();
		try {
			lg.abrir("/home/aluno/workspace/Lucas_JavaII_Nov2017_Turma10252/Dados/logGame.log");
		} catch (FileNotFoundException e) {
			System.out.println("Não foi possível criar o arquivo");
			return;
		}
			
			// TODO Auto-generated method stub
			Game g = new Game(1, "Road Rash", "Corrida");
			lg.gravar(g);;
			g = new Game(2, "Counter Strike", "Tiro");
			lg.gravar(g);;
			g = new Game(3, "Donkey Kong", "Aventura");
			lg.gravar(g);;
			g = new Game(4, "Fifa 1", "Esporte");
			lg.gravar(g);
		lg.fechar();
		
		
		GeraLog<Filme> lf = new GeraLog<Filme>();
		
		try {
			lf.abrir("/home/aluno/workspace/Lucas_JavaII_Nov2017_Turma10252/Dados/logFilme.log");
		} catch (FileNotFoundException e) {
			System.out.println("Não foi possível criar o arquivo");
			return;
		}
			Filme f = new Filme(1, "Alien", "Ridley Scott");
			lf.gravar(f);
			f = new Filme(2, "Star Wars", "George Lucas");
			lf.gravar(f);
			f = new Filme(3, "E.T.", "Steven Spilbert");
			lf.gravar(f);
		lf.fechar();
		
	}

}
