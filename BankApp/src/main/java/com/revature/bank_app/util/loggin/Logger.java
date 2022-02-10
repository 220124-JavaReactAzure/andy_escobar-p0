package com.revature.bank_app.util.loggin;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class Logger {
	
	private static final String ANSI_RED = "\u001B[31m";
	private static final String ANSI_RESET = "\u001B[0m";
	
	private static Logger logger;
	private final boolean printToConsole;
	
	private Logger(boolean printToConsole) {
		this.printToConsole = printToConsole;
	}
	
	public static Logger getLogger(boolean printToConsole) {
		// Lazy singleton
		if(logger == null) {
			logger = new Logger(printToConsole);
		}
		
		return logger;
	}
	
	public void log(String message) {
		try(Writer logWriter = new FileWriter("src/main/resources/bank_app.log", true);) {
		
			logWriter.write(message + "\n");
			
			if(printToConsole) {
				System.out.println(ANSI_RED + message + ANSI_RESET);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
