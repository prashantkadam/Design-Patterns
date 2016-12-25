package studentOrientation.library.utils;

import studentOrientation.library.enums.BookBuyEnum;
import studentOrientation.library.enums.CampusTourEnum;
import studentOrientation.library.enums.CourseRegistrationEnum;
import studentOrientation.library.enums.DormSelectionEnum;
import studentOrientation.library.enums.Units;
import studentOrientation.library.measurement.CarbonFootprint;
import studentOrientation.library.measurement.Cost;
import studentOrientation.library.measurement.Duration;
import studentOrientation.library.measurement.Effort;
import studentOrientation.library.measurement.interfaces.CarbonFootprintI;
import studentOrientation.library.measurement.interfaces.CostI;
import studentOrientation.library.measurement.interfaces.DurationI;
import studentOrientation.library.measurement.interfaces.EffortI;
import studentOrientation.library.tasks.interfaces.BookBuyI;
import studentOrientation.library.tasks.interfaces.CampusTourI;
import studentOrientation.library.tasks.interfaces.CourseRegistrationI;
import studentOrientation.library.tasks.interfaces.DormSelectionI;
import studentOrientation.library.utils.taskfactory.TaskFactory;
import studentOrientation.library.utils.taskfactory.interfaces.TaskFactoryI;

/**
 * Class Student Schedule
 * @author PRASHANT
 *
 */
public class StudentSchedule extends StudentOrientation {

	private DormSelectionI dormSelection;
	private CampusTourI campusTour;
	private BookBuyI bookBuy;
	private CourseRegistrationI courseRegistration;
	
	private BookBuyEnum bookBuyOption;
	private CampusTourEnum campusTourOption;
	private DormSelectionEnum dormSelectionOption;
	private CourseRegistrationEnum courseRegistrationOption;
	
	private CostI cost;
	private DurationI duration;
	private CarbonFootprintI carbonFootprint;
	private EffortI effort;
	private BaseMeasurements baseMeasurements;
	private TaskFactoryI taskFactory;
	
	private Units costUnit;
	private Units durationUnit;
	private Units carbonFootprintUnit;
	private Units effortUnit;
	
	/**
	 * Constructor
	 * @param bookBuyOptionIn
	 * @param campusTourOptionIn
	 * @param dormSelectionEnumIn
	 * @param courseRegistrationOptionIn
	 */
	public StudentSchedule(BookBuyEnum bookBuyOptionIn, CampusTourEnum campusTourOptionIn, DormSelectionEnum dormSelectionEnumIn, CourseRegistrationEnum courseRegistrationOptionIn) {
		Logger.writeMessage("\nCONSTRUCTOR CALLED: "
				+ this.getClass().toString(), Logger.DebugLevel.CONSTRUCTOR);
		taskFactory = new TaskFactory();
		bookBuyOption = bookBuyOptionIn;
		courseRegistrationOption = courseRegistrationOptionIn;
		dormSelectionOption = dormSelectionEnumIn;
		campusTourOption = campusTourOptionIn;
		baseMeasurements = new BaseMeasurements();
		costUnit = Units.DOLLARS;
		durationUnit = Units.MINUTES;
		carbonFootprintUnit = Units.TONNESOFCO2;
		effortUnit = Units.CALORIES;
	}
	/**
	 * buildCampusTourActivity() 
	 * This method will build Campus tour activity	
	 *  
	 */
	@Override
	public void buildCampusTourActivity() {
		switch(campusTourOption) {
		case OnFoot:
			cost = new Cost(baseMeasurements.getCampusTourOnFootCost());
			duration = new Duration(baseMeasurements.getCampusTourOnFootDuration());
			carbonFootprint = new CarbonFootprint(baseMeasurements.getCampusTourOnFootCarbonFootprint());
			effort = new Effort(baseMeasurements.getCampusTourOnFootEfforts());
			break;
		case BusRide:
			cost = new Cost(baseMeasurements.getCampusTourBusRideCost());
			duration = new Duration(baseMeasurements.getCampusTourBusRideDuration());
			carbonFootprint = new CarbonFootprint(baseMeasurements.getCampusTourBusRideCarbonFootprint());
			effort = new Effort(baseMeasurements.getCampusTourBusRideEfforts());
		}

		campusTour = taskFactory.createCampusTourObject(campusTourOption);
		campusTour.doCampusTourActivity(cost, duration, carbonFootprint, effort);
	}

	/**
	 * Method - buildBookBuyActivity() 
	 * This method will build Book Buy activity	
	 *  
	 */
	@Override
	public void buildBookBuyActivity() {
		
		switch(bookBuyOption) {
		case MondoStore:
			cost = new Cost(baseMeasurements.getBookBuyCost());
			duration = new Duration(baseMeasurements.getBookBuyMondoDuration());
			carbonFootprint = new CarbonFootprint(baseMeasurements.getBookBuyMondoCarbonFootprint());
			effort = new Effort(baseMeasurements.getBookBuyMondoEfforts());
			break;
		case UniverstiyStore:
			cost = new Cost(baseMeasurements.getBookBuyCost()+0.05f*baseMeasurements.getBookBuyCost()); // 5 percent more
			duration = new Duration(baseMeasurements.getBookBuyUniversityDuration());
			carbonFootprint = new CarbonFootprint(baseMeasurements.getBookBuyUniversityCarbonFootprint());
			effort = new Effort(baseMeasurements.getBookBuyUniversityEfforts());
		}
		bookBuy = taskFactory.createBookBuyObject(bookBuyOption);
		bookBuy.doBookBuyActivity(cost, duration, carbonFootprint, effort);
	}
	
	
	/**
	 * Method - buildCourseRegistrationActivity
	 * This method will build Course Registration activity
	 */
	@Override
	public void buildCourseRegistrationActivity() {
		switch(courseRegistrationOption) {
		case ComputerSystem:
			cost = new Cost(0.97f*baseMeasurements.getCourseRegistrationCost()); // 3 percent cheaper
			duration = new Duration(baseMeasurements.getCourseRegistrationComputerDuration());
			carbonFootprint = new CarbonFootprint(baseMeasurements.getCourseRegistrationComputerCarbonFootprint());
			effort = new Effort(baseMeasurements.getCourseRegistrationComputerEfforts());
			break;
		case RegistrarOffice:
			cost = new Cost(baseMeasurements.getCourseRegistrationCost());
			duration = new Duration(baseMeasurements.getCourseRegistrationOfficeDuration());
			carbonFootprint = new CarbonFootprint(baseMeasurements.getCourseRegistrationOfficeCarbonFootprint());
			effort = new Effort(baseMeasurements.getCourseRegistrationOfficeEfforts());
		}
		courseRegistration = taskFactory.createCourseRegistrationObject(courseRegistrationOption);
		courseRegistration.doCourseRegistrationActivity(cost, duration, carbonFootprint, effort);

	}

	/**
	 * Method - buildDormSelectionActivity()
	 * This method will build dorm Selection activity
	 */
	@Override
	public void buildDormSelectionActivity() {
		switch(dormSelectionOption) {
		case AdministratorOffice:
			cost = new Cost(baseMeasurements.getDormSelectionCost());
			duration = new Duration(baseMeasurements.getDormSelectionOfficeDuration());
			carbonFootprint = new CarbonFootprint(baseMeasurements.getDormSelectionOfficeCarbonFootprint());
			effort = new Effort(baseMeasurements.getDormSelectionOfficeEfforts());
			break;
		case OnlineGaming:
			cost = new Cost(1.02f*baseMeasurements.getDormSelectionCost()); // 2 percent surcharge
			duration = new Duration(baseMeasurements.getDormSelectionGamingDuration());
			carbonFootprint = new CarbonFootprint(baseMeasurements.getDormSelectionGamingCarbonFootprint());
			effort = new Effort(baseMeasurements.getDormSelectionGamingEfforts());
			break;
		}
		dormSelection = taskFactory.createDormSelectionObject(dormSelectionOption);
		dormSelection.doDormSelectionActivity(cost, duration, carbonFootprint, effort);
	}

	/**
	 * Method toString Override
	 * @return string
	 */
	@Override
	public String toString() {
		//return schedule.toString();
		StringBuilder sb = new StringBuilder();
		sb.append("Complete Schedule for Student ");
		sb.append("\nActivity BookBuy- " + this.bookBuyOption + ": \n");
		sb.append("Cost: " + bookBuy.getCost().getCost() + "\tDuration: " + bookBuy.getDuration().getDuration() + "\tCarbonFootPrint: " + bookBuy.getCarbonFootprint().getCarbonFootprint() + "\tEffort: " + bookBuy.getEffort().getEffort());
		sb.append("\nActivity CampusTour- " + this.campusTourOption + ": \n");
		sb.append("Cost: " + campusTour.getCost().getCost() + "\tDuration: " + campusTour.getDuration().getDuration() + "\tCarbonFootPrint: " + campusTour.getCarbonFootprint().getCarbonFootprint() + "\tEffort: " + campusTour.getEffort().getEffort());
		sb.append("\nActivity DormSelection- " + this.dormSelectionOption + ": \n");
		sb.append("Cost: " + dormSelection.getCost().getCost() + "\tDuration: " + dormSelection.getDuration().getDuration() + "\tCarbonFootPrint: " + dormSelection.getCarbonFootprint().getCarbonFootprint() + "\tEffort: " + dormSelection.getEffort().getEffort());
		sb.append("\nActivity CourseRegistration- " + this.courseRegistrationOption + ": \n");
		sb.append("Cost: " + courseRegistration.getCost().getCost() + "\tDuration: " + courseRegistration.getDuration().getDuration() + "\tCarbonFootPrint: " + courseRegistration.getCarbonFootprint().getCarbonFootprint() + "\tEffort: " + courseRegistration.getEffort().getEffort());
		sb.append(getTotal());
		return sb.toString();
	}
	
	/**
	 * Function to get the total of all activities
	 * @return string with total
	 */
	private String getTotal() {
		StringBuilder sb = new StringBuilder();
		float totalCost = bookBuy.getCost().getCost()+campusTour.getCost().getCost()+dormSelection.getCost().getCost()+courseRegistration.getCost().getCost();
		sb.append("\nTotal Cost: " + totalCost + " " + costUnit.toString());
		float totalDuration = bookBuy.getDuration().getDuration()+campusTour.getDuration().getDuration()+dormSelection.getDuration().getDuration()+courseRegistration.getDuration().getDuration();
		sb.append("\nTotal Duration: " + totalDuration+ " " + durationUnit.toString());
		float totalCarbonFootprint = bookBuy.getCarbonFootprint().getCarbonFootprint()+campusTour.getCarbonFootprint().getCarbonFootprint()+dormSelection.getCarbonFootprint().getCarbonFootprint()+courseRegistration.getCarbonFootprint().getCarbonFootprint();
		sb.append("\nTotal Carbon Foot Print: " + totalCarbonFootprint + " " + carbonFootprintUnit.toString());
		float totalEffort = bookBuy.getEffort().getEffort()+campusTour.getEffort().getEffort()+dormSelection.getEffort().getEffort()+courseRegistration.getEffort().getEffort();
		sb.append("\nTotal Effort: " + totalEffort + " " + effortUnit.toString());
		return sb.toString();
	}
	
	
}
