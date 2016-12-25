package studentOrientation.library.utils.taskfactory.interfaces;

import studentOrientation.library.enums.BookBuyEnum;
import studentOrientation.library.enums.CampusTourEnum;
import studentOrientation.library.enums.CourseRegistrationEnum;
import studentOrientation.library.enums.DormSelectionEnum;
import studentOrientation.library.tasks.interfaces.BookBuyI;
import studentOrientation.library.tasks.interfaces.CampusTourI;
import studentOrientation.library.tasks.interfaces.CourseRegistrationI;
import studentOrientation.library.tasks.interfaces.DormSelectionI;

/**
 * Abstract Factory Interface for all activities
 * @author rishimalani <rmalani1@binghamton.edu>
 *
 */
public interface TaskFactoryI {
	/**
	 * Function to create BookBuy Object
	 * @param book
	 * @return	concrete object for book buy
	 */
	public BookBuyI createBookBuyObject(BookBuyEnum book);
	/**
	 * Function to create campus tour object
	 * @param campusTour
	 * @return	concrete object for campus tour
	 */
	public CampusTourI createCampusTourObject(CampusTourEnum campusTour);
	/**
	 * Function to create course registration object
	 * object
	 * @param courseRegistration
	 * @return	concrete object for course registration
	 */
	public CourseRegistrationI createCourseRegistrationObject(CourseRegistrationEnum courseRegistration);
	/**
	 * Function to create dorm selection object
	 * @param dormSelection
	 * @return	concrete object for dorm selection
	 */
	public DormSelectionI createDormSelectionObject(DormSelectionEnum dormSelection);
}
