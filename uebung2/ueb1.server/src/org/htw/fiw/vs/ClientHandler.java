package org.htw.fiw.vs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.ArrayList;

public class ClientHandler implements Runnable{
	
	private Socket clientSocket;
	private BufferedReader in;
	private PrintWriter out;
	private Protocol p;
	//private ArrayList<ClientHandler> clients;

	public ClientHandler(Socket clientSocket, Protocol protocol) throws IOException {
		this.clientSocket = clientSocket;
		this.p = protocol;
		in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		out = new PrintWriter(clientSocket.getOutputStream(),true);
	}
	
	//zur Verarbeitung der Client-Nachrichten.
	@Override
	public void run() {
		String msg, response;
		try {
			while ((msg = in.readLine()) != null) {
				Thread.sleep(10000);
				System.out.println("< " + msg);
				response = this.p.process(msg);
				if (response == null) {
					response = "unknown command";
				}
					System.out.println("> " + response);
					out.println(response);
			}
			System.out.println("closing client connection: " + this.clientSocket.getRemoteSocketAddress());
			clientSocket.close();
			in.close();
			out.close();
		} catch (IOException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
