package org.htw.fiw.vs.commands;

import org.htw.fiw.vs.Command;

public class HelloWorld extends Command {

	public HelloWorld() {
		super("hello");
	}

	@Override
	public String process(String... args) {
		return "world!";
	}

}
