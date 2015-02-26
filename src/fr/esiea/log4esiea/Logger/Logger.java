package fr.esiea.log4esiea.logger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import fr.esiea.log4esiea.Level;


public class Logger extends AbstractLogger {
	private static Logger logger;
	private static Map<Class<?>, Logger> map = new HashMap<Class<?>, Logger>();
	private Class<?> targetClass;
	private Level level;
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
	

	public void setLevel(Level level) {
		this.level = level;
	}
	
	public Level getLevel() {
		return this.level;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Logger=[");
		builder.append("class=");
		builder.append(this.targetClass);
		builder.append("]");
		return builder.toString();
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

	@Override
	public void trace(String message) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void debug(String message) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void info(String message) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void warn(String message) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void error(String message) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fatal(String message) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void loadProperties() {
		// TODO Auto-generated method stub
		
	}
	
}
