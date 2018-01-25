package br.com.elaborata;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class ClienteUDP {

	public static void main(String[] args) throws IOException { 
		DatagramSocket cliente = new DatagramSocket();
		InetAddress enderecoServidor = 
				InetAddress.getByName("localhost");
		
		byte[] bufferPergunta = 
				"Solicitação do cliente".getBytes();
		DatagramPacket pacotePergunta = 
				new DatagramPacket(bufferPergunta, 
						bufferPergunta.length, 
						enderecoServidor, 
						2345);
		cliente.send(pacotePergunta);
		System.out.println("Enviei: " + pacotePergunta.toString());
		
		DatagramPacket resposta = new DatagramPacket(
				new byte[512],  512);
		cliente.receive(resposta);
		System.out.println("Recebi: " + resposta.toString());
		
		cliente.close();
	}
	
}
