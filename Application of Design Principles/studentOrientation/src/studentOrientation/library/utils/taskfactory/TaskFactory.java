package studentOrientation.library.utils.taskfactory;

import studentOrientation.library.enums.BookBuyEnum;
import studentOrientation.library.enums.CampusTourEnum;
import studentOrientation.library.enums.CourseRegistrationEnum;
import studentOrientation.library.enums.DormSelectionEnum;
import studentOrientation.library.tasks.BookBuyUniversity;
import studentOrientation.library.tasks.BookBuyMondo;
import studentOrientation.library.tasks.CampusTourBusRide;
import studentOrientation.library.tasks.CampusTourOnFoot;
import studentOrientation.library.tasks.CourseRegistrationComputer;
import studentOrientation.library.tasks.CourseRegistrationOffice;
import studentOrientation.library.tasks.DormSelectionGaming;
import studentOrientation.library.tasks.DormSelectionOffice;
import studentOrientation.library.tasks.interfaces.BookBuyI;
import studentOrientation.library.tasks.interfaces.CampusTourI;
import studentOrientation.library.tasks.interfaces.CourseRegistrationI;
import studentOrientation.library.tasks.interfaces.DormSelectionI;
import studentOrientation.library.utils.taskfactory.interfaces.TaskFactoryI;

/**
 * Abstract factory for Activity
 * @author rishimalani <rmalani1@binghamton.edu>
 *
 */
public class TaskFactory implements TaskFactoryI {

	/**
	 * Function to create BookBuy Object
	 * @param book
	 * @return	concrete object for book buy
	 */
	@Override
	public BookBuyI createBookBuyObject(BookBuyEnum book) {
		BookBuyI bbConcreteObject = null;
		switch (book) {
		case MondoStore:
			bbConcreteObject = new BookBuyMondo();
			break;
		case UniverstiyStore:
			bbConcreteObject = new BookBuyUniversity();
			break;
		default:
			break;
		}
		return bbConcreteObject;
	}

	/**
	 * Function to create campus tour object
	 * @param campusTour
	 * @return	concrete object for campus tour
	 */
	@Override
	public CampusTourI createCampusTourObject(CampusTourEnum campusTour) {
		CampusTourI ctConcreteObject = null;
		switch (campusTour) {
		case OnFoot:
			ctConcreteObject = new CampusTourOnFoot();
			break;
		case BusRide:
			ctConcreteObject = new CampusTourBusRide();
			break;
		default:
			break;
		}
		return ctConcreteObject;
	}

	/**
	 * Function to create course registration object
	 * object
	 * @param courseRegistration
	 * @return	concrete object for course registration
	 */
	@Override
	public CourseRegistrationI createCourseRegistrationObject(
			CourseRegistrationEnum courseRegistration) {
		CourseRegistrationI crConcreteObject = null;
		switch (courseRegistration) {
		case RegistrarOffice:
			crConcreteObject = new CourseRegistrationOffice();
			break;
		case ComputerSystem:
			crConcreteObject = new CourseRegistrationComputer();
			break;
		default:
			break;
		}
		return crConcreteObject;
	}

	/**
	 * Function to create dorm selection object
	 * @param dormSelection
	 * @return	concrete object for dorm selection
	 */
	@Override
	public DormSelectionI createDormSelectionObject(
			DormSelectionEnum dormSelection) {
		DormSelectionI dsConcreteObject = null;
		switch (dormSelection) {
		case AdministratorOffice:
			dsConcreteObject = new DormSelectionOffice();
			break;
		case OnlineGaming:
			dsConcreteObject = new DormSelectionGaming();
			break;
		default:
			break;
		}
		return dsConcreteObject;
	}

	
}
