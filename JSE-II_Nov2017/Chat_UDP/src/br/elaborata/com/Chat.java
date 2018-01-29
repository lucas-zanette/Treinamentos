package br.elaborata.com;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class Chat extends JFrame {
	private JTextField txtMsg;
	private JTextField txtIP;
	private JTextField txtPorta;
	private JTextArea txtChat;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Chat frame = new Chat();
					frame.setVisible(true);
					
					Server server = new Server(frame.txtChat);
					server.start();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}

	public Chat() {
		System.out.println("Criando a janela");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 721, 299);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.SOUTH);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1, BorderLayout.NORTH);
		
		JLabel lblIP = new JLabel("IP");
		panel_1.add(lblIP);
		
		txtIP = new JTextField();
		panel_1.add(txtIP);
		txtIP.setColumns(10);
		
		JLabel lblPorta = new JLabel("Porta");
		panel_1.add(lblPorta);
		
		txtPorta = new JTextField();
		panel_1.add(txtPorta);
		txtPorta.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2, BorderLayout.SOUTH);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		
		
		JButton btnEnviar = new JButton("Enviar");
		btnEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cliente c = new Cliente();
				txtChat.setText(txtChat.getText() + "\n" + txtMsg.getText());
				try {
					c.enviar(txtIP.getText(), Integer.parseInt(txtPorta.getText()), txtMsg.getText());
				} catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		panel_2.add(btnEnviar, BorderLayout.EAST);
		
		
		
		txtMsg = new JTextField();
		panel_2.add(txtMsg, BorderLayout.CENTER);
		txtMsg.setColumns(10);
		
		txtChat = new JTextArea();
		getContentPane().add(txtChat, BorderLayout.CENTER);
	}
	
	public JTextArea getTxtChat() {
		return txtChat;
	}
}
