package iscot.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
		
	
	public static void main(String[] args)  throws InterruptedException, IOException {
			
		ServerSocket servidor = new ServerSocket(8080);
		
		System.out.print("Servidor inciado!");
		
		while(true) {
			
			
		Socket cliente = servidor.accept();
		
		System.out.print("Cliente ligado!");
		
		cliente.close();
		}
		
		
	
		
		}
}
