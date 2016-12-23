package genericDeser.driver;
import java.io.BufferedReader;
import java.io.FileReader;
import genericDeser.fileOperations.FileProcessor;
import genericDeser.util.Logger;
import genericDeser.util.PopulateObjects;

/**
 * Driver Class
 * 
 * @author PRASHANT
 *
 */
public class Driver {
	/**
	 * Driver Main Method
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Driver driver = new Driver();
		int debugLevel = 0;
		String inputFileName = null;
		try {
			/* validate Command Line Args */
			driver.validateCommandLineArgs(args);
			// Read FileName and debug level
			inputFileName = args[0];
			debugLevel = Integer.parseInt(args[1]);
			// set debug level
			Logger.setDebugValue(debugLevel);
			// file Processor Object
			FileProcessor fpObj = new FileProcessor(new BufferedReader(new FileReader(inputFileName)));
			// Populate Object
			PopulateObjects populateObj = new PopulateObjects(fpObj);
			populateObj.populateDataStructure();
			// Process First and second colletion
			populateObj.processCollection();
			System.out.println("Number of unique First objects: " + populateObj.getUniqueFirst());
			System.out.println("Total Number of First objects: " + populateObj.getTotalFirst());
			System.out.println("Number of unique Second objects: " + populateObj.getUniqueSecond());
			System.out.println("Total Number of Second objects: " + populateObj.getTotalSecond());
		} catch (Exception e) {
			System.err.println(" Exception Occured Method Main \n");
			e.printStackTrace();
			System.exit(0);
		} finally {

		}

	}

	/**
	 * validateCommandLineArgs Method
	 * 
	 * @param args
	 */
	private void validateCommandLineArgs(String[] args) {
		if (args.length != 2) {
			// Validate that the correct number of command line arguments have
			// been passed.
			System.err.println("Running the code: java Driver <input File Name> <debug_level>");
			System.exit(0);
		} else if (Integer.valueOf(args[1]) < 0 || Integer.valueOf(args[1]) > 3) {
			// Validate that the value of
			System.err.println("Running the code: Debug_value should be between 0 and 3 ");
			System.exit(0);
		}
	}
}
