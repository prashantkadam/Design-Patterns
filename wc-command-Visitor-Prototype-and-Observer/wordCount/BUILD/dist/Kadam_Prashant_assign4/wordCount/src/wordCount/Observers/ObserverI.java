package wordCount.Observers;

import wordCount.dsForStrings.Node;

/**
 * Interface - Observer
 * 
 * @author PRASHANT
 *
 */
public interface ObserverI {
	/**
	 * Method - update
	 * @param node
	 */
	public void update(Node node);
}
