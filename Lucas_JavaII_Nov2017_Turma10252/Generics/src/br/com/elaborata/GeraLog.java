package br.com.elaborata;

import java.io.FileNotFoundException;
import java.util.Formatter;

public class GeraLog<X> {

	Formatter f;
	
	public void abrir(String arq) throws FileNotFoundException {
		f = new Formatter(arq);		
	}
	
	public void fechar() {
		f.close();
	}
	
	public void gravar(X o) {
		f.format("%s\n", o);
	}
	
}
