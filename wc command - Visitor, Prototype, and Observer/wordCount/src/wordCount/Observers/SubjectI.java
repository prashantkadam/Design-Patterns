package wordCount.Observers;

/**
 * Interface - Subject
 * @author PRASHANT
 *
 */
public interface SubjectI {
	/**
	 * Method - registerObserver
	 * @param obeserver
	 */
	public void registerObserver(ObserverI obeserver);
	/**
	 * Method - removeObserver
	 * @param obeserver
	 */
	public void removeObserver(ObserverI obeserver);
	/**
	 * Method - notifyObserver
	 */
	public void notifyObserver();
}
