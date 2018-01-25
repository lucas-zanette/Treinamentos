package br.elaborata.com;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Cliente {

	public void enviar(String ip, int Porta, String msg) {
		
		Socket conexao;
		try {
			conexao = new Socket(ip, Porta);
			DataOutputStream saida  = new DataOutputStream(conexao.getOutputStream());
			
			saida.writeUTF(msg);	
			
			saida.close();
			
			conexao.close();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}


}
