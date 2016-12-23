package wordCount.driver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import wordCount.dsForStrings.BinarySearchTree;
import wordCount.util.FileProcessor;
import wordCount.util.Logger;
import wordCount.visitors.CloneAndObserverVisitor;
import wordCount.visitors.PopulateVisitor;
import wordCount.visitors.VisitorI;
import wordCount.visitors.WordCountVisitor;

/**
 * Class Driver - Entry point class
 * 
 * @author PRASHANT
 *
 */
public class Driver {
	/**
	 * Main Method
	 * 
	 * @param args
	 *            
	 */
	public static void main(String[] args) {
		Driver driver = new Driver();
		int debugLevel = 0;
		int numberOfIteration = -1;
		String inputFileName = null;
		String outputFileName = null;
		try {
			/* validate Command Line Args */
			driver.validateCommandLineArgs(args,debugLevel);
			Logger.setDebugValue(debugLevel);
			numberOfIteration = Integer.valueOf(args[2]);
			inputFileName = args[0];
			outputFileName = args[1];
			// file Processor Object
			long startTime = System.currentTimeMillis();
			BinarySearchTree treeDataStructure = null;
			for (int i = 0; i < numberOfIteration; i++) {
				// instantiate the data structure and visitors
				treeDataStructure = new BinarySearchTree();
				driver.RunPopuateWordCountVisitor(treeDataStructure, inputFileName, outputFileName);
			}
			long finishTime = System.currentTimeMillis();
			// print total_time
			System.out.println("total_time: " + (finishTime - startTime) / numberOfIteration);
			driver.TestClone(treeDataStructure);
		} catch (Exception e) {
			System.err.println(" Exception Occured Method Main- \n");
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
	private void validateCommandLineArgs(String[] args,int debugLevel) {
		if (args.length != 3) {
			// Validate that the correct number of command line arguments have
			// been passed.
			System.err.println("Running the code: java Driver <input File Name> <Output file Name> "
					+ "<Num of Iteration>");
			System.exit(0);
		} else if (Integer.valueOf(args[2]) < 0) {
			// Validate that the value of <Num of Iteration> should be positive
			System.err.println("Running the code: Num of Iteration should be positive ");
			System.exit(0);
		} else if (debugLevel < 0 || debugLevel > 3) {
			// Validate that the DEBUG_VALUE is between 0 and 4.
			System.err.println("Running the code: Debug_value should be between 0 and 3 ");
			System.exit(0);
		}
	}

	/**
	 * private Method - TestClone
	 * This method test back up functionality
	 * @param treeDataStructure
	 */
	private void TestClone(BinarySearchTree treeDataStructure) {
		VisitorI cloneObserverVisitor = new CloneAndObserverVisitor();
		treeDataStructure.accept(cloneObserverVisitor);
		FileProcessor fpObserverFirstObj;
		try {
			fpObserverFirstObj = new FileProcessor(new BufferedWriter(new FileWriter("first.txt")));
			FileProcessor fpObserverSecondObj = new FileProcessor(new BufferedWriter(new FileWriter("second.txt")));
			treeDataStructure.inorderTraversal(fpObserverFirstObj);
			((CloneAndObserverVisitor) cloneObserverVisitor).getBackup().get(0).inorderTraversal(fpObserverSecondObj);
		} catch (IOException e) {
			System.err.println(" Exception Occured  Method Driver -> TestClone - \n");
			e.printStackTrace();
			System.exit(0);
		}
		finally {
			
		}
	}

	/**
	 * Private Method - RunPopuateWordCountVisitor
	 * This method creates object of populate visitor and word count visitor
	 * and calls respective method
	 * @param treeDataStructure
	 * @param inputFileName
	 * @param outputFileName
	 */
	private void RunPopuateWordCountVisitor(BinarySearchTree treeDataStructure, String inputFileName,
			String outputFileName) {
		try {
			FileProcessor fpPopulateObj = new FileProcessor(new BufferedReader(new FileReader(inputFileName)));
			FileProcessor fpWordCountObj = new FileProcessor(new BufferedWriter(new FileWriter(outputFileName)));
			VisitorI populateVisitor = new PopulateVisitor(fpPopulateObj);
			VisitorI wordCountVisitor = new WordCountVisitor(fpWordCountObj);
			// code to visit with the PopulateVisitor
			treeDataStructure.accept(populateVisitor);
			// code to visit with the WordCountVisitor.
			treeDataStructure.accept(wordCountVisitor);
		} catch (Exception e) {
			System.err.println(" Exception Occured  Method Driver -> Run Populate word Count Visitor - \n");
			e.printStackTrace();
			System.exit(0);
		}
		finally {
			
		}

	}
}
