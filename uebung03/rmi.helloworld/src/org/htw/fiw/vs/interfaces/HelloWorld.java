package org.htw.fiw.vs.interfaces;

public interface HelloWorld extends java.rmi.Remote {
		
	public String sayHello(String user) throws java.rmi.RemoteException;
	
}
