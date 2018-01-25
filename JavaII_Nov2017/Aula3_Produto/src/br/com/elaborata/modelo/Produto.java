package br.com.elaborata.modelo;

import java.io.Serializable;

public class Produto implements Serializable {

	private int codigo;
	private String descricao;
	private int qtd;
	
	public Produto(int codigo, String descricao, int qtd) throws Exception  {
		super();
		setCodigo(codigo);
		setDescricao(descricao);
		setQtd(qtd);
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) throws Exception {
		if (codigo < 0) {
			throw new Exception("Código não pode ser menor do que zero");
		}
		this.codigo = codigo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) throws Exception {
		if ( (descricao == null) || (descricao.equals("")) ) {
			throw new Exception("Descrição não pode ser vazio ou em branco");			
		}
		this.descricao = descricao;
	}
	public int getQtd() {
		return qtd;
	}
	public void setQtd(int qtd) throws Exception {
		if (qtd < 0)
			throw new Exception("Quantidade não pode ser negativa");
		this.qtd = qtd;
	}

}
