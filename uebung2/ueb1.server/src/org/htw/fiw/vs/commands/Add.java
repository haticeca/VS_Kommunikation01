package org.htw.fiw.vs.commands;

import org.htw.fiw.vs.Command;

public class Add extends Command {

	public Add() {
		super("+");
	}

	@Override
	public String process(String... args) {
		int result = 0;
		for (String arg : args) {
			try {
				result += Integer.parseInt(arg);
			} catch (NumberFormatException e) {
				// not a number
			}
		}
		return String.valueOf(result);
	}

}
