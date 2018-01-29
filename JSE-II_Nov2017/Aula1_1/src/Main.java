import java.io.File;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File arquivo = new File("/home/aluno/workspace/Lucas_JavaII_Nov2017/Teste.txt");
		if (arquivo.exists()) {
			System.out.println("Existe");
		} else {
			System.out.println("Não existe");			
		}
		
		System.out.println(arquivo.isDirectory() ? "É um diretório" : "É um arquivo");
		System.out.println(arquivo.length());
		
		File dir = new File("/home/aluno/workspace/Lucas_JavaII_Nov2017/Aula1_1/aula_arquivo_aux");
		dir.mkdir();
		
		
		
		
		
	}
	
}

