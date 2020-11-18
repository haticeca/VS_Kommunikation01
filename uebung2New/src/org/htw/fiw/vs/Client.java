package org.htw.fiw.vs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class Client implements Runnable {
	
	
	public static void main(String[] args) throws IOException, InterruptedException {
		
		int numberOfClients = 100;
		for(int i = 0 ; i < numberOfClients ; i++ ) {
			new Client().start(i);
		}
		
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			start(2);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void start(int count) throws IOException {
		Socket client = new Socket("localhost", 8080);

		BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
		PrintWriter out = new PrintWriter(client.getOutputStream(), true);

		//Scanner sc = new Scanner(System.in);
		System.out.print("Anfrage an Server: ");
		
		String message = null;
		
		switch (count % 4) {
			case 0: {
				message = "+ 2 3 4";
				break;
			}
			case 1: {
				message = "hello";
				break;
			}
			case 2: {
				message = "* 2 1 9 5";
				break;
			}
			case 3: {
				message = "- 100 20 25";
				break;
			}
		}
				
		//String eingabe = sc.nextLine();
		//String[] msg = eingabe.split(",");
		//String[] msg = {"hello", "+ 3 5", "* 6 8"};
		

		System.out.println("--> " + message);
		out.println(message);
		System.out.println("<-- " + in.readLine());
		System.out.println("Exiting...");
		
		client.close();
	}



	
}
