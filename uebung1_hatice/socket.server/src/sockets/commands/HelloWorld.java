package sockets.commands;

import sockets.server.Command;

public class HelloWorld extends Command{
	
	public HelloWorld() {
		super("hello");
	}
	
	public String process(String[] args) {
		return "world";
	}
}
