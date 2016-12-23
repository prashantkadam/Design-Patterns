package registrationScheduler.util;
import java.util.Scanner;

/**
 * FileProcessor Class used to read file and pass single line
 * at a time
 * @author PRASHANT
 *
 */
public class FileProcessor {
	
	/**
	 * private Scanner Object
	 */
	private Scanner fileScanner = null;
	
	/**
	 * Class Constructor
	 * @param scannerIn
	 */
	public FileProcessor(Scanner scannerIn) {
		fileScanner = scannerIn;
		Logger.writeMessage("\n--------------------------- In FileProcessor Constructor ---------------------------\n"
				+" scanner Object assigned\n"
				+ "---------------------------------------------------------------------------------\n"
				, Logger.DebugLevel.CONSTRUCTOR);
		
	}
	
	public void closeScanner() {
		fileScanner.close();
	}
	
	/**
	 * readLine Method
	 * synchronized readLine Method return a single line at a time from file
	 * @param name
	 * @return 	single line from file
	 */
	public synchronized String readLine() {
		String line = null;
		try {
			if(!fileScanner.hasNextLine())
				return null;
			line = fileScanner.nextLine();			
		} catch (Exception e) {
			System.err.println(" Exception Occured - \n");
			e.printStackTrace();
			System.exit(0);
		}
		finally{
			// closing file scanner where readline is called
		}
		
		return line;
	}

}
