package wordCount.visitors;

import wordCount.dsForStrings.BinarySearchTree;
import wordCount.util.FileProcessor;
import wordCount.util.Logger;

/**
 * Class - PopulateVisitor This visitor populates data structure
 * 
 * @author PRASHANT
 *
 */
public class PopulateVisitor implements VisitorI {
	/**
	 * private variable file Processor
	 */
	private FileProcessor fpObj;

	/**
	 * constructor PopulateVisitor
	 * 
	 * @param fpObjIn
	 */
	public PopulateVisitor(FileProcessor fpObjIn) {
		Logger.writeMessage("PopulateVisitor constructor", Logger.DebugLevel.CONSTRUCTOR);
		fpObj = fpObjIn;
	}

	/**
	 * Overridden visit method from Visitor Interface
	 */
	@Override
	public void visit(BinarySearchTree binaryTreeForFile) {
		Logger.writeMessage("PopulateVisitor visit", Logger.DebugLevel.Visit);
		populateDataStructure(binaryTreeForFile);
	}

	/**
	 * Method - populateDataStructure This methods calls insert method for
	 * Binary Search tree
	 * 
	 * @param binaryTreeForFile
	 */
	private void populateDataStructure(BinarySearchTree binaryTreeForFile) {
		String inputLine = fpObj.readLine();
		String[] allWords;
		while (inputLine != null) {
			allWords = inputLine.split("\\s+");
			for (String string : allWords) {
				if (string.length() > 0) {
					insert(binaryTreeForFile, string);
				}
			}
			inputLine = null;
			allWords = null;
			inputLine = fpObj.readLine();
		}
		// close buffer reader
		fpObj.closeBufferReader();
	}

	public void insert(BinarySearchTree binaryTreeForFile, String input){
		binaryTreeForFile.setRoot(binaryTreeForFile.insert(binaryTreeForFile.getRoot(),input));
	}
	
	

	
}
