package br.com.elaborata;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

	public static void main(String[] args) throws IOException {
		while (true){
			ServerSocket conexao = new ServerSocket(1234,1);
			Socket cliente = conexao.accept();
			
			DataInputStream entrada = new DataInputStream(cliente.getInputStream());
			DataOutputStream saida = new DataOutputStream(cliente.getOutputStream());
			
			String msgEntrada = entrada.readUTF();
			System.out.println(" Recebi: " + msgEntrada);
			
			String msgSaida = " Cuide com o Chuck Norris";
			saida.writeUTF(msgSaida);
			System.out.println(" Enviei" + msgSaida);
			
			saida.close();
			entrada.close();
			cliente.close();
			conexao.close();
			
		}
	}

}
