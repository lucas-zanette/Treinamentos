package controle;

import java.io.FileNotFoundException;
import java.util.Formatter;

public class CtlCadastro {

	private static Formatter saida;		
	static String arquivo = "/home/aluno/workspace/Lucas_JavaII_Nov2017_Turma10252/Dados/cadastropessoa.txt";

	public static void main(String[] args) {
		String[][] lst = new String [3][3];		
		
		lst[0][0] = "João";
		lst[0][1] = "Endereco 1";
		lst[0][2] = "Maria";
		lst[1][0] = "Jose";
		lst[1][1] = "Endereco 1";
		lst[1][2] = "Fernanda";
		lst[2][0] = "Pedro";
		lst[2][1] = "Endereco 1";
		lst[2][2] = "Maira";

		try {
			saida = new Formatter(arquivo);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for (int i = 0; i < 3; i++) {
		    saida.format("Nome: %s\nEndereço: %s\nMãe: %s\n----------------------------\n", lst[i][0], lst[i][1], lst[i][2]);
		}	
	    saida.close();  
	}	
}


