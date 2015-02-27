package fr.esiea.log4esiea.logger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import fr.esiea.log4esiea.Constants;
import fr.esiea.log4esiea.Level;
import fr.esiea.log4esiea.formatter.Formatter;
import fr.esiea.log4esiea.formatter.SimpleFormatter;
import fr.esiea.log4esiea.handler.ConsoleHandler;
import fr.esiea.log4esiea.handler.DatabaseHandler;
import fr.esiea.log4esiea.handler.FileHandler;
import fr.esiea.log4esiea.handler.Handler;
import fr.esiea.log4esiea.utils.Utils;


public class Logger extends AbstractLogger {
	private static Logger logger;
	private static Map<Class<?>, Logger> map = new HashMap<Class<?>, Logger>();
	private Class<?> targetClass;
	private Level level;
	private ArrayList<Handler> handlers;
	private Formatter formatter;
	private String methodName;
	private int lineNumber;
	private String format;
	
	private Logger() {
		super();
	}
	
	private Logger(Class<?> targetClass) {
		this();
		this.targetClass = targetClass;
		this.handlers = new ArrayList<Handler>();
		this.loadProperties();
	}
	
	private Logger(Class<?> targetClass, Formatter formatter) {
		this(targetClass);
		this.formatter = formatter;
	}

	public Class<?> getTargetClass() {
		return targetClass;
	}

	public void setTargetClass(Class<?> targetClass) {
		this.targetClass = targetClass;
	}

	public static Logger getLogger(Class<?> targetClass) {
		return get(targetClass);
	}
	
	public static Logger get(Class<?> c) {
		synchronized (map) {
			logger = map.get(c);
			if (logger == null) {
				logger = new Logger(c);
				map.put(c, logger);
			}
			return logger;
		}
	}

	public void setLevel(Level level) {
		this.level = level;
		formatter.setLevel(this.level);
	}
	
	public Level getLevel() {
		return this.level;
	}

	public Formatter getFormatter() {
		return formatter;
	}
	
	public void setFormatter(Formatter formatter) {
		this.formatter = formatter;
		this.formatter.setLevel(this.level);
		if (this.formatter.getFormat() == null || this.formatter.getFormat().isEmpty()) {
			this.formatter.setFormat(this.format);
		}
	}

	public String getFormat() {
		return format;
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
	
	public void debug(String message) {
		if (this.level.getLevel() <= Level.DEBUG.getLevel() && this.level.getLevel() > 0) {
			Thread thread = Thread.currentThread();
			this.methodName = thread.getStackTrace()[2].getMethodName();
		    this.lineNumber = thread.getStackTrace()[2].getLineNumber();
			sendToHandlers(message);
		}
	}
	
	public void info(String message) {
		if (this.level.getLevel() <= Level.INFO.getLevel() && this.level.getLevel() > 0) {
			Thread thread = Thread.currentThread();
			this.methodName = thread.getStackTrace()[2].getMethodName();
		    this.lineNumber = thread.getStackTrace()[2].getLineNumber();
			sendToHandlers(message);
		}
	}
	
	public void warn(String message) {
		if (this.level.getLevel() <= Level.WARN.getLevel() && this.level.getLevel() > 0) {
			Thread thread = Thread.currentThread();
			this.methodName = thread.getStackTrace()[2].getMethodName();
		    this.lineNumber = thread.getStackTrace()[2].getLineNumber();
			sendToHandlers(message);
		}
	}
	
	public void error(String message) {
		if (this.level.getLevel() <= Level.ERROR.getLevel() && this.level.getLevel() > 0) {
			Thread thread = Thread.currentThread();
			this.methodName = thread.getStackTrace()[2].getMethodName();
		    this.lineNumber = thread.getStackTrace()[2].getLineNumber();
			sendToHandlers(message);
		}
	}
	
	public void fatal(String message) {
		if (this.level.getLevel() <= Level.FATAL.getLevel() && this.level.getLevel() > 0) {
			Thread thread = Thread.currentThread();
			this.methodName = thread.getStackTrace()[2].getMethodName();
		    this.lineNumber = thread.getStackTrace()[2].getLineNumber();
			sendToHandlers(message);
		}
	}
	
	@Override
	public void trace(String message) {
		if (this.level.getLevel() == Level.TRACE.getLevel() || this.level.getLevel() == Level.ALL.getLevel()) {
			Thread thread = Thread.currentThread();
			this.methodName = thread.getStackTrace()[2].getMethodName();
		    this.lineNumber = thread.getStackTrace()[2].getLineNumber();
			sendToHandlers(message);
		}
	}
	
	private void sendToHandlers(String message) {
		for (Handler handler : this.handlers) {
			handler.print(this.formatter.format(message, this.targetClass.getName(), this.methodName, this.lineNumber));
		}
	}
	
	protected void loadProperties() {
		Properties properties = Utils.getConfig(Constants.CONFIG_FILE);
		boolean handlerConsoleProp = Boolean.parseBoolean(properties.getProperty(Constants.APPENDER_CONSOLE).toLowerCase());
		boolean handlerFileProp = Boolean.parseBoolean(properties.getProperty(Constants.APPENDER_FILE));
		boolean handlerDatabaseProp = Boolean.parseBoolean(properties.getProperty(Constants.APPENDER_DATABASE));
		String formatterProp = properties.getProperty(Constants.FORMATTER);
		String levelProp = properties.getProperty(Constants.LEVEL).toUpperCase();
		String formatProp = properties.getProperty(Constants.FORMAT);
		
		this.level = Level.valueOf(levelProp);
		
		if (handlerConsoleProp) {
			this.handlers.add(new ConsoleHandler());
		}
		if (handlerFileProp) {
			this.handlers.add(new FileHandler("logs.txt"));
		}
		if (handlerDatabaseProp) {
			this.handlers.add(new DatabaseHandler());
		}
		
		this.format = formatProp;
		
		switch (formatterProp) {
			case Constants.SIMPLE: 
				this.formatter = new SimpleFormatter(this.level, this.format);
				break;
		}
	}
	
}
