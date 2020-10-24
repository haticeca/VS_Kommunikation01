/*
 * Team 5
 * 
 * Das Programm läuft leider nicht einwandfrei.. 
 * die Commands werden nicht durchläuft.. die Methoden process(msg)
 * process(args[]) habe ich getestet die müssten an sich funktionieren..
 * 
 * */

package sockets.server;

import java.io.OutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;


public class Server {
	
	
	public static void main(String[] args) throws IOException{
		
		ServerSocket serverSocket = new ServerSocket(777);
		try{
				
			while(true) {
				Socket clientSocket = serverSocket.accept();
				Protocol protocol = new Protocol();
				System.out.println("Verbunden mit Client!");
			
				BufferedReader r = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
				
				OutputStream outputStream = clientSocket.getOutputStream();
				PrintWriter output = new PrintWriter(outputStream, true);
				
				String vomClient = null;
				String anClient = null;
			
				while((vomClient= r.readLine()) != null) { 
					
					System.out.println("Server: Client fragt: " + vomClient);
					anClient = protocol.process(vomClient);
					
					
					if(anClient == null) {
						System.out.println("Server: Server Command sagt null. Kein Command! ");
					}
					System.out.println("Server: Server antwort: " +  anClient);	
					output.print(anClient);
				} 
				clientSocket.close();
				
				
				
			} 
			
		} catch(IOException e) {
			System.out.println("Der Server hat einen Fehler und konnte nicht gestartet werden.");
		}
	}
	
}
	