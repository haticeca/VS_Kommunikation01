package org.htw.fiw.vs;

import java.text.DateFormat;
import java.util.Date;

public class TimeRunnable implements Runnable {
	/**
	 * Wartet 1000ms bzw 1 sek und gibt die Zeit an. Gibt sekunden an.
	 * */
	@Override
	public void run() {
		try {
			Thread.sleep(1000);
			System.out.println(DateFormat.getTimeInstance().format(new Date())); 
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
