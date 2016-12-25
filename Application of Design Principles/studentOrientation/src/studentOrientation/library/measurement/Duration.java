package studentOrientation.library.measurement;

import studentOrientation.library.measurement.interfaces.DurationI;
import studentOrientation.library.utils.Logger;

/**
 * Concrete class for Duration Measurement
 * @author rishimalani <rmalani1@binghamton.edu>
 *
 */
public class Duration implements DurationI{

	/**
	 * value for duration
	 */
	private float duration;
	
	/**
	 * Constructor
	 * @param durationIn
	 */
	public Duration(float durationIn) {
		Logger.writeMessage("\nCONSTRUCTOR CALLED: " + this.getClass().toString(), Logger.DebugLevel.CONSTRUCTOR);
		duration = durationIn;
	}
	
	/**
	 * Method to get the duration value
	 * @return value for duration
	 */
	@Override
	public float getDuration() {
		return duration;
	}

	

}
