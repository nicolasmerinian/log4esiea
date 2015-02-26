package fr.esiea.log4esiea.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Properties;
import java.util.TimeZone;

public class Utils {
	
	public static Properties getConfig(String filename) {
		Properties properties = new Properties();
		InputStream input = null;
		try {
			input = new FileInputStream(filename);
			properties.load(input);
		} 
		catch (IOException ex) {
			ex.printStackTrace();
		} 
		finally {
			if (input != null) {
				try {
					input.close();
				} 
				catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return properties;
	}
	
	public static MyDate getMyDate() {
		MyDate myDate = new MyDate();
        Date date = new Date();
        Calendar calendar = GregorianCalendar.getInstance();
        calendar.setTime(date);
        Calendar localCalendar = Calendar.getInstance(TimeZone.getDefault());
        
        myDate.setDay(localCalendar.get(Calendar.DATE) + "");
        myDate.setMonth(localCalendar.get(Calendar.MONTH) + 1 + "");
        myDate.setYear(localCalendar.get(Calendar.YEAR) + "");
        myDate.setHour(calendar.get(Calendar.HOUR_OF_DAY) + "");
        myDate.setMinute(calendar.get(Calendar.MINUTE) + "");
        myDate.setSecond(calendar.get(Calendar.SECOND) + "");
        
        return myDate;
	}
}
