package sockets.server;

import java.io.OutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Server {
	
	
	public static void main(String[] args){
		
		try{
			ServerSocket serverSocket = new ServerSocket(777);
			Socket clientSocket = serverSocket.accept();
	
			System.out.println("Verbunden mit Client!");
			
			Protocol protocol = new Protocol();
			
			// Datenstrom holen in BufferedReader umwandeln?
			BufferedReader r = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			String ausgabeClient = null;
		
			OutputStream outputStream = clientSocket.getOutputStream();
			PrintWriter output = new PrintWriter(outputStream, true);
			
			//nachricht in protocol wenn nicht in Protocol dann in Command process durchsuchen..
			
			
			
				
			while((ausgabeClient = r.readLine()) != null) {
					//ausgabeClient= protocol.process(null);
					System.out.println("Client sagt: " + ausgabeClient);
				
				
					
					
					
					/*Aufgabe 2	if(ausgabeClient.equalsIgnoreCase("hello")) {
						
						output.println("World!\n");
						output.flush();
						output.close();
					} else {
						System.out.println("Kannst du bitte 'Hello' sagen!\n");
					}
					break;
				}*/
				
				clientSocket.close();

				
			}
			//Server antwortet bevor Client sich verbinde
		} catch(IOException e) {
			System.out.println("Server hat einen Fehler!");
		}
	}
	
}
	