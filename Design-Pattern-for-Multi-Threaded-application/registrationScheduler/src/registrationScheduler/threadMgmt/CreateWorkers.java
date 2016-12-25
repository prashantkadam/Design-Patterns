package registrationScheduler.threadMgmt;
import java.util.ArrayList;
import java.util.List;

import registrationScheduler.registration.Allocator;
import registrationScheduler.store.Results;
import registrationScheduler.store.StdoutDisplayInterface;
import registrationScheduler.util.FileProcessor;
import registrationScheduler.util.Logger;

/**
 * 
 * @author PRASHANT
 * class CreateWorkers 
 * This class is responsible for creating worker based off passed number of threads
 */
public class CreateWorkers  {
	
	private Results results = null;
	private FileProcessor fileProcessor = null;
	private Allocator allocator = null;
	
	/**
	 * CreateWorkers constructor taking following parameter
	 * @param resultsStdoutDisplayIn => Results Class
	 * @param fileProcessorIn => FileProcessor Class
	 * @param allocatorIn => Allocator Class
	 */
	public CreateWorkers(StdoutDisplayInterface resultsStdoutDisplayIn, FileProcessor fileProcessorIn, Allocator allocatorIn) {
		Logger.writeMessage("--------------------------- In CreateWorkers Constructor ---------------------------\n"
							+ "	resultsIn (i.e. StdoutDisplayInterface) , fileProcessorIn, allocatorIn assigned\n"
							+ "----------------------------------------------------------------------------------"
				, Logger.DebugLevel.CONSTRUCTOR);
		results = (Results)resultsStdoutDisplayIn;
		fileProcessor = fileProcessorIn;
		allocator = allocatorIn;
		
		
	}
		
	/**
	 * startWorkers method
	 * @param numThreads - Number of threads
	 */
	public void startWorkers(int numThreads) {
		WorkerThread worker = new WorkerThread(results,fileProcessor,allocator);
		List<Thread> threadsCollection = new ArrayList<Thread>();
		
		for (int i = 0; i < numThreads; i++) {
			threadsCollection.add( new Thread(worker));			
		}
		/**
		 *  Start all threads
		 */
		for (Thread thread : threadsCollection) {
			try {
				thread.start();
			} catch (Exception e) {
				System.err.println(" Exception Occured - \n");
				e.printStackTrace();
				System.exit(0);
			}
		}
		/**
		 * join on all threads
		 */
		for (Thread thread : threadsCollection) {
			try {
				thread.join();
			} catch (InterruptedException e) {
				System.err.println(" Exception Occured - \n");
				e.printStackTrace();
				System.exit(0);
			}
		}
		
	}
    

}