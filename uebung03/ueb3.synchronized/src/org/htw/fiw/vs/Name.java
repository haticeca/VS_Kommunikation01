package org.htw.fiw.vs;

public class Name {

	private String first;

	private String last;

	public void set(String first, String last) {
		this.first = first;
		this.last = last;
		try {
			Thread.sleep(1);					// Je mehr hier Thread schlafen gelassen wird bringt es Vorteile für BJ
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public String get() {
		return this.first + " " + this.last;
	}

}
