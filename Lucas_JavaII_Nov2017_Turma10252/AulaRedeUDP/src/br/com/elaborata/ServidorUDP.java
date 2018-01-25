package br.com.elaborata;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class ServidorUDP {
	
	public static void main(String[] args) throws IOException { 
		DatagramSocket servidor = new DatagramSocket(2345);

		DatagramPacket pacoteRecebido = new DatagramPacket(new byte[512],  512);
		servidor.receive(pacoteRecebido);
		System.out.println("Recebi: " + pacoteRecebido.toString());
		
		byte[] bufferResposta = "Resposta do servidor".getBytes();
		DatagramPacket resposta = new DatagramPacket(bufferResposta, bufferResposta.length, pacoteRecebido.getAddress(), pacoteRecebido.getPort());
		servidor.send(resposta);
		System.out.println("Enviei: " + resposta.toString());
		
		servidor.close();
	}
}
