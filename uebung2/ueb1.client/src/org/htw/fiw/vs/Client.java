package org.htw.fiw.vs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class Client {
	
	
	public static void main(String[] args) throws IOException, InterruptedException {
		new Client().start();
	}

	public void start() throws IOException {
		Socket client = new Socket(InetAddress.getLocalHost(), 8080);

		BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
		PrintWriter out = new PrintWriter(client.getOutputStream(), true);
		System.out.println("bitte Eingabe");
		@SuppressWarnings("resource")
		Scanner s = new Scanner(System.in);

		String msg = s.nextLine();//{ "hello", "- 9 4", "* 5 3" };
		/*for (int i = 0; i < msg.length; i++) {
			System.out.println("--> " + msg[i]);
			out.println(msg[i]);
			System.out.println("<-- " + in.readLine());
		}*/
		out.println(msg);
		System.out.println("<--" + in.readLine());
		client.close();
	}

}
