package sockets.server;


public abstract class Command {
	
	
	public Command(String string) {}
		

	/*  
	 * Suche ob in dem String[] max. ein Zeichen: +, -, : 
	 * und mind. 2 oder mehrere Zahlen enthalten 
	 * sind und ordne sie in der Schleife mit Hilfe von
	 * if-Abfragen den jeweiligen Methoden zu.
	 * String-Array erwartet Eingaben nach dem Muster:
	 *  + 2 3 4 * oder - 2 5 9 8 oder hello*
	 *  
	 */
	
	
	public String process(String[] args) {
		return null;
	}
	
		
		 
}
