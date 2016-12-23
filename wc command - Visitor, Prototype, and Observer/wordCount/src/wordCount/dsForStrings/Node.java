package wordCount.dsForStrings;

import java.util.ArrayList;
import wordCount.Observers.ObserverI;
import wordCount.Observers.SubjectI;
import wordCount.util.Logger;

/**
 * Class - Node
 * 
 * @author PRASHANT
 *
 */
public class Node implements SubjectI, ObserverI, Cloneable {

	/**
	 * Private variable word
	 */
	private String word;
	/**
	 * Private variable left
	 */
	private Node left;
	/**
	 * Private variable right
	 */
	private Node right;
	/**
	 * Private variable count
	 */
	private int count;
	/**
	 * Private variable ListOfObservers
	 */
	private ArrayList<ObserverI> ListOfObservers;

	/**
	 * Method - getWord
	 * 
	 * @return
	 */
	public String getWord() {
		return word;
	}

	/**
	 * Method - setter setWord
	 * 
	 * @param word
	 */
	public void setWord(String word) {
		this.word = word;
	}

	/**
	 * Method - getter getLeft
	 * 
	 * @return Node
	 */
	public Node getLeft() {
		return left;
	}

	/**
	 * Method - setter setLeft
	 * 
	 * @param left
	 */
	public void setLeft(Node left) {
		this.left = left;
	}

	/**
	 * Method - getter getRight
	 * 
	 * @return Node
	 */
	public Node getRight() {
		return right;
	}

	/**
	 * Method - setter setRight
	 * 
	 * @param right
	 */
	public void setRight(Node right) {
		this.right = right;
	}

	/**
	 * Method - getter getListOfObservers
	 * 
	 * @return ArrayList<ObserverI>
	 */
	public ArrayList<ObserverI> getListOfObservers() {
		return ListOfObservers;
	}

	/**
	 * Method - setter setListOfObservers
	 * 
	 * @param listOfObservers
	 */
	public void setListOfObservers(ArrayList<ObserverI> listOfObservers) {
		ListOfObservers = listOfObservers;
	}

	/**
	 * Method - getter getCount
	 * 
	 * @return
	 */
	public int getCount() {
		return count;
	}
	/**
	 * Method - setter setCount
	 * @param c
	 */
	public void setCount(int c) {
		this.count = c;
		//this.notifyObserver();
	}


	/*
	 * Overridden Method - clone This method clones node
	 */
	@Override
	public Object clone() {
		Node left = null;
		Node right = null;
		if (this.left != null) {
			left = (Node) this.left.clone();
		}
		if (this.right != null) {
			right = (Node) this.right.clone();
		}
		Node node = new Node(this.word, this.count, left, right);
		this.registerObserver(node);
		return node;
	}

	/*
	 * Overriden Method - toString This method prints string format for Node
	 */
	@Override
	public String toString() {
		return this.word + " " + this.count + "\n";
	}

	/**
	 * Constructor Node
	 * 
	 * @param wordIn
	 */
	public Node(String wordIn) {
		Logger.writeMessage("Node constructor", Logger.DebugLevel.CONSTRUCTOR);
		word = wordIn;
		left = null;
		right = null;
		count = 1;
		ListOfObservers = new ArrayList<ObserverI>();
	}

	/**
	 * Constructor Node
	 * 
	 * @param wordIn
	 * @param countIn
	 * @param leftIn
	 * @param rightIn
	 */
	public Node(String wordIn, int countIn, Node leftIn, Node rightIn) {
		Logger.writeMessage("Node constructor", Logger.DebugLevel.CONSTRUCTOR);
		word = wordIn;
		left = leftIn;
		count = countIn;
		right = rightIn;
	}

	/**
	 * Method - update overridden from observer Interface
	 */
	@Override
	public void update(Node node) {
		this.count = node.count;
	}

	/**
	 * Method - registerObserver overridden from Subject Interface
	 */
	@Override
	public void registerObserver(ObserverI obeserver) {

		this.ListOfObservers.add(obeserver);
	}

	/**
	 * Method - removeObserver overridden from Subject Interface
	 */
	@Override
	public void removeObserver(ObserverI obeserver) {
		this.ListOfObservers.remove(obeserver);
	}

	/**
	 * Method - notifyObserver overridden from Subject Interface
	 */
	@Override
	public void notifyObserver() {
		Logger.writeMessage("notifyObserver called", Logger.DebugLevel.NotifyObserver);
		for (ObserverI observer : ListOfObservers) {
			observer.update((Node) this);
		}
	}

	
}
