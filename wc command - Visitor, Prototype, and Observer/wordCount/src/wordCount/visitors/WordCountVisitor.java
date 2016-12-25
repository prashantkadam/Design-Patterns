package wordCount.visitors;

import wordCount.dsForStrings.BinarySearchTree;
import wordCount.dsForStrings.Node;
import wordCount.util.FileProcessor;
import wordCount.util.Logger;
import wordCount.util.wordCountStats;

/**
 * Class - WordCountVisitor This Visitor gives required word count
 * 
 * @author PRASHANT
 *
 */
public class WordCountVisitor implements VisitorI {
	/**
	 * private variable for File Processor
	 */
	private FileProcessor fpObj = null;

	/**
	 * Constructor WordCountVisitor
	 * 
	 * @param fpObjIn
	 */
	public WordCountVisitor(FileProcessor fpObjIn) {
		Logger.writeMessage("WordCountVisitor constructor", Logger.DebugLevel.CONSTRUCTOR);
		fpObj = fpObjIn;
	}

	/**
	 * Overridden Visit Method from Visitor Class
	 */
	@Override
	public void visit(BinarySearchTree binaryTreeForFile) {
		Logger.writeMessage("WordCountVisitor visit", Logger.DebugLevel.Visit);
		Node rootNode = binaryTreeForFile.getRoot();
		wordCountStats stats = new wordCountStats();
		countWork(rootNode, stats);
		fpObj.writeToFile(stats.toString());
		fpObj.closeBufferWriter();
	}

	/**
	 * Method - countWork This method recursively generates required count
	 * 
	 * @param rootIn
	 * @param allCount
	 */
	private void countWork(Node rootIn, wordCountStats allCount) {
		if (rootIn == null)
			return;
		allCount.countStats(rootIn.getWord(), rootIn.getCount());
		countWork(rootIn.getLeft(), allCount);
		countWork(rootIn.getRight(), allCount);
	}

}
