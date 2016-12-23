package genericDeser.util;

/**
 * Class Second
 * 
 * @author PRASHANT
 *
 */
public class Second {

	/**
	 * Private Data Members
	 */
	private double DoubleValue;
	private int IntValue;
	private boolean BooleanValue;

	/**
	 * setDoubleValue
	 * 
	 * @param doubleValueIn
	 */
	public void setDoubleValue(double doubleValueIn) {
		DoubleValue = doubleValueIn;
	}

	/**
	 * Constructor
	 */
	public Second() {
		Logger.writeMessage("First constructor", Logger.DebugLevel.CONSTRUCTOR);
	}

	/**
	 * setIntValue
	 * 
	 * @param intValueIn
	 */
	public void setIntValue(int intValueIn) {
		IntValue = intValueIn;
	}

	/**
	 * setBooleanValue
	 * 
	 * @param booleanValueIn
	 */
	public void setBooleanValue(boolean booleanValueIn) {
		BooleanValue = booleanValueIn;
	}

	/**
	 * Overridden Equals method
	 */
	@Override
	public boolean equals(Object secondIn) {
		Second second = (Second) secondIn;
		if (this.BooleanValue == second.BooleanValue && this.IntValue == second.IntValue
				&& this.DoubleValue == second.DoubleValue)
			return true;
		else
			return false;
	}

	/**
	 * Overridden hashCode method
	 */
	@Override
	public int hashCode() {
		int totalHash = Integer.toString(IntValue).hashCode() + Double.toString(DoubleValue).hashCode()
				+ Boolean.toString(BooleanValue).hashCode();
		return totalHash;
	}

}
