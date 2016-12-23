package studentOrientation.library.measurement;

import studentOrientation.library.measurement.interfaces.EffortI;
import studentOrientation.library.utils.Logger;

/**
 * Concrete class for Effort Measurement
 * @author rishimalani <rmalani1@binghamton.edu>
 *
 */
public class Effort implements EffortI {

	/**
	 * value for effort
	 */
	private float effort;
	
	/**
	 * Constructor
	 * @param effortIn
	 */
	public Effort(float effortIn) {
		Logger.writeMessage("\nCONSTRUCTOR CALLED: " + this.getClass().toString(), Logger.DebugLevel.CONSTRUCTOR);
		effort = effortIn;
	}

	
	/**
	 * Method to get the effort value
	 * @return value for effort
	 */
	@Override
	public float getEffort() {
		return effort;
	}
}
