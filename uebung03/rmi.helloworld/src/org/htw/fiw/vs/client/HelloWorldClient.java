package org.htw.fiw.vs.client;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import org.htw.fiw.vs.interfaces.HelloWorld;

public class HelloWorldClient {
	
	public static void main(String[] args) {
		try {
			HelloWorld obj = (HelloWorld) Naming.lookup("rmi://localhost:8080/HelloWorldService");
			
			String user = "Hatice";
			System.out.println(obj.sayHello(user));
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
