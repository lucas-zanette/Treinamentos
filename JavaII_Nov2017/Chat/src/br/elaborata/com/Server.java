package br.elaborata.com;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JTextArea;

public class Server extends Thread {
	
	JTextArea txtChat;
	
	public Server(JTextArea txtChat) {
		this.txtChat = txtChat;		
		System.out.println("Criou o servidor.");
	}

	public void run() {
		while (true){
			System.out.println("Aguarda uma conexão");
			ServerSocket conexao;
			try {
				conexao = new ServerSocket(1242,1);
				Socket cliente = conexao.accept();
				
				System.out.println("Conectou. Captura mensagem");
				DataInputStream entrada = new DataInputStream(cliente.getInputStream());			
				String msgEntrada = entrada.readUTF();			
				
				System.out.println("Colocando msn na tela");
				txtChat.setText(txtChat.getText() + "\n" + msgEntrada);
				
				System.out.println("Fechando conexão");
				
				entrada.close();
				cliente.close();
				conexao.close();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}		
	}
		
}
