package wordCount.util;

/**
 * Logger Class This class is responsible for logging message 
 * based off passed
 * debug level
 * 
 * @author PRASHANT
 *
 */
public class Logger {

	/**
	 * Enum DebugLevel
	 * 
	 * @author PRASHANT
	 *
	 */
	public static enum DebugLevel {
		CONSTRUCTOR, Visit, NotifyObserver, NO_OUTPUT
	};

	/**
	 * static DebugLevel class variable
	 */
	private static DebugLevel debugLevel;

	/**
	 * setDebugValue This Method sets debug level to passed level in value
	 * 
	 * @param levelIn
	 *            debug level
	 */
	public static void setDebugValue(int levelIn) {
		switch (levelIn) {
		case 3:
			debugLevel = DebugLevel.CONSTRUCTOR;
			break;
		case 2:
			debugLevel = DebugLevel.Visit;
			break;
		case 1:
			debugLevel = DebugLevel.NotifyObserver;
			break;
		case 0:
			debugLevel = DebugLevel.NO_OUTPUT;
			break;
		}
	}

	/**
	 * setDebugValue sets debug value from logger enum
	 * 
	 * @param levelIn
	 *            debug level
	 */
	public static void setDebugValue(DebugLevel levelIn) {
		debugLevel = levelIn;
	}

	/**
	 * writeMessage Method, used to std out message based off Logger level
	 * 
	 * @param message
	 *            message to print
	 * @param levelIn
	 *            debug level
	 */
	public static void writeMessage(String message, DebugLevel levelIn) {
		if (levelIn == debugLevel)
			System.out.println(message);
	}

	/**
	 * toString() method
	 * 
	 * @returns - string to print debug level
	 */
	public String toString() {
		return "Debug Level is " + debugLevel;
	}
}
