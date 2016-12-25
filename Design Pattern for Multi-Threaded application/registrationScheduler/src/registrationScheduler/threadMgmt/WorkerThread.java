package registrationScheduler.threadMgmt;
import registrationScheduler.registration.Allocator;
import registrationScheduler.store.Results;
import registrationScheduler.util.FileProcessor;
import registrationScheduler.util.Logger;

/**
 * class WorkerThread which implements Runnable
 * @author PRASHANT
 * 
 */
public class WorkerThread implements Runnable  {
	
	
	/**
	 * Results Object holds all results
	 */
	private Results results = null;
	
	/**
	 * FileProcessor object used to read line from file
	 */
	private FileProcessor fileProcessor = null;
	
	/**
	 * allocator Object to used to do actual assignment 
	 * and run allocation algorithm
	 */
	private Allocator allocator = null;
	
	/**
	 * WorkerThread constructor
	 * @param workerNameIn
	 * @param resultsIn
	 * @param fileProcessorIn
	 * @param allocatorIn
	 */
	public WorkerThread(Results resultsIn, FileProcessor fileProcessorIn, Allocator allocatorIn) {
		Logger.writeMessage("\n--------------------------- In WorkerThread Constructor ---------------------------\n"
				+" resultsIn, fileProcessorIn, allocatorIn assigned\n"
				+ "---------------------------------------------------------------------------------\n"
				, Logger.DebugLevel.CONSTRUCTOR);
		results = resultsIn;
		fileProcessor = fileProcessorIn;
		allocator = allocatorIn;
		
	}
	
	/**
	 * Runnable class's Run() method
	 */
    public void run() {
    	try {
    		Logger.writeMessage("\n ********Start******** WorkerThread Run Method ********Start********", Logger.DebugLevel.THREAD_RUN);
        	String line = fileProcessor.readLine();
        	
        	while(line!= null){
        		results.addToStudentDictionary(line);
        		allocator.processStudent(results);
        		line = fileProcessor.readLine();
        	}
        	
        	while(results.getCountOfAssignments() < 400){    		
        		allocator.processStudent(results);    		
        	}    	
        	Logger.writeMessage("\n ********End******** WorkerThread Run Method ********End********", Logger.DebugLevel.THREAD_RUN);
    		
		} catch (Exception e) {
			System.err.println(" Exception Occured - \n");
			e.printStackTrace();
			System.exit(0);
		}
    	finally {
			fileProcessor.closeScanner();
		}
    }
  
   /**
   * Runnable start() method  
   */
	//public void start() {
					
		//}
}