package org.htw.fiw.vs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Server {
	
	private Protocol protocol = new Protocol();
	//ArrayList<ClientHandler> handlers = new ArrayList<ClientHandler>();

	public static void main(String[] args) throws IOException, InterruptedException {
		new Server().start();
	}

	public void start() throws IOException, InterruptedException {
		// erstelle neuen Socket mit bestimmter Portnummer
		ServerSocket serverSocket = new ServerSocket(8080);
		System.out.println("server started at: " + serverSocket.getLocalSocketAddress());
		
		int numberOfThreads = 4;
		ExecutorService pool = Executors.newCachedThreadPool(); 
		
		try {
			while (true) {
				Socket clientSocket = serverSocket.accept();
				
				for (int i = 0; i < 3; i++) {
					System.out.println((i+1) + ". Client" + "new client from: " + clientSocket.getRemoteSocketAddress());
					pool.submit(new ClientHandler(clientSocket, this.protocol));
				} 
				
			}
		} finally {
			serverSocket.close();
		}
	}
}
//Frage: eine Array-List für Clienhandler, damit alle Thread parallel ausgeführt werden? Aber Eingabe im Client erfolgt der Reihe nach..