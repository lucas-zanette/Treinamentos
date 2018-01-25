package arquivos;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Formatter;

public class Main {
	//private declarar uma constante
	private final int tamReg = 134;
	RandomAccessFile f;
	
	public static void main(String[] args) throws IOException {
		Main app = new Main();
		
		app.abraArqBinario("/home/aluno/workspace/Lucas_JavaII_Nov2017_Turma10252/Dados/AbraCerveja.dat");
			app.gravaArqBinario(1, "BlueMoon", "111", 11.0);
			app.gravaArqBinario(2, "Itaipava", "111", 12.0);
			app.gravaArqBinario(3, "Kaiser", "111", 13.0);
			app.gravaArqBinario(4, "Polar", "111", 14.0);			
		app.exportaDados("/home/aluno/workspace/Lucas_JavaII_Nov2017_Turma10252/Dados/AbraCerveja.txt");		
		app.fechaArqBinario();
	}

	public void abraArqBinario(String arq) throws FileNotFoundException{
		f = new RandomAccessFile(arq, "rw");
	}
	
	public void fechaArqBinario() throws IOException{
		f.close();
	}
	
	public void gravaArqBinario(int cod, String nome, String cpf, double salario) throws IOException{
		f.writeInt(cod);
		f.writeChars(defineTamanho(nome, 50));
		f.writeChars(defineTamanho(cpf, 11));
		f.writeDouble(salario);
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
		//return null;
	}
	
	public void exportaDados(String arqDestino) throws IOException{
		//cria o arquivo texto de destino.
		Formatter fTexto = new Formatter(arqDestino);	//format Grava
		
		//String s = "";
		long qtd = f.length() / tamReg;
		
		//percorre todos os registros do arquivo binário.
		for (int i=1; i<=qtd; i++) {
			f.seek( (i-1)*tamReg );
			
			int cod = f.readInt();
			
			//percorre todos os arquivos 			
			StringBuffer sb = new StringBuffer(50);
			for (int j=0; j<50; j++) 
				sb.append(f.readChar());
			String nome = sb.toString();
			
			sb = new StringBuffer(11);
			for (int j=0; j<11; j++)
				sb.append(f.readChar());
			String cpf = sb.toString();

			double salario = f.readDouble();
			
			//Monto o texto de saida:
			String s = "";
			s = s + "Código:	" + cod + "\n";
			s = s + "Nome: 		" + nome + "\n";
			s = s + "CPF: 		" + cpf + "\n";
			s = s + "Salário: 	" + salario + "\n";
			s = s + "------------------------\n";
			
			fTexto.format("%s", s);
		}
		
		//Salvo tudo de uma vez no arquivo texto.
		//Formatter fTexto = new Formatter(arqDestino);	//format Grava
		//fTexto.format("%s", s);  						//%s é um codigo que diz que é uma string
		fTexto.close();									//%d é um codigo que diz que é uma int
	}
}
