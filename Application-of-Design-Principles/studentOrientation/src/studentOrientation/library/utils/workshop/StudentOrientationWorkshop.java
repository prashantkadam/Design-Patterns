package studentOrientation.library.utils.workshop;

import studentOrientation.library.utils.Logger;
import studentOrientation.library.utils.StudentOrientation;
import studentOrientation.library.utils.workshop.interfaces.StudentOrientationWorkshopI;

/**
 * Concrete Workshop Implementation
 * @author rishimalani <rmalani1@binghamton.edu>
 *
 */
public class StudentOrientationWorkshop implements StudentOrientationWorkshopI {

	/**
	 * construct method for student schedule
	 * @param student generates the schedule for
	 * student
	 */
	@Override
	public void construct(StudentOrientation student) {
		Logger.writeMessage("\nCONSTRUCT METHOD CALLED: "
				+ this.getClass().toString(), Logger.DebugLevel.ACTIVITYDONE);
		student.buildBookBuyActivity();
		student.buildCampusTourActivity();
		student.buildCourseRegistrationActivity();
		student.buildDormSelectionActivity();
	}

}
