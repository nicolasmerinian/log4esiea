package fr.esiea.log4esiea.formatter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import fr.esiea.log4esiea.Level;
import fr.esiea.log4esiea.utils.MyDate;
import fr.esiea.log4esiea.utils.Utils;

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
		StringBuilder formattedMessage = new StringBuilder();
	    MyDate date = Utils.getMyDate();
		String keyString = "(dd|MM|yyyy|hh|mm|ss|L|C|D|r|x|\\(|\\)|\\[|\\]|:| |/|-|.)";
		Pattern p = Pattern.compile(keyString);
		Matcher m = p.matcher(this.format);
		while (m.find()) {
		    String matched = m.group(1);
		    switch (matched) {
		    case "dd":
		    	formattedMessage.append(date.getDay());
		    	break;
		    case "MM":
		    	formattedMessage.append(date.getMonth());
		    	break;
		    case "yyyy":
		    	formattedMessage.append(date.getYear());
		    	break;
		    case "hh":
		    	formattedMessage.append(date.getHour());
		    	break;
		    case "mm":
		    	formattedMessage.append(date.getMinute());
		    	break;
		    case "ss":
		    	formattedMessage.append(date.getSecond());
		    	break;
		    case "L":
		    	formattedMessage.append(this.level.name());
		    	break;
		    case "C":
		    	formattedMessage.append(className);
		    	break;
		    case "D":
		    	formattedMessage.append(methodName);
		    	break;
		    case "r":
		    	formattedMessage.append(lineNumber);
		    	break;
		    case "x":
		    	formattedMessage.append(message);
		    	break;
		    default:
		    	formattedMessage.append(matched);
		    	break;
		    }
		}
		return formattedMessage.toString();
	}

	

}
