package org.htw.fiw.vs.commands;

import org.htw.fiw.vs.Command;

public class Multiply extends Command {

	public Multiply() {
		super("*");
	}

	@Override
	public String process(String... args) {
		int result = 1;
		for (String arg : args) {
			try {
				result *= Integer.parseInt(arg);
			} catch (NumberFormatException e) {
				// not a number
			}
		}
		return String.valueOf(result);
	}

}
