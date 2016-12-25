package studentOrientation.library.tasks.interfaces;

import studentOrientation.library.measurement.interfaces.CarbonFootprintI;
import studentOrientation.library.measurement.interfaces.CostI;
import studentOrientation.library.measurement.interfaces.DurationI;
import studentOrientation.library.measurement.interfaces.EffortI;

/**
 * Interface for DormSelection Activity
 * @author rishimalani <rmalani1@binghamton.edu>
 *
 */
public interface DormSelectionI {
	
	/**
	 * Function to select dorm
	 * @param cost
	 * @param duration
	 * @param carbonFootprint
	 * @param effort
	 */
	public void doDormSelectionActivity(CostI cost, DurationI duration, CarbonFootprintI carbonFootprint, EffortI effort);
	
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
