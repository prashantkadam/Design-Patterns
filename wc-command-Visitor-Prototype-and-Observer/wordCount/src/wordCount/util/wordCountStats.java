package wordCount.util;

/**
 * class - wordCountStats this class keeps statistics for word count visitor
 * 
 * @author PRASHANT
 *
 */
public class wordCountStats {
	private int numberOfwords;
	private int numberOfDistinctwords;
	private int numberOfCharacters;

	/**
	 * Constructor - countStats
	 * 
	 * @param word
	 * @param count
	 */
	public void countStats(String word, int count) {
		this.numberOfwords += count;
		this.numberOfDistinctwords += 1;
		this.numberOfCharacters += word.length() * count;
	}

	/**
	 * Overridden toString Method
	 */
	@Override
	public String toString() {
		return "\nNumber of words: " + this.numberOfwords + "\nNumber of Distinct words: " + this.numberOfDistinctwords
				+ "\nNumber of characters: " + this.numberOfCharacters;
	}

}
