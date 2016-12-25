package registrationScheduler.registration;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import registrationScheduler.store.Results;
import registrationScheduler.util.Logger;
import registrationScheduler.util.ObjectPool;

/**
 * Allocator 	class which runs actual algorithm for course assignment
 * @author PRASHANT
 *
 */
public class Allocator {
	
	/**
	 * Instance of Object Pool
	 */
	private ObjectPool objectpoolInstance = null; 
	
	private int index = 1;
	/**
	 * Allocator constructor
	 */
	public Allocator() {
		objectpoolInstance = ObjectPool.getInstance();
		Logger.writeMessage("\n--------------------------- In Allocator Constructor ---------------------------\n"
				+" ObjectPool Instance retrived\n"
				+ "---------------------------------------------------------------------------------\n"
				, Logger.DebugLevel.CONSTRUCTOR);
	}
	/**
	 * synchronized getStudent method will pass student to ProcessSudent method
	 * @param studentDict
	 * @return Students
	 */
	public synchronized Student getStudent(Map<Integer, Student> studentDict){
		return studentDict.get(index);
	}
	
	/**
	 * synchronized incrementIndex method
	 */
	public synchronized void incrementIndex(){
		if(index == 80){
			index = 1;
		}
		else{
			index++;
		}
	}
	/**
	 * synchronized decrementIndex method
	 */
	public synchronized void decrementIndex(){
		if(index == 1){
			index = 80;
		}
		else{
			index--;
		}
	}
	
	/**
	 * This Method Process student as assigns courses
	 * @param results
	 * @param workerName
	 */
	public synchronized void processStudent(Results results) {
		try {
			objectpoolInstance.acquireCollection(results.getCourseDictionary());
			Student s = getStudent(results.getStudentDictionary());
			
			if(s!= null){
				incrementIndex();
				Character mappedCourse = results.getPreferenceToCourse().get(getIndexOfNextAssignment(s));
				
		    	if(s.next > 7 && getAssignedCoursesSize(s)< 5 && isEveryOneEvaluatedSevenTimes(results.getStudentDictionary())){
					//all seven choices evaluated but assigned with < 5
						processUnluckyStudent(results,s);
						results.decCountOfAssignments();
						decrementIndex();
						return;
				}
				else if(s.next > 7)
					return;
				else if(!results.getCourseDictionary().containsKey(mappedCourse)){
					results.addToCourseDictionary(s,mappedCourse,new Course(mappedCourse));
					}
		    	int size = objectpoolInstance.getCourseSeatsCount(mappedCourse);
				if(objectpoolInstance.checkAvailabilityOfCourse(mappedCourse) && s.getAssignedCourses().size() < 5 )
				{	
					addToCourse(results,s);
				}
				else{
					if(!s.getNotAssignedCourses().contains(Character.valueOf(mappedCourse)))
						results.addToNotAssignedCourses(s,mappedCourse);
						s.next++;
						decrementIndex();
				}
			}
			
		} catch (Exception e) {
			System.err.println(" Exception Occured - \n");
			e.printStackTrace();
			System.exit(0);
		}
		finally {
			
		}
	}

	/**
	 * addToCourse method adds course to student assigned course
	 * @param results
	 * @param s
	 * @param workerName
	 */
	private synchronized  void addToCourse(Results results,Student student) {
		Character course = results.getPreferenceToCourse().get(getIndexOfNextAssignment(student));
		results.getCourseDictionary().get(course).getAssignedStudents().put(student.studentId,student.next);
		Logger.writeMessage("Added "+ student.studentId+" to Course "+ course 
							+"\n"
							+"----------------------------------------------\n"
							, Logger.DebugLevel.RESULT_DATA_STRUCTURE);
		if(student.getAssignedCourses().contains(Character.valueOf(course))){
			results.updateNotAssignedCourses(student,course);
		}
		else{
				results.updateAssignedCourses(student, course);
			results.incCountOfAssignments();
		}
		
	}

	/**
	 * processUnluckyStudent Process unlucky student and part of actual algorithm
	 * @param results
	 * @param s
	 */
	private synchronized void processUnluckyStudent(Results results,Student s) {
		try {
			Character c = s.getNotAssignedCourses().remove(0);
			int max_choice = Collections.max(results.getCourseDictionary().get(c).getAssignedStudents().values());
			int studentIdwithMaxChoice = -1;
			s.next = courseToPreferenceMapping(s.choiceArr, c);
			for(HashMap.Entry<Integer, Integer> entry : results.getCourseDictionary().get(c).getAssignedStudents().entrySet()){
				if(entry.getValue()== max_choice){
					studentIdwithMaxChoice = entry.getKey();
					break;
				}
			}
			if(studentIdwithMaxChoice != -1){
				Student unlucky = results.getStudentDictionary().get(studentIdwithMaxChoice);
				results.getCourseDictionary().get(c).getAssignedStudents().remove(studentIdwithMaxChoice);
				unlucky.getAssignedCourses().remove(Character.valueOf(c));
				unlucky.getNotAssignedCourses().add(c);
				unlucky.preferenceScore -= max_choice;
				results.getStudentDictionary().get(studentIdwithMaxChoice).next = unlucky.getchoice(unlucky.choiceArr, unlucky.getNotAssignedCourses().get(0));
			}
		} catch (Exception e) {
			System.err.println(" Exception Occured - \n");
			e.printStackTrace();
			System.exit(0);
		}
		finally {
			
		}
	
}
	/**
	 * This method return mapping
	 * @param choices
	 * @param course
	 * @returns index of course in choice
	 */
	private  int courseToPreferenceMapping(int[] choices,Character course){
	
	int  choice_number = -1;
	
	if(course == 'A')
		return choices[0];
	if(course == 'B')
		return choices[1];
	if(course == 'C')
		return choices[2];
	if(course == 'D')
		return choices[3];
	if(course == 'E')
		return choices[4];
	if(course == 'F')
		return choices[5];
	if(course == 'G')
		return choices[6];
	
	return choice_number;
	
}
	

	/**
	 * synchronized Method 		which will check is Every student evaluated Seven time
	 * @param studentDictionary
	 * @return boolean - is all choices evaluated atleast once
	 */
	public synchronized boolean isEveryOneEvaluatedSevenTimes(Map<Integer, Student> studentDictionary) {		
			boolean evaluatedSevenTimes = true; 
			for (int i = 1; i <= 80; i++) {
				Student s = studentDictionary.get(i);
				if(s.next>7){
					continue;
				}
				else{
					evaluatedSevenTimes = false;
					break;
				}
			}
			return evaluatedSevenTimes;
		}	
	
	/**
	 * getIndex Method
	 * @param student
	 * @return return index of choice of course to be assigned next
	 */
	public synchronized int getIndexOfNextAssignment(Student student){
		int[] choiceArr = student.choiceArr; 
		int x = student.next;
		try {
			for (int i : choiceArr) {
				if(choiceArr[i-1] == x){
					return i;
				}
			}		
		} catch (Exception e) {
			System.err.println(" Exception Occured - \n");
			e.printStackTrace();
			System.exit(0);
		}
		return -1;
	}
	
	/**
	 * getAssignedCoursesSize Method
	 * @param s - student
	 * @returns - size of assigned courses to this student
	 */
	public synchronized int getAssignedCoursesSize(Student s) {
		return s.getAssignedCourses().size();
	}	
}
