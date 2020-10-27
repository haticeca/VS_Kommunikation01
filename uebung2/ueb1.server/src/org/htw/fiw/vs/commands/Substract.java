package org.htw.fiw.vs.commands;

import org.htw.fiw.vs.Command;

public class Substract extends Command {

	public Substract() {
		super("-");
	}

	@Override
	public String process(String... args) {
		boolean first = true;
		int result = 0;
		for (String arg : args) {
			try {
				if (first) {
					result = Integer.parseInt(arg);
					first = false;
				} else {
					result -= Integer.parseInt(arg);
				}
			} catch (NumberFormatException e) {
				// not a number
			}
		}
		return String.valueOf(result);
	}

}
