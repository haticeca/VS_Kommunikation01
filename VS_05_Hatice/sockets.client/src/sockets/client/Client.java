package sockets.client;

import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class Client {
	
	public static void main(String[] args) {
		
		try{
			//InetAddress.getLocalHost()
			Socket client = new Socket("localhost", 777);
			//SendeDatenstrom holen
			OutputStream outputStream = client.getOutputStream();
			//Die Rückgabe in ein Ausgabestream schreiben
			PrintWriter output = new PrintWriter(outputStream);
			
			String[] eingabe = {"+ 5 6", "hello", "- 2 4"};
			
			
			//Antwort des Servers lesen und ausgeben
			BufferedReader r = new BufferedReader(new InputStreamReader(client.getInputStream()));
			String ausgabeServer = r.readLine();
			
			
			while(ausgabeServer != null) {
				
				for(int i = 0; eingabe.length > i; i++) {
					System.out.println("1. Client fragt: "+ eingabe[i]);
					output.print(eingabe[i]);
					output.flush();
				}
				
				System.out.println("Server sagt: " + ausgabeServer);
				break;
			}
			r.close();
			output.close();
			client.close();
		} catch (Exception ex) {
			//ex.printStackTrace();
			System.out.println("Kein Server Gefungen. Starten Sie zuerst den Server!");
		}
	}
			
}
