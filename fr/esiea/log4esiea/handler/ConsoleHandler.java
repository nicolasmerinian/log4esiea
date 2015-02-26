package fr.esiea.log4esiea.handler;

public class ConsoleHandler implements Handler {

	public ConsoleHandler() {
		super();
	}
	
	@Override
	public void print(String message) {
		System.out.println(message);
	}

}
