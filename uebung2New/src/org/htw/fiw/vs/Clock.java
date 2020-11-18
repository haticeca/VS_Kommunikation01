package org.htw.fiw.vs;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Clock {
	/**
	 * Ein thread soll ausgeführt werden, jedesmal,wenn TimeRunnable aufgerufen wird, wird jede Sekunde die Zeit ausgegeben
	 * 10 sek werden gezählt ausgegeben
	 * */
	public static void main(String[] args) throws InterruptedException {
		int concurrentOps = 5; 
		ExecutorService pool = Executors.newFixedThreadPool(concurrentOps); //ein thread soll ausgeführt werden
		for (int i = 0; i < concurrentOps * 10; i++) {
			//pool.submit(new TimeRunnable()); 			// wird 10 mal TimeRunnable ausgeführt 
			pool.submit(new Client()); 	
		}

		pool.shutdown();  //keine weiteren tasks accepted während submit ausgeführt wird
		while (!pool.isShutdown()) { // wenn executor nicht beendet
			pool.awaitTermination(500, TimeUnit.MILLISECONDS); // executor läuft noch, dann warte 500 ms meistens damit threads parrallel laufen
		} 
	}
	/**
	 * Annahme bei concurrentOps = 5
	 * awaitTermination: warte auf Kundigung..
	 * während ein Prozess im Executor läuft wird der Executor für 500ms gestoppt 
	 * aber der Thread wird währenddessen weiter ausgeführt
	 * bei 50 durchgängen
	 * Solange der executor nicht beendet ist, wird es 500 ms blockiert die threads bis 
	 * 
	 * weil bei concurrentOps = 5 Server gleichzeitig zählen wird jede Sekunde
	 * */
}
