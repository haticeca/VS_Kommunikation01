package org.htw.fiw.vs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class Client2 {
	
	
	public static void main(String[] args) throws IOException, InterruptedException {
		new Client2().start();
	}

	public void start() throws IOException {
		Socket client = new Socket("192.168.178.55", 8080);

		BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
		PrintWriter out = new PrintWriter(client.getOutputStream(), true);

		Scanner sc = new Scanner(System.in);
		System.out.print("CLient2: Anfrage an Server(trennen sie die Befehle mit einem Komma): ");
		String eingabe = sc.nextLine();
		String[] msg = eingabe.split(",");
		//String[] msg = {"hello", "+ 3 5", "* 6 8"};
		
		for (int i = 0; i < msg.length; i++) {
			if(msg[i].equalsIgnoreCase("exit")) {
				System.out.println("-->Client close.<--");
				client.close();
			}
			System.out.println("--> " + msg[i]);
			out.println(msg[i]);
			System.out.println("<-- " + in.readLine());
		}
		client.close();
	}

}
