package br.elaborata.com;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

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
			DatagramSocket conexao = null;
			try {
				conexao = new DatagramSocket(2345);
			} catch (SocketException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//Socket cliente = conexao.accept();
			
			System.out.println("Conectou. Captura mensagem");
			DatagramPacket entrada = new DatagramPacket(new byte[512],  512);
			try {
				conexao.receive(entrada);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			conexao.close();
			
		}	
		
		
	}
		
}
