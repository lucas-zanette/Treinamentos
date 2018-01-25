import java.io.FileNotFoundException;
import java.util.Formatter;

public class CriarArqTexto {

	private Formatter saida;
	String arquivo = "/home/aluno/workspace/Lucas_JavaII_Nov2017_Turma10252/Dados/teste.txt";
	
	public CriarArqTexto() {
		try {
			saida = new Formatter(arquivo);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void salvar(int codigo, String s){
		saida.format("%d / %s\r\n", codigo, s);
		
		//flush descarrega a cache - mas a otimização fica ruim
		//se não por o FLUSH tem que dizer em algum momento para FECHAR - (public void fechar)
		//se usa normalmente com flush para um arquivo de log
		saida.flush();	
	}
	
	public void fechar(){
		saida.close();  //descarrega a cache sem flush
	}
}
