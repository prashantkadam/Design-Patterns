package wordCount.visitors;

import wordCount.dsForStrings.BinarySearchTree;
/**
 * Interface - Visitor
 * @author PRASHANT
 *
 */
public interface VisitorI {
	/**
	 * Method - Visit
	 * @param binaryTreeForFile
	 */
	public void visit(BinarySearchTree binaryTreeForFile);
}
