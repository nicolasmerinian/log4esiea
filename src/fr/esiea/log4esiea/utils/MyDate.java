package fr.esiea.log4esiea.utils;

public class MyDate {
	private String day;
	private String month;
	private String year;
	private String hour;
	private String minute;
	private String second;
	
	public MyDate() {
		super();
	}
	
	public MyDate(String day, String month, String year, String hour,
			String minute, String second) {
		this();
		this.day = day;
		this.month = month;
		this.year = year;
		this.hour = hour;
		this.minute = minute;
		this.second = second;
		this.checkMonth();
		this.checkHour();
		this.checkSecond();
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
		this.checkMonth();
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getHour() {
		return hour;
	}

	public void setHour(String hour) {
		this.hour = hour;
		this.checkHour();
	}

	public String getMinute() {
		return minute;
	}

	public void setMinute(String minute) {
		this.minute = minute;
	}

	public String getSecond() {
		return second;
	}

	public void setSecond(String second) {
		this.second = second;
		this.checkSecond();
	}

	@Override
	public String toString() {
		return "MyDate [day=" + day + ", month=" + month + ", year=" + year
				+ ", hour=" + hour + ", minute=" + minute + ", second="
				+ second + "]";
	}
	
	private void checkMonth() {
		if (this.month != null & this.month.length() < 2) {
			this.month = "0" + this.month;
		}
	}
	
	private void checkHour() {
		if (this.hour != null 
				& this.hour.length() < 2) {
			this.hour = "0" + this.hour;
		}
	}
	
	private void checkSecond() {
		if (this.second != null & this.second.length() < 2) {
			this.second = "0" + this.second;
		}
	}
	
	
	
}
