package wordCount.visitors;

import java.util.ArrayList;

import wordCount.dsForStrings.BinarySearchTree;
import wordCount.dsForStrings.Node;
import wordCount.util.Logger;

/**
 * Class - CloneAndObserverVisitor This visitor class clones data structure
 * 
 * @author PRASHANT
 *
 */
public class CloneAndObserverVisitor implements VisitorI {
	/**
	 * private backup list
	 * 
	 */
	private ArrayList<BinarySearchTree> backup;

	/**
	 * Constructor - CloneAndObserverVisitor
	 */
	public CloneAndObserverVisitor() {
		Logger.writeMessage("CloneAndObserverVisitor constructor", Logger.DebugLevel.CONSTRUCTOR);
		backup = new ArrayList<BinarySearchTree>();
	}

	/**
	 * Overridden visit method from Visitor interface
	 */
	@Override
	public void visit(BinarySearchTree binaryTreeForFile) {
		Logger.writeMessage("CloneAndObserverVisitor visit", Logger.DebugLevel.Visit);
		getBackup().add(new BinarySearchTree((Node) binaryTreeForFile.getRoot().clone()));
	}

	/**
	 * Method - getter getBackup for backups
	 * @return
	 */
	public ArrayList<BinarySearchTree> getBackup() {
		return backup;
	}
}
