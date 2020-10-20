package sockets.commands;

import sockets.server.Command;

public class ADD extends Command{

	public ADD() {
		super("hello");
	}
	
	@Override
	public String process(String[] args) {
		return "world";
	}
}
