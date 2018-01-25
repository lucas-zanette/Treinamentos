package elaborata;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.Formatter;
import java.awt.event.ActionEvent;

public class BlocoDeNotas extends JFrame {
	private JTextField txt_caminho;
	String arquivo = "/home/aluno/workspace/Lucas_JavaII_Nov2017_Turma10252/Dados/" + txt_caminho;	
	private Formatter saida;
	private JTextArea txtConteudo;

	CtlTexto ctl = new CtlTexto();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BlocoDeNotas frame = new BlocoDeNotas();
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
	public BlocoDeNotas() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 461, 355);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.NORTH);
		panel.setLayout(new BorderLayout(0, 0));
		
		JButton btnSalvar = new JButton("SALVAR");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					ctl.salvar(arquivo, txtConteudo.getText());
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				/*
				//saida.format("%d / %s\r\n", txt_caminho, s);				
				saida.format("%s", txtConteudo.getText() );
				saida.flush();
				*/	
								
			}
		});
		panel.add(btnSalvar, BorderLayout.EAST);
		
		JLabel lblNewLabel = new JLabel("Caminho:");
		panel.add(lblNewLabel, BorderLayout.WEST);
		
		txt_caminho = new JTextField();
		panel.add(txt_caminho, BorderLayout.CENTER);
		txt_caminho.setColumns(10);
		
		txtConteudo = new JTextArea();
		getContentPane().add(txtConteudo, BorderLayout.CENTER);
		
		try {
			saida = new Formatter(arquivo);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	public JTextField getTxt_caminho() {
		return txt_caminho;
	}
	public JTextArea getTxtConteudo() {
		return txtConteudo;
	}
}
