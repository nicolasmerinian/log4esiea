package Logger;

import java.util.ArrayList;

public class Logger {
	private static Logger logger;
	public ArrayList appenders;
	
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((appenders == null) ? 0 : appenders.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Logger other = (Logger) obj;
		if (appenders == null) {
			if (other.appenders != null)
				return false;
		} else if (!appenders.equals(other.appenders))
			return false;
		return true;
	}
	
	
}
