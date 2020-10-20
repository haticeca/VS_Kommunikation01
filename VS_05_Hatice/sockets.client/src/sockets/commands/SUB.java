package sockets.commands;

import sockets.server.Command;

public class SUB extends Command{

	public SUB(String string) {
		
		super(string);
		
	}
	@Override
	public String process(String[] args) {
		return "world";
	}

}
