package studentOrientation.library.measurement;

import studentOrientation.library.measurement.interfaces.CarbonFootprintI;
import studentOrientation.library.utils.Logger;

/**
 * Concrete class for CarbonFootprint Measurement
 * @author rishimalani <rmalani1@binghamton.edu>
 *
 */
public class CarbonFootprint implements CarbonFootprintI {

	/**
	 * value for carbonfootprint
	 */
	private float carbonFootprint;
	
	/**
	 * Constructor
	 * @param carbonFootprintIn
	 */
	public CarbonFootprint(float carbonFootprintIn) {
		Logger.writeMessage("\nCONSTRUCTOR CALLED: " + this.getClass().toString(), Logger.DebugLevel.CONSTRUCTOR);
		carbonFootprint = carbonFootprintIn;
	}
	
	/**
	 * Method to get the value for carbon foot print
	 * @return value for carbon footprint
	 */
	@Override
	public float getCarbonFootprint() {
		return carbonFootprint;
	}
	
}
