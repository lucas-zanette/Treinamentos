package br.com.elaborata.tela;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.com.elaborata.controle.CtlProduto;
import br.com.elaborata.modelo.Produto;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Panel;

public class FrmProduto extends JFrame {

	private CtlProduto ctl = new CtlProduto();
	private String acao = "";
	
	private JPanel contentPane;
	private JTextField txt_Codigo;
	private JTextField txt_Descricao;
	private JTextField txt_Quantidade;
	private JButton btnIncluir;
	private JButton btnAlterar;
	private JButton btnExcluir;
	private JButton btnAnterior;
	private JButton btnProximo;
	private JButton btnSalvar;
	private JButton btnCancelar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmProduto frame = new FrmProduto();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrmProduto() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 453, 291);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Código");
		lblNewLabel.setBounds(30, 64, 70, 15);
		panel_1.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Produto");
		lblNewLabel_1.setBounds(30, 112, 70, 15);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Quantidade");
		lblNewLabel_2.setBounds(30, 159, 123, 15);
		panel_1.add(lblNewLabel_2);
		
		txt_Codigo = new JTextField();
		txt_Codigo.setBounds(153, 62, 114, 19);
		panel_1.add(txt_Codigo);
		txt_Codigo.setColumns(10);
		
		txt_Descricao = new JTextField();
		txt_Descricao.setBounds(153, 110, 114, 19);
		panel_1.add(txt_Descricao);
		txt_Descricao.setColumns(10);
		
		txt_Quantidade = new JTextField();
		txt_Quantidade.setBounds(153, 157, 114, 19);
		panel_1.add(txt_Quantidade);
		txt_Quantidade.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 12, 438, 35);
		panel_1.add(panel);
		
		btnIncluir = new JButton("Incluir");
		btnIncluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				acao = "I";
				preencheCampos(null);
				ativaCampos(true);
			}
		});
		panel.add(btnIncluir);
		
		btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				acao = "A";
				ativaCampos(true);
				txt_Codigo.setEnabled(false);
			}
		});
		panel.add(btnAlterar);
		
		btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ativaCampos(false);
				ctl.excluir(Integer.parseInt(txt_Codigo.getText()));
				preencheCampos(ctl.getAtual());
				ativaCampos(false);			
			}
		});
		panel.add(btnExcluir);
		
		btnAnterior = new JButton("<");
		btnAnterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				preencheCampos(ctl.getAnterior());
				ativaCampos(false);
				
			}
		});
		panel.add(btnAnterior);
		
		btnProximo = new JButton(">");
		btnProximo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				preencheCampos(ctl.getProximo());
				ativaCampos(false);
			}
		});
		panel.add(btnProximo);
		
		btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					//ao salvar gera um codigo e devolve para a tela porque antes estava ficando vazio quando incluia um produto novo
					int codigo = ctl.salvar(preencheProduto(), acao.equals("A"));
					txt_Codigo.setText(Integer.toString(codigo));
					
					ativaCampos(false);
					acao = "";
				} catch (Exception e1) {
					System.out.println(e1.getMessage());
				}								
				;			
			}
		});
		
		btnSalvar.setBounds(98, 205, 117, 25);
		panel_1.add(btnSalvar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ativaCampos(false);
				preencheCampos(ctl.getAtual());
				acao = "";
			}
		});
		
		btnCancelar.setBounds(218, 205, 117, 25);
		panel_1.add(btnCancelar);
		
		if(ctl.temProx()){
			preencheCampos(ctl.getProximo());
		}
		
		//bloqueia os campos e ativa botoes da barra de ferramentas
		ativaCampos(false);
	}
	
	private void ativaCampos(boolean estadoAtivacao) {
		txt_Codigo.setEnabled(estadoAtivacao);
		txt_Descricao.setEnabled(estadoAtivacao);
		txt_Quantidade.setEnabled(estadoAtivacao);
		
		btnIncluir.setEnabled(!estadoAtivacao);
		btnAlterar.setEnabled((!estadoAtivacao) && (ctl.temAtual() == true));
		btnExcluir.setEnabled((!estadoAtivacao) && (ctl.temAtual() == true));
		
		btnAnterior.setEnabled((!estadoAtivacao) && (ctl.temAnt()));
		btnProximo.setEnabled((!estadoAtivacao) && (ctl.temProx()));		
	}
	
	//pega do objeto poe na tela
	private void preencheCampos(Produto p){
		
		if (p == null){
			txt_Codigo.setText("");
			txt_Descricao.setText("");
			txt_Quantidade.setText("");
		} else {
			txt_Codigo.setText(Integer.toString(p.getCodigo()));
			txt_Descricao.setText(p.getDescricao());
			txt_Quantidade.setText(Integer.toString(p.getQtd()));
		}
	}
	
	//pega da tela e poe no objeto
	private Produto preencheProduto() throws Exception {
		
		int codigo;
		String descricao;
		int qtd;
				
		try {
			//if ( Integer.parseInt(txt_Codigo.getText().equals("")) ) {
			if ( txt_Codigo.getText().equals("") ) {
				codigo = Integer.parseInt("0");
			} else{			
				codigo = Integer.parseInt(txt_Codigo.getText());
			}
		} catch (Exception e1) {
			throw new Exception("Favor digitar um código válido");
		}
		
		descricao = txt_Descricao.getText();
		qtd = Integer.parseInt(txt_Quantidade.getText().equals("") ? "0" : txt_Quantidade.getText());

		Produto p = new Produto(codigo, descricao, qtd);
		
		return p;
	}
	
	public JButton getBtnIncluir() {
		return btnIncluir;
	}
	public JButton getBtnAlterar() {
		return btnAlterar;
	}
	public JButton getBtnExcluir() {
		return btnExcluir;
	}
	public JButton getBtnAnterior() {
		return btnAnterior;
	}
	public JButton getBtnProximo() {
		return btnProximo;
	}
	public JButton getBtnSalvar() {
		return btnSalvar;
	}
	public JButton getBtnCancelar() {
		return btnCancelar;
	}
}
