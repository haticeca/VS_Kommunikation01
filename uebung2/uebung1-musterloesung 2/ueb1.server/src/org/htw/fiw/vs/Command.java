package org.htw.fiw.vs;

public abstract class Command {

	private final String id;

	protected Command(String id) {
		this.id = id;
	}

	public abstract String process(String... args);

	public String id() {
		return this.id;
	}
}