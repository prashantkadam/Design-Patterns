package registrationScheduler.driver;
import java.io.File;
import java.util.Scanner;

import registrationScheduler.registration.Allocator;
import registrationScheduler.store.Results;
import registrationScheduler.store.StdoutDisplayInterface;
import registrationScheduler.threadMgmt.CreateWorkers;
import registrationScheduler.util.FileProcessor;
import registrationScheduler.util.Logger;

public class Driver{

	public static void main(String args[]) {
		int numOfThreads = -1;
		int debugValue = -1;
		String inputFileName = null;
		String outputFileName = null;
		try {
			/*validate Command Line Args*/
			validateCommandLineArgs(args);
			debugValue = Integer.valueOf(args[3]);
			Logger.setDebugValue(debugValue);
			inputFileName = args[0];
			outputFileName = args[1];
			numOfThreads = Integer.valueOf(args[2]);
			// Create instance of Results , Allocator and file process
			FileProcessor fpObj = new FileProcessor(new Scanner(new File(inputFileName)));
			StdoutDisplayInterface resultsStdOut = new Results();
			Allocator allocator = new Allocator();			
			CreateWorkers createWorkersObj = new CreateWorkers(resultsStdOut,fpObj,allocator);			
			createWorkersObj.startWorkers(numOfThreads);
			//print Result
			resultsStdOut.writeSchedulesToScreen();
			((Results)resultsStdOut).writeSchedulesToFile(outputFileName);
			Logger.writeMessage(resultsStdOut.toString(),Logger.DebugLevel.STORE_DATA_STRUCTURE);
		} 
		catch (Exception e) {
			System.err.println(" Exception Occured - \n");
			e.printStackTrace();
			System.exit(0);
		}
		finally {
			
		}
	} 

	private static void validateCommandLineArgs(String[] args) {
		if(args.length != 4){
			//Validate that the correct number of command line argumets have been passed.
			System.err.println("Running the code: java Driver <input File Name> <Output file Name> <num_threads> <debug_value>");
			System.exit(0);
		}
		else if(Integer.valueOf(args[2]) < 1 || Integer.valueOf(args[2]) > 3){			
			//Validate that the value of NUM_THREADS is between 1 and 3.
			System.err.println("Running the code: Num of Threads should be between 1 and 3 ");
			System.exit(0);
		}
		else if(Integer.valueOf(args[3]) < 0 || Integer.valueOf(args[3]) > 4){
			//Validate that the DEBUG_VALUE is between 0 and 4.			
			System.err.println("Running the code: Debug_value should be between 0 and 4 ");
			System.exit(0);
		}
		
	}

}

