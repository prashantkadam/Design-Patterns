package studentOrientation.driver;
import studentOrientation.library.enums.BookBuyEnum;
import studentOrientation.library.enums.CampusTourEnum;
import studentOrientation.library.enums.CourseRegistrationEnum;
import studentOrientation.library.enums.DormSelectionEnum;
import studentOrientation.library.utils.Logger;
import studentOrientation.library.utils.Logger.DebugLevel;
import studentOrientation.library.utils.StudentSchedule;
import studentOrientation.library.utils.StudentOrientation;
import studentOrientation.library.utils.workshop.StudentOrientationWorkshop;


/**
 * Driver class used by students for schedule generation
 * @author rishimalani <rmalani1@binghamton.edu>
 *
 */
public class Driver {

	/**
	 * Main method for entry point in application.
	 * @param args	no arguments
	 */
	public static void main(String[] args) {
		try {
			Logger.setDebugValue(DebugLevel.RESULTPRINT);
			StudentOrientation student = new StudentSchedule(BookBuyEnum.UniverstiyStore, CampusTourEnum.BusRide, DormSelectionEnum.OnlineGaming, CourseRegistrationEnum.ComputerSystem);
			StudentOrientationWorkshop shop = new StudentOrientationWorkshop();
			shop.construct(student);
			System.out.println(student);
		} catch (Exception e) {
			System.err.println("Exception Occurred - \n");
			e.printStackTrace();
			System.exit(0);
		} finally {
			
		}
	}
	
}
