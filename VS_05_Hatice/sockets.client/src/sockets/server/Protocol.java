package sockets.server;
import java.util.regex.Pattern;

import sockets.commands.ADD;
import sockets.commands.HelloWorld;
import sockets.commands.MUL;
import sockets.commands.SUB;

import java.util.regex.Matcher;

public class Protocol {
//extends Command {
	
	ADD a;
	SUB s;
	MUL m;
	HelloWorld hw;
	
	public Protocol(){}
	
	public Protocol(ADD plus, SUB minus, MUL mal){
		this.a= plus;
		this.s = minus;
		this.m = mal;
	}
	
	public String process(String msg) {
		
		
		Pattern pattern = Pattern.compile("(+-*)|[Hh]ello");
		Matcher matcher = pattern.matcher(msg);
		
		//msg splitten in Array
		
		
		for(int i = 0; msg.length() > i; i++ ) {
			
			if(msg.equalsIgnoreCase("Hello")) {
				return this.hw.toString();
			}
		}
		return null;
		
		
//		String outPut = null;
//		
//		Pattern pattern = Pattern.compile("[Hh]ello");
//		Matcher matcher = pattern.matcher(msg);
//		
//		while(matcher.find()) {
//			outPut = "World!";
//		}
//		
//		return outPut;
//		
	}

}
