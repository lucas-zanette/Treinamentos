import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Formatter;


public class Main {
	//private declarar uma constante
	private final int tamReg = 52;
	RandomAccessFile f;
	
	public static void main(String[] args) throws IOException {
		Main app = new Main();
		
		app.abraArqBinario("/home/aluno/workspace/Lucas_JavaII_Nov2017_Turma10252/Dados/Cerveja.dat");		
			app.gravaArqBinario(1, "BlueMoon", 5.7);
			app.gravaArqBinario(2, "Itaipava", 5.0);
			app.gravaArqBinario(3, "Kaiser", 6.0);
			app.gravaArqBinario(4, "Polar", 4.9);
			
			app.exportaDados();
			//app.exportaDados("/home/aluno/workspace/Lucas_JavaII_Nov2017_Turma10252/Dados/CervejaForte.txt");
			//app.exportaDados("/home/aluno/workspace/Lucas_JavaII_Nov2017_Turma10252/Dados/CervejaFraca.txt");
		app.fechaArqBinario();
	}

	public void abraArqBinario(String arq) throws FileNotFoundException{
		f = new RandomAccessFile(arq, "rw");
	}
	
	public void fechaArqBinario() throws IOException{
		f.close();
	}
	
	public void gravaArqBinario(int cod, String nome, double teor) throws IOException{
		f.writeInt(cod); 						//4
		f.writeChars(defineTamanho(nome, 20));	//20*2 = 40
		f.writeDouble(teor);					//8
	}
	
	public String defineTamanho(String s, int tam){
		int dif = tam - s.length();
		
		if (dif > 0) {
			StringBuffer sb = new StringBuffer(tam);
			sb.append(s);
			while (dif > 0){
				sb.append(' ');
				dif--;				
			}
			return sb.toString();
		} else {
			return s.substring(0,  tam);
		}
	}
	
	public void exportaDados() {
		//cria o arquivo texto de destino.

		double teor = f.readDouble();
		
		if (teor > 5) { 
			String arqDestino = "/home/aluno/workspace/Lucas_JavaII_Nov2017_Turma10252/Dados/CervejaForte.txt";
		} else {
			String arqDestino = "/home/aluno/workspace/Lucas_JavaII_Nov2017_Turma10252/Dados/CervejaFraca.txt";
		}
		
		Formatter fTexto = new Formatter(arqDestino);	//format Grava
		
		//String s = "";
		long qtd = f.length() / tamReg;
		
		//percorre todos os registros do arquivo binário.
		for (int i=1; i<=qtd; i++) {
			f.seek( (i-1)*tamReg );
			
			int cod = f.readInt();
			
			//percorre todos os arquivos 			
			StringBuffer sb = new StringBuffer(20);
			for (int j=0; j<20; j++) 
				sb.append(f.readChar());
			String nome = sb.toString();			

			double teor = f.readDouble();
			
			//Monto o texto de saida:
			String s = "";
			s = s + "Código:	" + cod + "\n";
			s = s + "Nome: 	" + nome + "\n";
			s = s + "Salário: 	" + teor + "\n";
			s = s + "------------------------------------------\n";
			
			fTexto.format("%s", s);
		}		
		fTexto.close();									//%d é um codigo que diz que é uma int
	}
}
