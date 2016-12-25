package registrationScheduler.util;
import java.util.Map;

import registrationScheduler.registration.Course;

/**
 * Class ObjectPool		Manages Course collection
 * @author PRASHANT
 * 
 */
public class ObjectPool {
	
	/**
	 * single instance variable
	 */
	private volatile static ObjectPool objectPoolInstance = null;
	
	private Map<Character, Course> courseDictionary = null;	
	
	/**
	 * Private constructor
	 */
	private ObjectPool(){
		Logger.writeMessage(
				"\n--------------------------- In ObjectPool Constructor ---------------------------\n"
				+"\t\t\n"
				+"------------------------------------------------------------------------\n"
				, Logger.DebugLevel.CONSTRUCTOR);
	}
	
	/**
	 * getInstance method 	which will return single instance of Object Pool
	 * @return instance of Object Pool
	 */
	public static ObjectPool getInstance() {
		if (objectPoolInstance == null) {  
	          synchronized (ObjectPool.class) {    
	            if (objectPoolInstance == null) { 
	            	objectPoolInstance = new ObjectPool(); 
	               }           
	 }
	        }        
	return objectPoolInstance; 
	}
	
	/**
	 * acquire Method in Object Pool
	 * acquires object to pool
	 * @param courseDictionaryIn
	 */
	public void acquireCollection(Map<Character, Course> courseDictionaryIn) {
		courseDictionary = courseDictionaryIn;
	}
	
	/**
	 * Release Method in Object Pool
	 * This method releases pool 
	 * @param courseDictionaryIn
	 */
	public void releaseCollection() {
		courseDictionary = null;
		}
	
	/**
	 * This method checks Is seats available in Course
	 * @param courseName
	 * @return flag indicating availability 
	 */
	public synchronized boolean checkAvailabilityOfCourse(Character courseName){
		return getCourseSeatsCount(courseName) < 60;
	}
	
	/**
	 * getCourseSeatsCount method
	 * @param character course
	 * @return - current size of course
	 */
	public synchronized int getCourseSeatsCount(Character character) {
		int size = 0;
		synchronized (courseDictionary) {
			if(courseDictionary.containsKey(Character.valueOf(character)))
			size = courseDictionary.get(character).getAssignedStudents().size();
		}
		return size;
	}
	
}
