package br.com.elaborata.controle;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import br.com.elaborata.modelo.Produto;

public class CtlProduto {
	
	//ao criar o arquivo eu já armazeno uma lista para não precisar ficar lendo arquivos em disco
	//logo ao inves de ler arquivo por aquivos se eu tiver 1 milhaõ de arquivos ficará lento
	//entao armazeno em lista só o nome dos arquivos e não preciso ir no disco
	
	//final exemplo: (private final int lista = 3) final faz ser uma constante e não varia
	private final String caminho = "/home/aluno/workspace/Lucas_JavaII_Nov2017_Turma10252/Dados/";
	private File pasta;
	private String[] lst;
	private int pos = -1; //posição -1 porque a posição 0 no array é uma posição válida e poderia ter um registro
	
	public CtlProduto (){
		//cria um objeto vinculado ao diretorio onde estão os arquivos serializados.
		pasta = new File(caminho);

		//recupera a lista de nome de arquivos que estão gravados na pasta.
		lst = pasta.list(); //vai retornar a lista de arquivos que este diretorio contem
	}

	public int salvar(Produto p, boolean podeSobrescrever) throws Exception{
		
		//se não pode sobrescrever...
			//verificar se o produto já está salvo
				//gerar um erro		
		if (!podeSobrescrever) {
			String nomeArq = caminho + p.getCodigo() + ".obj";
			File f = new File(nomeArq);
			if (f.exists()){
				throw new Exception("O produto já existe.");
				//se chegar aqui e der o throw não irá continuar o que tem pra baixo e por consequencia não fará o serializar
			}
		}
		if ( p.getCodigo() <= 0 ){
			p.setCodigo(getProximoCodigo());
		}
			
		
		
										//nome do arquivo é o proprio código
		serializar(p, Integer.toString(p.getCodigo()));
		//recupera a lista de nome de arquivos que estão gravados na pasta
		lst = pasta.list(); 
		
		//posiciona o cursos de registros, caso necessário
		if(pos <= -1){
			pos = 0;
		}
		
		return p.getCodigo();
	}
	
	private int getProximoCodigo() {
		
		return getMaiorCodigo() + 1;
		
	}

	private int getMaiorCodigo() {
		int maior = 0;
		//for each do Genexus - ele percorre tudo ao invés de fazer 	for(int i=0; i<lst.length; i++)
		for (String arq : lst) {
			//split corta onde tiver o ponto e joga num array ex: 123.obj = na posicao 1 = 123 posicao 2 = obj
			int n = Integer.parseInt(arq.split(".")[0]);
			
			if (n > maior){
				maior = n;
			}
		}
		return maior;
	}

	public void excluir(int codigo) {
		File f = new File(caminho + codigo + ".obj");
		f.delete();

		//Recupera a lista de nome de arquivos que estão gravados na pasta		
		lst = pasta.list();
		
		//verifica se a posicao indicada pela variavel ainda e valida
		if (pos >= lst.length)
			pos--;
	}
	
	public Produto getProximo(){
		//verificar se tem o proximo porque se chegar no ultimo sem este tratamento vai dar erro na tela		
		if (temProx()){
			pos ++;	
								//nome do arquivo da posicao xxx.
			return (Produto) desserializar(lst[pos]);			
		}
		return null;
	}
	
	public Produto getAnterior(){
		if (temAnt()){
			pos--;
			return (Produto) desserializar(lst[pos]);
		}
		return null;
	}

	public Produto getAtual(){
		if (pos > -1) {
			return (Produto) desserializar(lst[pos]);
		}
		return null;
	}
	
	//verificar se tem o proximo porque se chegar no ultimo sem este tratamento vai dar erro na tela
	public boolean temAnt(){
		//return false;
		return (pos > 0);		
	}
	
	public boolean temProx(){
		//pode fazer o return direto desta forma
		return (pos < (lst.length - 1));
	}
	
	public boolean temAtual(){
		if (pos > -1) {
			return true;
		} else {
			return false;
		}
	}
	
	
	//função salvar generica
	//serializable OBJ porque não quero fixar um objeto por exemplo Produto entao passo obj
	private void serializar(Serializable obj, String nomeArq) {
		//pega o que passar e grava
		//preciso colocar (implemets Serializable) na classe pojo Produto para indicar que deixo serializar
		//exemplo de polimorfismo se eu passar "private void serializar(Serializable obj)" entendi que faz algo com os parametros serializable e o obj

		String arquivo = caminho + nomeArq + ".obj";
		
		try {
			ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(arquivo));
			output.writeObject(obj);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private Serializable desserializar(String nomeArq){
		String arquivo = caminho + nomeArq;
		try {
			ObjectInputStream output = new ObjectInputStream(new FileInputStream(arquivo));
			
			//retorna tipo (serializable) mas a funçao readObject espera um object por isso poe entre parenteses o serializable 
			return (Serializable) output.readObject(); 
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}

