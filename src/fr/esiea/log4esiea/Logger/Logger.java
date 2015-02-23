package fr.esiea.log4esiea.Logger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class Logger {
	private static Logger logger;
	private static Map<Class<?>, Logger> map = new HashMap<Class<?>, Logger>();
	private Class<?> targetClass;
	public ArrayList appenders;
	
	private Logger() {
		super();
	}

	private Logger(Class<?> targetClass) {
		this();
		this.targetClass = targetClass;
		this.appenders = new ArrayList();
	}

	public static Logger getLogger(Class<?> targetClass) {
		return get(targetClass);
	}
	
	public static Logger get(Class<?> c) {
		logger = map.get(c);
		if (logger == null) {
			logger = new Logger(c);
			map.put(c, logger);
		}
		return logger;
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
