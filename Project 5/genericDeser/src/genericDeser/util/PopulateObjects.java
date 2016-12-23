package genericDeser.util;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import genericDeser.fileOperations.FileProcessor;

/**
 * Class - PopulateObjects
 * 
 * @author PRASHANT
 *
 */
public class PopulateObjects {

	/**
	 * Private Data Member Array objects
	 */
	private ArrayList<Object> arrayObject = null;
	/**
	 * Other Private Data Members
	 */
	private HashMap<String, String> typeDetails = null;
	private Statistics allRequiredCount = null;
	private Object obj = null;
	private Class<?> cls = null;

	private HashMap<String, Class<?>> TypesCollection = null;

	private FileProcessor fpObj = null;

	/**
	 * PopulateObjects Constructor
	 */
	public PopulateObjects(FileProcessor fpObjIn) {
		Logger.writeMessage("Populate Object constructor", Logger.DebugLevel.CONSTRUCTOR);
		arrayObject = new ArrayList<>();
		typeDetails = new HashMap<>();
		allRequiredCount = new Statistics();
		TypesCollection = new HashMap<>();
		TypesCollection.put("int", Integer.TYPE);
		TypesCollection.put("float", Float.TYPE);
		TypesCollection.put("short", Short.TYPE);
		TypesCollection.put("String", String.class);
		TypesCollection.put("boolean", Boolean.TYPE);
		TypesCollection.put("double", Double.TYPE);
		fpObj = fpObjIn;
	}

	public void populateDataStructure() {
		String inputLine = fpObj.readLine();
		try {
			while (inputLine != null) {
				if (inputLine != null & inputLine.length() != 0)
					extractTypeObject(inputLine);
				inputLine = null;
				inputLine = fpObj.readLine();
			}
			fpObj.closeBufferReader();
		} catch (Exception e) {
			System.err.println(" Exception Occured  Method populateDataStructure \n");
			e.printStackTrace();
			System.exit(0);
		}
	}

	/**
	 * processCollection Method
	 */
	public void processCollection() {
		Logger.writeMessage("processCollection Called", Logger.DebugLevel.ProcessCollection);
		Set<First> setFirst = new HashSet<>();
		Set<Second> setSecond = new HashSet<>();
		int sum1 = 0;
		int sum2 = 0;

		try {
			for (Object object : arrayObject) {
				if (object instanceof First) {
					sum1++;
					setFirst.add((First) object);
				} else if (object instanceof Second) {
					sum2++;
					setSecond.add((Second) object);
				}
			}
		} catch (Exception e) {
			System.err.println(" Exception Occured  Method processCollection \n");
			e.printStackTrace();
			System.exit(0);
		}

		// Set required count
		allRequiredCount.setTotalFirst(sum1);
		allRequiredCount.setTotalSecond(sum2);
		allRequiredCount.setUniqueFirst(setFirst.size());
		allRequiredCount.setUniqueSecond(setSecond.size());
	}

	/**
	 * Method - extract Type Object from Input line
	 * 
	 * @param line
	 */
	public void extractTypeObject(String line) {
		Logger.writeMessage("extractTypeObject Method Called", Logger.DebugLevel.ExtractObject);
		try {
			if (line.contains("fqn:")) {
				obj = null;
				cls = null;
				String clsName = line.substring(4, line.length()); // generalize
				cls = Class.forName(clsName);
				obj = cls.newInstance();
				arrayObject.add(obj);
			} else {
				Class<?>[] signature = new Class[1];
				Object[] params = new Object[1];
				String[] detailsFromLine = line.split(",");
				typeDetails.put("type", detailsFromLine[0].replace("type=", "").trim());
				typeDetails.put("var", detailsFromLine[1].replace("var=", "").trim());
				typeDetails.put("value", detailsFromLine[2].replace("value=", "").trim());
				String methodName = "set" + typeDetails.get("var");
				signature[0] = TypesCollection.get(typeDetails.get("type"));
				switch (typeDetails.get("type")) {
				case "int":
					params[0] = new Integer(typeDetails.get("value"));
					break;
				case "float":
					params[0] = new Float(typeDetails.get("value"));
					break;
				case "short":
					params[0] = new Short(typeDetails.get("value"));
					break;
				case "boolean":
					params[0] = new Boolean(typeDetails.get("value"));
					break;
				case "String":
					params[0] = new String(typeDetails.get("value"));
					break;
				case "double":
					params[0] = new Double(typeDetails.get("value"));
					break;
				default:
					break;
				}
				Method meth = cls.getMethod(methodName, signature);
				Object result = meth.invoke(obj, params);
			}
		} catch (Exception e) {
			System.err.println(" Exception Occured  Method extractTypeObject \n");
			e.printStackTrace();
			System.exit(0);
		} finally {
		}
	}

	/**
	 * Method - get Total First Objects
	 * 
	 * @return
	 */
	public int getTotalFirst() {
		return allRequiredCount.getTotalFirst();

	}

	/**
	 * Method - get Total Second Objects
	 * 
	 * @return
	 */
	public int getTotalSecond() {
		return allRequiredCount.getTotalSecond();

	}

	/**
	 * Method - get Unique First Objects
	 * 
	 * @return
	 */
	public int getUniqueFirst() {
		return allRequiredCount.getUniqueFirst();

	}

	/**
	 * Method - get Unique Second Objects
	 * 
	 * @return
	 */
	public int getUniqueSecond() {
		return allRequiredCount.getUniqueSecond();

	}

}
