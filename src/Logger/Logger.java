package Logger;

public class Logger {
	private static Logger logger;
	
	public Logger() {
		super();
	}

	public static Logger getLogger() {
		return logger;
	}

	public static void setLogger(Logger logger) {
		Logger.logger = logger;
	}

	@Override
	public String toString() {
		return "Logger []";
	}
	
	
}
