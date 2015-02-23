package fr.esiea.log4esiea.Logger;

public abstract class AbstractLogger implements LoggerInterface {
	public abstract void trace(String message);
	public abstract void debug(String message);
	public abstract void info(String message);
	public abstract void warn(String message);
	public abstract void error(String message);
	public abstract void fatal(String message);
}
