package org.htw.fiw.vs;

public class Name {

	private String first;

	private String last;

	public void set(String first, String last) {
		this.first = first;
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.last = last;
	}

	public String get() {
		return this.first + " " + this.last;
	}

}
