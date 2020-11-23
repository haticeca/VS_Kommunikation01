package org.htw.fiw.vs.server;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;

import org.htw.fiw.vs.interfaces.HelloWorld;

public class HelloWorldServer {

	public HelloWorldServer(){
		try {
			HelloWorld obj = new HelloWorldImpl();
			Naming.bind("rmi://localhost:8080/HelloWorldService", obj);
			System.out.println();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (AlreadyBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
