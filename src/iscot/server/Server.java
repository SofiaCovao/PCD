package iscot.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
		
	public static final int PORTO = 8080;
	
	public Server() {
		
	}
	
	public void startServing() throws IOException {
	
		ServerSocket ss = new ServerSocket(PORTO);
		System.out.println("Servidor IscoT iniciado!");
		
		try {
			while(true) {
				
			
			Socket socket = ss.accept();
			
			  System.out.println("Cliente ligado!");
			  
			  ClientHandler cliente = new ClientHandler(socket);
			  cliente.start();

			}

			} finally {
			    ss.close();
			}	
		
}	
}

	
	