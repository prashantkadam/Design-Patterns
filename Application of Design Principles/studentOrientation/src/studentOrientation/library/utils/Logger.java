package studentOrientation.library.utils;

/**
 * Logger class for debugging the application
 * @author rishimalani <rmalani1@binghamton.edu>
 *
 */
public class Logger {
	
	/**
	 * Default class constructor
	 */
	public Logger() {
		writeMessage("Constructor called: Logger", DebugLevel.CONSTRUCTOR);
	}

	/**
	 * enumerator for the debug levels
	 */
	public static enum DebugLevel {
		RESULTPRINT, CONSTRUCTOR, ACTIVITYDONE;
	};

	/**
	 * debug level for the current run
	 */
	private static DebugLevel debugLevel;
	
	/**
	 * method to set the debug level for
	 * current run
	 * @param levelIn integer value for the
	 * debug level
	 */
	public static void setDebugValue(int levelIn) {
		switch (levelIn) {
		case 0:
			debugLevel = DebugLevel.RESULTPRINT;
			break;
		case 1:
			debugLevel = DebugLevel.ACTIVITYDONE;
			break;
		case 2:
			debugLevel = DebugLevel.CONSTRUCTOR;
			break;
		default:
			debugLevel = DebugLevel.RESULTPRINT;
			break;
		}
	}

	/**
	 * method to set the debug value for the 
	 * current run
	 * @param levelIn debug level to set
	 */
	public static void setDebugValue(DebugLevel levelIn) {
		debugLevel = levelIn;
	}

	/**
	 * method to log the debug activities for 
	 * the application
	 * @param message	message to write for activity
	 * @param levelIn	debug level of the activity
	 */
	public static void writeMessage(String message, DebugLevel levelIn) {
		if (levelIn == debugLevel)
			System.out.println(message);
	}

	/**
	 * toString method for debugging purposes
	 */
	public String toString() {
		return "Debug Level is " + debugLevel;
	}

}
