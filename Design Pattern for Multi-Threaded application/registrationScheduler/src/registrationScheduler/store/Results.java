package registrationScheduler.store;
import java.io.File;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import registrationScheduler.registration.Course;
import registrationScheduler.registration.Student;
import registrationScheduler.util.Logger;

/**
 *  
 * @author PRASHANT
 * Results Class 
 * This class implements to interfaces StdoutDisplayInterface,FileDisplayInterface
 * maintains actual data structures required for Registrations
 *
 */
public class Results implements StdoutDisplayInterface,FileDisplayInterface {
    
	/**
	 * appropriate data structure as private data member
	 */
	private Map<Integer, Student> studentDictionary = null;
	private Map<Character, Course> courseDictionary = null;	
		
	private int index = 1;
	private int countOfAssignments = 0;
	private HashMap<Integer,Character> preferenceToCourse = null;
	private double averageScore = 0.0;
	
	/**
	 * Results Constructor 
	 * Following data structures initialized
	 * Map<Integer, Student>  - studentDictionary
	 * Map<Character, Course> - courseDictionary created
	 */
	public Results() {		
		setStudentDictionary(new HashMap<Integer, Student>());
		setCourseDictionary(new HashMap<>());
		setPreferenceToCourse(new HashMap<>());
		initPreferenceToCourse(getPreferenceToCourse());
		
		Logger.writeMessage(
			"\n--------------------------- In Results Constructor ---------------------------\n"
			+ " Following data structures initialized"
			+ "	Map<Integer, Student>  - studentDictionary\n"
			+ " Map<Character, Course> - courseDictionary created\n"
			+ "---------------------------------------------------------------------------------\n"
			, Logger.DebugLevel.CONSTRUCTOR);
	}
	
	/**
	 * Overridden toString Method 
	 */
	@Override 
	public String toString() {
		return contentStudentDictionary();
	};
	
	/*
	* getCountOfAssignments - getter 
	 * @return total count till that allocation
	 */
	public int getCountOfAssignments() {
		return countOfAssignments;
	}
	/**
	 * setCountOfAssignments  - setter
	 * @param countOfAssignments
	 */
	public synchronized void setCountOfAssignments(int countOfAssignments) {
		this.countOfAssignments = countOfAssignments;
	}
	
	/**
	 * synchronized incCountOfAssignments method 
	 * to increment count Of total Assignments
	 */
	public synchronized void incCountOfAssignments() {
		this.countOfAssignments++;
	}
	/**
	 * synchronized incCountOfAssignments method 
	 * to decrement count Of total Assignments
	 */
	public synchronized void decCountOfAssignments() {
		this.countOfAssignments--;
	}
	
	/**
	 * getPreferenceToCourse - getter 
	 * needs internally by algorithm
	 * @param preferenceToCourse
	 */
	public HashMap<Integer,Character> getPreferenceToCourse() {
		return preferenceToCourse;
	}
	
	/**
	 * setPreferenceToCourse - setter 
	 * @param preferenceToCourse
	 */
	public void setPreferenceToCourse(HashMap<Integer,Character> preferenceToCourse) {
		this.preferenceToCourse = preferenceToCourse;
	}

	/**
	  * writeSchedulesToScreen method used to write result to screen
	 */
	@Override
	
	public void writeSchedulesToScreen() {
		String content = contentStudentDictionary();		
		Logger.writeMessage("Average preference value: "+ averageScore, Logger.DebugLevel.NO_OUTPUT);
	}

	/**
	 * StudentDictionary getter
	 * @return StudentDictionary
	 */
	public synchronized Map<Integer, Student> getStudentDictionary() {
		return studentDictionary;
	}
	/**
	 * StudentDictionary setter
	 *
	 */
	public void setStudentDictionary(Map<Integer, Student> studentDictionary) {
		this.studentDictionary = studentDictionary;
	}

	/**
	 * courseDictionary getter
	 * @return courseDictionary
	 */
	public synchronized Map<Character, Course> getCourseDictionary() {
		return courseDictionary;
	}

	/**
	 * courseDictionary setter
	 */
	public void setCourseDictionary(Map<Character, Course> courseDictionary) {
		this.courseDictionary = courseDictionary;
	}
	 
	/**
	 * Initialize private hash map 
	 * This is internal Data structure required for algorithm
	 * @param preferenceToCourse
	 */
	private void initPreferenceToCourse(HashMap<Integer, Character> preferenceToCourse) {		
		preferenceToCourse.put(1, 'A');
		preferenceToCourse.put(2, 'B');
		preferenceToCourse.put(3, 'C');
		preferenceToCourse.put(4, 'D');
		preferenceToCourse.put(5, 'E');
		preferenceToCourse.put(6, 'F');
		preferenceToCourse.put(7, 'G');
	}
	
	/**
	 * synchronized addToStudentDictionary Method
	 * adds student to Student dictionary
	 * @param line
	 */
	public synchronized void addToStudentDictionary(String line) {
		String[] splittedInput = line.split("\\s+");
		Student newStudent = new Student(index,Integer.parseInt(splittedInput[1]),
									Integer.parseInt(splittedInput[2]),
									Integer.parseInt(splittedInput[3]),
									Integer.parseInt(splittedInput[4]),
									Integer.parseInt(splittedInput[5]),
									Integer.parseInt(splittedInput[6]),
									Integer.parseInt(splittedInput[7]));
		addToStudnetDictionary(newStudent);
		index++;
	}
	
	/**
	 * synchronized addToStudentDictionary Method
	 * Overloaded method
	 * adds student to Student dictionary
	 * @param line
	 */
	private synchronized void addToStudnetDictionary(Student s){
		studentDictionary.put(index,s);
		Logger.writeMessage(
				"Student added to Student Dictionary\n"
				+ s.toString()
				+ "\n"
				+ "--------------------------------------------------------------"
				, Logger.DebugLevel.RESULT_DATA_STRUCTURE);		
	}
     
	/**
	 * synchronized addToCourseDictionary => put to Course Dictionary
	 * @param s = student
	 * @param character => course name 
	 * @param course => actual object to be added to dictionary
	 */
	public synchronized void addToCourseDictionary(Student s,Character character, Course course) {
		try {
			Character courseChar = getPreferenceToCourse().get(getIndex(s));
			getCourseDictionary().put(courseChar,new Course(courseChar));
			Logger.writeMessage("Added to Course Dictionary - course : "+ courseChar, Logger.DebugLevel.RESULT_DATA_STRUCTURE);

		} catch (Exception e) {
			System.err.println(" Exception Occured - \n");
			e.printStackTrace();
			System.exit(0);
			
		}
			}
	
	
	
	/**
	 * addToNotAssignedCourses  adds course to Not assigned vector
	 * @param student
	 * @param character
	 */
	public synchronized  void addToNotAssignedCourses(Student s, Character character) {
		s.getNotAssignedCourses().add(character);		
	}
	
	/**
	 * synchronized updateAssignedStudent method
	 * @param courseDictionary
	 * @param course
	 * @param s
	 */
	public synchronized  void updateAssignedStudent(Map<Character, Course> courseDictionary, Character course, Student s) {
		courseDictionary.get(course).getAssignedStudents().put(s.studentId,s.next);		
	}
	
	/**
	 * synchronized  updateNotAssignedCourses method
	 * @param s
	 * @param course
	 */
	public synchronized  void updateNotAssignedCourses(Student s, Character course) {
		s.getNotAssignedCourses().remove(Character.valueOf(course));
		s.next = s.getchoice(s.choiceArr, s.getNotAssignedCourses().get(0));
		Logger.writeMessage("removed "+ course +" from NotAssignedCourses for student "+ s.studentId, Logger.DebugLevel.RESULT_DATA_STRUCTURE);
	}
	/**
	 * synchronized  void updateAssignedCourses method
	 * @param student object
	 * @param courseName
	 */
	public synchronized  void updateAssignedCourses(Student s, Character course) {
		s.getAssignedCourses().add(course);
		s.preferenceScore += s.next;
		s.next++;
		Logger.writeMessage("Added "+ course +" to AssignedCourses for student "+ s.studentId, Logger.DebugLevel.RESULT_DATA_STRUCTURE);
		
	}

	/**
	 * writeSchedulesToFile method Overridden from FileDispalyInterface
	 */
	@Override
	public void writeSchedulesToFile(String outputFileName) {
		try {
			File outputFile = new File(outputFileName);
			PrintWriter printer = new PrintWriter(outputFile);
			printer.println(contentStudentDictionary());
			printer.close();
			
		} catch (Exception e) {
			System.err.println(" Exception Occured - \n");
			e.printStackTrace();
			System.exit(0);
		}		
	}

	/**
	 * prints content of Student Dictionary
	 * @return
	 */
	public String contentStudentDictionary() {
		StringBuilder sb = new StringBuilder();
		try {
			double sum = 0.0;
			for (int i = 1; i <= 80; i++) {
				Student s = getStudentDictionary().get(i);				
				sb.append("Student_"+s.studentId+" ");
				for(Character a : s.getAssignedCourses()){
					sb.append(a + " ");				
				}
				sb.append(s.preferenceScore);
				sum += s.preferenceScore;
				sb.append("\n");
			}
			averageScore = sum/80.0;
			sb.append("\n Average preference value: "+ averageScore);
		} catch (Exception e) {
			System.err.println(" Exception Occured - \n");
			e.printStackTrace();
			System.exit(0);
		}
		finally {
			
		}
		return sb.toString();
	}
	
	/**
	 * prints content of Course Dictionary
	 * @return
	 */
	public String contentCourseDictionary() {
		StringBuilder sb = new StringBuilder();
		
		try {
			for(Map.Entry<Character, Course> entry : courseDictionary.entrySet()){
				sb.append("\n\n");
				sb.append(entry.getValue().toString());
			}	
		} catch (Exception e) {
			System.err.println(" Exception Occured - \n");
			e.printStackTrace();
			System.exit(0);
		}
		finally {
			
		}
		
		return sb.toString();
	}
	
	/**
	 * getIndex Method
	 * @param student object
	 * @return return index of choice of course to be assigned next
	 */
	public synchronized int getIndex(Student s){
		try {
			int[] a = s.choiceArr; 
			int x = s.next;
			for (int i : a) {
				if(a[i-1] == x){
					return i;
				}
			}	
		} catch (Exception e) {
			System.err.println(" Exception Occured - \n");
			e.printStackTrace();
			System.exit(0);
		}
		finally {
			
		}	
		return -1;
	}

} 


