package sockets.commands;

import sockets.server.Command;

public class MUL extends Command{

	public MUL() {
		super("");
	
	}
	
	@Override
	public String process(String[] args) {
		
		int multiplikation = 0;
		String stringSumme = null;
		
		for(int i = 1; args.length > i; i++) {
			multiplikation = multiplikation * Integer.parseInt(args[i]);
			stringSumme = String.valueOf(multiplikation);
		} 
		return stringSumme;
		
	}

}
