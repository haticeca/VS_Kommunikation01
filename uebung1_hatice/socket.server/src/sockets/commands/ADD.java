package sockets.commands;

import sockets.server.Command;

public class ADD extends Command{

	public ADD() {
		super("");
	}
	/*
	 * 1)) in der Forschleife dach + suchen
	 * 3)  
	 * 4) mithilfe von index die zwei dezimalstellen speichern 
	 * 5) summe festleden und als String schicken.
	 * 
	 * !!!wenn es noch mehr dezimalzahlen gibt? 
	 */
	@Override
	public String process(String[] args) {
		
		int summe = 0;
		String stringSumme = null;
		
		for(int i = 1; args.length > i; i++) {
			summe = summe + Integer.parseInt(args[i]);
			stringSumme = String.valueOf(summe);
		} 
		return stringSumme;
	}	
}
