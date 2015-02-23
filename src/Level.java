package log4esiea;

public enum Level {
	
	OFF(0), TRACE(1), ALL(2), DEBUG(3), INFO(4), WARN(5), ERROR(6), FATAL(7);
	private int level;
	
	Level(int level){
		this.level = level;
	}
	
	public int getLevel(){
		return level;
	}
	
	
}
