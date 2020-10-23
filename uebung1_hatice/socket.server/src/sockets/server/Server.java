package sockets.server;

import java.io.OutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;


public class Server {
	
	
	public static void main(String[] args){
		
		try{
			ServerSocket serverSocket = new ServerSocket(777);
			Protocol protocol = new Protocol();
				
			while(true) {
				Socket clientSocket = serverSocket.accept();
	
				System.out.println("Verbunden mit Client!");
			
				BufferedReader r = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
				
				OutputStream outputStream = clientSocket.getOutputStream();
				PrintWriter output = new PrintWriter(outputStream, true);
				
				String vomClient = null;
				String anClient = null;
			
				while((vomClient= r.readLine()) != null) { //vomCLien == r.readLline()
					anClient = protocol.process(vomClient);  
//					output.print(anClient);
//					output.flush();
					if(anClient == null) {
						System.out.println("Server: Unbekannte Eingabe! ");
					}
					
				} System.out.println("Server: Server antwort: " +  anClient);	
				r.close();
				clientSocket.close();
				serverSocket.close();
			}
			
		} catch(IOException e) {
			System.out.println("Der Server hat einen Fehler und konnte nicht gestartet werden.");
		}
	}
	
}
	
