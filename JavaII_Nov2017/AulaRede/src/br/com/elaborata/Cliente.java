package br.com.elaborata;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Cliente {

	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket conexao          = new Socket("10.3.10.12", 1234);
		DataInputStream entrada = new DataInputStream(conexao.getInputStream());
		DataOutputStream saida  = new DataOutputStream(conexao.getOutputStream());
		
		String msgSaida = "E.T de varginha";
		saida.writeUTF(msgSaida);
		System.out.println("Enviei: " + msgSaida);
		
		String msgEntrada = entrada.readUTF();
		System.out.println("Recebi: " + msgEntrada);

		saida.close();
		entrada.close();
		conexao.close();
	}

}
