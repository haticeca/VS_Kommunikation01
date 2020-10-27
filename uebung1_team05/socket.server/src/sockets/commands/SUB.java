package sockets.commands;

import sockets.server.Command;

public class SUB extends Command{

	public SUB() {
		
		super("");
		
	}
	@Override
	public String process(String[] args) {
		int subtraktion = 0;
		String stringSumme = null;
		
		for(int i = 1; args.length > i; i++) {
			subtraktion = subtraktion + Integer.parseInt(args[i]);
			stringSumme = String.valueOf(subtraktion);
		} 
		return stringSumme;
	}

}
