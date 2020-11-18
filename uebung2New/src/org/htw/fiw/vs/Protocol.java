package org.htw.fiw.vs;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.htw.fiw.vs.commands.Add;
import org.htw.fiw.vs.commands.HelloWorld;
import org.htw.fiw.vs.commands.Multiply;
import org.htw.fiw.vs.commands.Substract;

public class Protocol {

	private Map<String, Command> cmds = new ConcurrentHashMap<>();

	public Protocol() {
		this.addCommand(new HelloWorld());
		this.addCommand(new Add());
		this.addCommand(new Substract());
		this.addCommand(new Multiply());
	}

	public Protocol addCommand(Command command) {
		this.cmds.put(command.id(), command);
		return this;
	}

	/**
	 * message format: <cmd> <arg-1> <arg-2> ... <arg-n>
	 * 
	 * @param msg
	 * @return
	 */
	public String process(String msg) {
		// parse msg and get tokens
		String[] tokens = msg.split(" "); //  + "2 5 7 8 9"   -> ["2", "5", "7", "8", "9"]

		// search cmd for first token
		Command command = this.cmds.get(tokens[0]);
		if (command == null) {
			return null;
		}

		String[] args = null;

		// remove first token
		if (tokens.length > 1) {
			args = new String[tokens.length - 1];
			System.arraycopy(tokens, 1, args, 0, args.length);
		}

		// execute cmd and return result
		return command.process(args);
	}

}
