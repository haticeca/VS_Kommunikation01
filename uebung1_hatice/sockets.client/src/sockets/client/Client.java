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
			Socket client = new Socket("localhost", 777);
			OutputStream outputStream = client.getOutputStream();
			PrintWriter output = new PrintWriter(outputStream);
			
			String[] eingabe = {"+ 5 6", "hello", "- 2 4"};
				
			//Antwort des Servers lesen und ausgeben
			BufferedReader r = new BufferedReader(new InputStreamReader(client.getInputStream()));
			
			
			for(int i = 0; eingabe.length > i; i++) {
				System.out.println("Client fragt: "+ eingabe[i]);
				output.println(eingabe[i]);
				output.flush();
//				String vomServer = r.readLine();
				System.out.println("Server antwort: " + r.readLine());
			}
			client.close();
				
		} catch (Exception ex) {
			//ex.printStackTrace();
			System.out.println("Kein Server Gefungen. Starten Sie zuerst den Server!");
		}
	}
			
}
