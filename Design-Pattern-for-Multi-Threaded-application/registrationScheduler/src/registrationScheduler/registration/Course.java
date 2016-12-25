package registrationScheduler.registration;
import java.util.Arrays;
import java.util.HashMap;

import registrationScheduler.util.Logger;

/**
 * Class for Course Details
 * @author PRASHANT
 *
 */
public class Course {
	/**
	 * course Id - pribate class member
	 */
	private char courseId;
	
	/**
	 * Assigned student's collection
	 */
	private HashMap<Integer,Integer> assignedStudents;
	
	/**
	 * Results - One parameter constructor
	 * sets id and initializes empty hash map
	 * @param id
	 */
	public Course(char id){
		setCourseId(id);
		setAssignedStudents(new HashMap<>());
		Logger.writeMessage("\n--------------------------- In Course Constructor ---------------------------\n"
				+" Set Course Id and initialized HashMap<Integer,Integer> assignedStudents\n"
				+ "---------------------------------------------------------------------------------\n"
				, Logger.DebugLevel.CONSTRUCTOR);
		Logger.writeMessage(this.toString() , Logger.DebugLevel.CONSTRUCTOR);
	}
	/**
	 * Overridden toString Method
	 */
	@Override
	public String toString() {
		return "Course Id :"+courseId +
				"\nAssigned Students : "+ Arrays.toString(assignedStudents.keySet().toArray());
	}
	
	/**
	 * getCourseId - courseId getter
	 * @return courseId
	 */
	public char getCourseId() {
		return courseId;
	}

	/**
	 * setCourseId - courseId setter
	 * @param courseId
	 */
	public void setCourseId(char courseId) {
		this.courseId = courseId;
	}

		
	/**
	 * assignedStudents - assignedStudents getter
	 * @return
	 */
	public synchronized HashMap<Integer,Integer> getAssignedStudents() {
		return assignedStudents;
	}

	/**
	 * assignedStudents setter
	 * @param assignedStudents
	 */
	public void setAssignedStudents(HashMap<Integer,Integer> assignedStudents) {
		this.assignedStudents = assignedStudents;
	}

}
