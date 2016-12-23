package studentOrientation.library.measurement;

import studentOrientation.library.measurement.interfaces.CostI;
import studentOrientation.library.utils.Logger;

/**
 * Concrete class for Cost Measurement
 * @author rishimalani <rmalani1@binghamton.edu>
 *
 */
public class Cost implements CostI {

	/**
	 * value for cost
	 */
	private float cost;
	
	/**
	 * Constructor
	 * @param costIn
	 */
	public Cost(float costIn) {
		Logger.writeMessage("\nCONSTRUCTOR CALLED: " + this.getClass().toString(), Logger.DebugLevel.CONSTRUCTOR);
		cost = costIn;
	}

	/**
	 * Method to get the cost value
	 * @return value for cost
	 */
	@Override
	public float getCost() {
		return cost;
	}

	

}
