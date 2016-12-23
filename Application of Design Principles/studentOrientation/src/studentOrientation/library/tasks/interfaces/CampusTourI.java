package studentOrientation.library.tasks.interfaces;

import studentOrientation.library.measurement.interfaces.CarbonFootprintI;
import studentOrientation.library.measurement.interfaces.CostI;
import studentOrientation.library.measurement.interfaces.DurationI;
import studentOrientation.library.measurement.interfaces.EffortI;

/**
 * Interface for CampusTour Activity
 * @author rishimalani <rmalani1@binghamton.edu>
 *
 */
public interface CampusTourI {
	
	/**
	 * Function to tour campus
	 * @param cost
	 * @param duration
	 * @param carbonFootprint
	 * @param effort
	 */
	public void doCampusTourActivity(CostI cost, DurationI duration, CarbonFootprintI carbonFootprint, EffortI effort);

	/**
	 * Function to get the cost
	 * @return cost
	 */
	public CostI getCost();
	
	/**
	 * Function to get duration
	 * @return duration
	 */
	public DurationI getDuration();
	
	/**
	 * Function to get the effort
	 * @return effort
	 */
	public EffortI getEffort();
	
	/**
	 * Function to get the carbon foot print
	 * @return carbon foot print
	 */
	public CarbonFootprintI getCarbonFootprint();
	
}
