package fr.esiea.log4esiea.formatter;

import fr.esiea.log4esiea.Level;


public interface Formatter {
	public void setLevel(Level level);
	public void setFormat(String format);
	public String getFormat();
	public String format(String message, String className, String methodName, int lineNumber);
}
