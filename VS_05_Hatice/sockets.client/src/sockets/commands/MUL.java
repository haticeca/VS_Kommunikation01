package sockets.commands;

import sockets.server.Command;

public class MUL extends Command{

	public MUL(String string) {
		super(string);
	
	}
	
	@Override
	public String process(String[] args) {
		return "world";
	}

}
