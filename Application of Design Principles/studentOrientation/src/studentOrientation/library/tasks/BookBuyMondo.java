package studentOrientation.library.tasks;

import studentOrientation.library.measurement.interfaces.CarbonFootprintI;
import studentOrientation.library.measurement.interfaces.CostI;
import studentOrientation.library.measurement.interfaces.DurationI;
import studentOrientation.library.measurement.interfaces.EffortI;
import studentOrientation.library.tasks.interfaces.BookBuyI;
import studentOrientation.library.utils.Logger;


public class BookBuyMondo implements BookBuyI {

	private CostI cost;
	private DurationI duration;
	private EffortI effort;
	private CarbonFootprintI carbonFootprint;
	
	
	
	/**
	 * @return the cost
	 */
	public CostI getCost() {
		return cost;
	}

	/**
	 * @param cost the cost to set
	 */
	public void setCost(CostI cost) {
		this.cost = cost;
	}

	/**
	 * @return the duration
	 */
	public DurationI getDuration() {
		return duration;
	}

	/**
	 * @param duration the duration to set
	 */
	public void setDuration(DurationI duration) {
		this.duration = duration;
	}

	/**
	 * @return the effort
	 */
	public EffortI getEffort() {
		return effort;
	}

	/**
	 * @param effort the effort to set
	 */
	public void setEffort(EffortI effort) {
		this.effort = effort;
	}

	/**
	 * @return the carbonFootprint
	 */
	public CarbonFootprintI getCarbonFootprint() {
		return carbonFootprint;
	}

	/**
	 * @param carbonFootprint the carbonFootprint to set
	 */
	public void setCarbonFootprint(CarbonFootprintI carbonFootprint) {
		this.carbonFootprint = carbonFootprint;
	}

	/**
	 * Constructor
	 * 
	 */
	public BookBuyMondo() {
		Logger.writeMessage("\nCONSTRUCTOR CALLED: "
				+ this.getClass().toString(), Logger.DebugLevel.CONSTRUCTOR);
	}
	
	/**
	 * Function to buy book
	 * @param cost
	 * @param duration
	 * @param carbonFootprint
	 * @param effort
	 */
	@Override
	public void doBookBuyActivity(CostI cost, DurationI duration,
			CarbonFootprintI carbonFootprint, EffortI effort) {
		Logger.writeMessage("\nACTIVITY DONE: " + this.getClass().toString(), Logger.DebugLevel.ACTIVITYDONE);
		this.setCost(cost);
		this.setCarbonFootprint(carbonFootprint);
		this.setDuration(duration);
		this.setEffort(effort);
	}

	
	
	
}
