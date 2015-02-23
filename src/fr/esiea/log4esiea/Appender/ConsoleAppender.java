package fr.esiea.log4esiea.Appender;

public class ConsoleAppender implements Appender{

	public ConsoleAppender(){
		super();
	}
	
	@Override
	public void print(String message) {
		// TODO Auto-generated method stub
		System.out.println(message);
		
	}

	
	
}
