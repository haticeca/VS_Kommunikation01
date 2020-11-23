package org.htw.fiw.vs.server;

import java.rmi.RemoteException;

import org.htw.fiw.vs.interfaces.HelloWorld;

public class HelloWorldImpl extends java.rmi.server.UnicastRemoteObject implements HelloWorld{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	protected HelloWorldImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}
	

	@Override
	public String sayHello(String user) {
		
		return "Hello " + user + "!";
	}

}
