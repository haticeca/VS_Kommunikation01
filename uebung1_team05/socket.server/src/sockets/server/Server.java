/*
 * Team 5
 * 
 * Das Programm läuft leider nicht einwandfrei.. 
 * die Commands werden durchläuft, das haben wir auf unsere Art und Weise getestet. Also Methoden process(msg)
 * process(args[]) müssten an sich funktionieren..
 * Bei Eingabe wird die Erste eingabe hier + 5 6 geschickt und wenn Server gestoppt wird erst zurückgegeben. leider werden die Eingaben nicht hintereinander bearbeitet. Der Fehler liegt wahrscheinlich im Server aber wir konnten es auch nach langer Suche nicht finden.
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
						anClient = "unbekannt";
					}
					System.out.println("Server: Server antwort: " +  anClient);	
					output.print(anClient);
				} 
				clientSocket.close();
				serverSocket.close();
				
				
			} 
			
		} catch(IOException e) {
			System.out.println("Der Server hat einen Fehler und konnte nicht gestartet werden.");
		}
	}
	
}
	