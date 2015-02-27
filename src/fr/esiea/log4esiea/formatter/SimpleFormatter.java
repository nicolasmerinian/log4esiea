package fr.esiea.log4esiea.formatter;

import fr.esiea.log4esiea.Level;

public class SimpleFormatter implements Formatter {

	private Level level;
	private String format;

	public SimpleFormatter() {
		super();
	}
	
	public SimpleFormatter(Level level) {
		this();
		this.level = level;
	}
	
	public SimpleFormatter(String format) {
		this();
		this.format = format;
	}
	
	public SimpleFormatter(Level level, String format) {
		this(level);
		this.format = format;
	}

	public Level getLevel() {
		return level;
	}

	public void setLevel(Level level) {
		this.level = level;
	}

	public String getFormat() {
		return format;
	}
	
	public void setFormat(String format) {
		this.format = format;
	}

	@Override
	public String format(String message, String className, String methodName, int lineNumber) {
		return this.getLevel() + " " + className + "." + methodName + " l." + lineNumber + " : " + message;
	}

	

}
