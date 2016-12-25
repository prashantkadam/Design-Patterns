package registrationScheduler.registration;
import java.util.Arrays;
import java.util.Vector;

import registrationScheduler.util.Logger;

/**
 * Class for Student details
 * @author PRASHANT
 *
 */
public class Student {
	
	/**
	 *  private ArrayLists for assigned courses 
	 */
	private Vector<Character> assignedCourses;
	/**
	 * private ArrayList for not assigned courses	
	 */
	private Vector<Character> notAssignedCourses;
	
	/**
	 * constructor
	 * @param id
	 * @param a - choice for A
	 * @param b - choice for B
	 * @param c - choice for C
	 * @param d - choice for D
	 * @param e - choice for E
	 * @param f - choice for F
	 * @param f - choice for G
	 */
	public Student(int id,int a, int b,int c, int d,int e,int f, int g){
		studentId = id;
		choiceArr = new int[7];
		setAssignedCourses(new Vector<>());
		setNotAssignedCourses(new Vector<>());
		choiceArr[0] = a;
		choiceArr[1] = b;
		choiceArr[2] = c;
		choiceArr[3] = d;
		choiceArr[4] = e;
		choiceArr[5] = f;
		choiceArr[6] = g;
		preferenceScore = 0;
		next = 1;
		Logger.writeMessage(
				"\n--------------------------- In Student Constructor ---------------------------\n"
				+" creating object of Student reading data from file and filling student details\n"
				+ this.toString() 
				+"\n------------------------------------------------------------------------\n"
				, Logger.DebugLevel.CONSTRUCTOR);
	
	}
	/**
	 *Overridden toString Method
	 */
	@Override
	public String toString() {
		return 	" Student Id: "+studentId +
				" \n Choices :"+ Arrays.toString(choiceArr) + 
				" \n Preference score : "+ preferenceScore + 
				" \n Assigned Courses :"+ Arrays.toString(assignedCourses.toArray())+
				" \n Not Assigned Courses :"+ Arrays.toString(notAssignedCourses.toArray());
		
	}
	
	/**
	 * Result - Gives array index of perticular choice
	 * @param a - array
	 * @param x - choice
	 * @return  index of choice
	 */
	public int getIndex(int[] a, int x){
		try {
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
		return -1;
	}
	
	/**
	 * Result - Gives choice of perticular course
	 * @param a - array
	 * @param x - course
	 * @return index of choice
	 */
	public int getchoice(int[] a, char x){
		if(x == 'A')
			return a[0];
		else if(x == 'B')
			return a[1];
		else if(x == 'C')
			return a[2];
		else if(x == 'D')
			return a[3];
		else if(x == 'E')
			return a[4];
		else if(x == 'F')
			return a[5];
		else if(x == 'G')
			return a[6];
		return -1;
	}
	
	/**
	 * notAssignedCourses getter
	 * @return Vector<Character>
	 */
	public synchronized Vector<Character>  getNotAssignedCourses() {
		return notAssignedCourses;
	}
	
	public int studentId;
	public int[] choiceArr;	
	public double preferenceScore;
	public int next;
	
	/**
	 * notAssignedCourses setter
	 * @param notAssignedCourses - Vector<Character>
	 */
	public void setNotAssignedCourses(Vector<Character> notAssignedCourses) {
		this.notAssignedCourses = notAssignedCourses;
	}
	
	/**
	 * assignedCourses getter
	 * @param assignedCourses - Vector<Character>
	 */
	public synchronized Vector<Character> getAssignedCourses() {
		return assignedCourses;
	}
	
	/**
	 * setter for AssignedCourses
	 * @param AssignedCourses - Vector<Character>
	 */
	public void setAssignedCourses(Vector<Character> assignedCourses) {
		this.assignedCourses = assignedCourses;
	}
}
