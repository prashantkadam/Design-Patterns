package wordCount.visitors;

import wordCount.dsForStrings.BinarySearchTree;
import wordCount.dsForStrings.Node;
import wordCount.util.Logger;
/**
 * Class - updateVisitor
 * This Class updates original tree
 * @author PRASHANT
 *
 */
public class UpdateVisitor implements VisitorI {
/***
 * private internal count variable
 */
	private int InternalCount = 0;
	/**
	 * Method - visit overridden from Visitor Interface
	 */
	@Override
	public void visit(BinarySearchTree binaryTreeForFile) {
		Logger.writeMessage("updateVisitor visit", Logger.DebugLevel.Visit);
		Node rootNode = binaryTreeForFile.getRoot();
		updateCountForAllNodes(rootNode);
	}
	/**
	 * Method - update Count For All Nodes
	 * @param rootNode
	 */
	private void updateCountForAllNodes(Node rootNode){
		if(rootNode == null)
			return;
		rootNode.setCount(InternalCount++);
		updateCountForAllNodes(rootNode.getLeft());
		updateCountForAllNodes(rootNode.getRight());
	}

}
