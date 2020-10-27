package org.htw.fiw.vs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	private Protocol protocol = new Protocol();
	
	public static void main(String[] args) throws IOException {
		new Server().start();
	}

	public void start() throws IOException {
		// erstelle neuen Socket mit bestimmter Portnummer
		ServerSocket serverSocket = new ServerSocket(8080);
		System.out.println("server started at: " + serverSocket.getLocalSocketAddress());
		try {
			while (true) {
				Socket client = serverSocket.accept();
				System.out.println("new client from: " + client.getRemoteSocketAddress());

				BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
				PrintWriter out = new PrintWriter(client.getOutputStream(), true);

				String msg, response;
				while ((msg = in.readLine()) != null) {
					System.out.println("< " + msg);
					response = this.protocol.process(msg);
					if (response == null) {
						response = "unknown command";
					}
					System.out.println("> " + response);
					out.println(response);
				}

				System.out.println("closing client connection: " + client.getRemoteSocketAddress());
				client.close();
			}
		} finally {
			serverSocket.close();
		}
	}
}
