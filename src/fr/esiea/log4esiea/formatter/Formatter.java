package fr.esiea.log4esiea.formatter;

import fr.esiea.log4esiea.Level;


public interface Formatter {
	
	/**
	 * 
	 * @param level
	 */
	public void setLevel(Level level);
	
	/**
	 * 
	 * @param format
	 */
	public void setFormat(String format);
	
	/**
	 * 
	 * @return
	 */
	public String getFormat();
	
	/**
	 * 
	 * @param message
	 * @param className
	 * @param methodName
	 * @param lineNumber
	 * @return
	 */
	public String format(String message, String className, String methodName, int lineNumber);
}
