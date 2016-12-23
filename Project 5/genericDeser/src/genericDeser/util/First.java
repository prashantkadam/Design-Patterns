package genericDeser.util;

/**
 * Class First
 * 
 * @author PRASHANT
 *
 */
public class First {

	/**
	 * Private Data Members
	 */
	private int IntValue;
	private float FloatValue;
	private short ShortValue;
	private String StringValue;

	/**
	 * Constructor
	 */
	public First() {
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
	 * setFloatValue
	 * 
	 * @param floatValueIn
	 */
	public void setFloatValue(float floatValueIn) {
		FloatValue = floatValueIn;
	}

	/**
	 * setShortValue Method
	 * 
	 * @param shortValueIn
	 */
	public void setShortValue(short shortValueIn) {
		ShortValue = shortValueIn;
	}

	/**
	 * setStringValue Method
	 * 
	 * @param stringValueIn
	 */
	public void setStringValue(String stringValueIn) {
		StringValue = stringValueIn;
	}

	/**
	 * Overridden Equals
	 */
	@Override
	public boolean equals(Object first) {
		First firstIn = (First) first;
		boolean stringflag = false;
		if (this.StringValue == null && firstIn.StringValue == null)
			stringflag = true;

		if (this.FloatValue == firstIn.FloatValue && this.IntValue == firstIn.IntValue
				&& this.ShortValue == firstIn.ShortValue
				&& (stringflag || this.StringValue.equals(firstIn.StringValue)))
			return true;
		else
			return false;
	}

	/**
	 * Overridden HashCode
	 */
	@Override
	public int hashCode() {
		int totalHash;
		if (StringValue == null) {
			totalHash = 0 + Integer.toString(IntValue).hashCode() + Short.toString(ShortValue).hashCode()
					+ Float.toString(FloatValue).hashCode();
		} else {
			totalHash = StringValue.hashCode() + Integer.toString(IntValue).hashCode()
					+ Short.toString(ShortValue).hashCode() + Float.toString(FloatValue).hashCode();
		}
		return totalHash;
	}

}
