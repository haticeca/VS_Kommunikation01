package sockets.server;


public abstract class Command {
	
	
	public Command(String string) {}
		

	/*  
	 * Wir gehen davon aus der erste Index args[0] +,- oder * ist
	 * addieren/subrahieren/multiplizieren je nach Command in 
	 * der For-Schleife mit den nächsthöheren Index hintereinander 
	 * Allerding wird davor der Array mit dem index in Int geparst 
	 * und bei der Rückgabe wieder in String geparst und Ergebnis 
	 * als Summe oder etc. zurückgeschickt.
	 * 
	 * PS: Es können nur zwei zahlen eingegeben werden
	 * Pattern nicht vollständig siehe Klasse Procotol Methode process(msg)
	 *  
	 */
	
	
	public String process(String[] args) {
		return null;
	}
	
		
		 
}
