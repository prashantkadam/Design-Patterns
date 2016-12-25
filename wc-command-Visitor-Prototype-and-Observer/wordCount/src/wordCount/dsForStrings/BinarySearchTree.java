package wordCount.dsForStrings;
import wordCount.util.FileProcessor;
import wordCount.util.Logger;
import wordCount.visitors.VisitorI;

/**
 * Class - BinarySearchTree
 * @author PRASHANT
 *
 */
public class BinarySearchTree {
	
	private Node root;
	/**
	 * Default Constructor
	 */
	public BinarySearchTree() {
		Logger.writeMessage("BinarySearchTree constructor", Logger.DebugLevel.CONSTRUCTOR);
		root = null;
	}

	/**
	 * Parameterized constructor
	 * @param rootIn
	 */
	public BinarySearchTree(Node rootIn) {
		root = rootIn;
	}
	
	/**
	 * getter for root node
	 * @return
	 */
	public Node getRoot() {
		return root;
	}

	/**
	 * setter for root node
	 * @param rootIn
	 */
	public void setRoot(Node rootIn) {
		root = rootIn;
	}

	/**
	 * Method - accept 
	 * @param visitor
	 */
	public void accept(VisitorI visitor) {
		visitor.visit(this);
	}

	/**
	 * Method - writetofile
	 * This method writes Inorder traversal to File
	 * @param fpObj
	 */
	public void inorderTraversal(FileProcessor fpObj){
			inorder(this.getRoot(),fpObj);
			fpObj.closeBufferWriter();
	}
	
	/**
	 * Method - inorderToFile
	 * This method writes Inorder traversal to File
	 * @param root
	 * @param fpObj
	 */
	public void inorder(Node root,FileProcessor fpObj) {
		if (root == null)
			return;
		inorder(root.getLeft(),fpObj);
		fpObj.writeToFile(root.getWord() + " " + root.getCount()+"\n");
		inorder(root.getRight(),fpObj);
	}

	/**
	 * Method - insert In BST
	 * 
	 * @param binaryTreeForFile
	 * @param s
	 */
	public Node insert(Node root, String input) {
		if(root == null){
			return new Node(input);
		}
		int compare = input.compareTo(root.getWord());
		if (compare == 0) {
			root.setCount(root.getCount() + 1);
		} else if (compare < 0) {
				root.setLeft(insert(root.getLeft(),input));
		} else {
				root.setRight(insert(root.getRight(), input));
		}
		return root;
	}
}
