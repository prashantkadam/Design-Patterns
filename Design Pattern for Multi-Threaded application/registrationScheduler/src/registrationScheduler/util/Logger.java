package registrationScheduler.util;

/**
 * Logger Class
 * This class is responsible for logging message 
 * based off passed debug level 
 * @author PRASHANT
 *
 */
public class Logger{

	/**
	 * Enum DebugLevel
	 * @author PRASHANT
	 *
	 */
    public static enum DebugLevel 
    { 
    	CONSTRUCTOR,
    	THREAD_RUN,
    	RESULT_DATA_STRUCTURE,
    	STORE_DATA_STRUCTURE,
    	NO_OUTPUT    	
    };

    /**
     * static DebugLevel class variable
     */
    private static DebugLevel debugLevel;

    /**
     * setDebugValue 	 This Method sets debug level to passed levelin value
     * @param levelIn	 debug level
     */
    public static void setDebugValue (int levelIn) {
		switch (levelIn) {
		  case 4: debugLevel = DebugLevel.CONSTRUCTOR; break;
		  case 3: debugLevel = DebugLevel.THREAD_RUN; break;
		  case 2: debugLevel = DebugLevel.RESULT_DATA_STRUCTURE; break;
		  case 1: debugLevel = DebugLevel.STORE_DATA_STRUCTURE; break;
		  case 0: debugLevel = DebugLevel.NO_OUTPUT; break;
		}
    }
	/**
	 * setDebugValue 	sets debug value from logger enum 
	 * @param 	levelIn debug level
	 */
    public static void setDebugValue (DebugLevel levelIn) {
    	debugLevel = levelIn;
    }

    /**
     * writeMessage Method, used to stdout message based off
     * Logger level
     * @param message	message to print
     * @param levelIn	debug level
     */
    public static void writeMessage (String message, DebugLevel levelIn ) {
		if (levelIn == debugLevel)
		    System.out.println(message);
    }

    /**
     * toString() method
     * @returns - string to print debug level
     */
    public String toString() {
    	return "Debug Level is " + debugLevel;
    }
}
