import fr.esiea.log4esiea.Logger.Logger;


public class Main {

	public static void main(String[] args) {
		System.out.println("Hello world!");
		Logger log = Logger.getLogger(Main.class);
		Logger log2 = Logger.getLogger(Logger.class);
		System.out.println(log == log2);
		System.out.println(log.equals(log2));
	}

}
