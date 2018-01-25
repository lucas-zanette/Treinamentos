package elaborata;

import java.io.FileNotFoundException;
import java.util.Formatter;

public class CtlTexto {

	public void salvar(String s, String arquivo) throws FileNotFoundException {
		Formatter f = new Formatter(arquivo);
		f.format("%s", s);
		f.close();
	}
	
	public String abrir(String arquivo){
		return "";
	}
}
