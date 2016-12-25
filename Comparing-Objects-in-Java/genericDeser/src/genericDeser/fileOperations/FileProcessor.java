package genericDeser.fileOperations;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import genericDeser.util.Logger;

public class FileProcessor {
	/**
	 * private variable BufferedReader fileReader
	 */
	private BufferedReader fileReader = null;
	/**
	 * private variable BufferedWriter fileWriter
	 */
	private BufferedWriter fileWriter = null;

	/**
	 * Constructor
	 * 
	 * @param fileScannerIn
	 */
	public FileProcessor(BufferedReader fileScannerIn) {
		Logger.writeMessage("FileProcessor constructor", Logger.DebugLevel.CONSTRUCTOR);
		fileReader = fileScannerIn;
	}

	/**
	 * Constructor
	 * 
	 * @param fileWriterIn
	 */
	public FileProcessor(BufferedWriter fileWriterIn) {
		Logger.writeMessage("FileProcessor constructor", Logger.DebugLevel.CONSTRUCTOR);
		fileWriter = fileWriterIn;
	}

	/**
	 * Method - closeBufferReader
	 */
	public void closeBufferReader() {
		try {
			fileReader.close();
		} catch (IOException e) {
			System.err.println(" Exception Occured  Method File Processor -> CloseBufferReader - \n");
			e.printStackTrace();
			System.exit(0);
		} finally {

		}
	}

	/**
	 * Method - closeBufferWriter
	 */
	public void closeBufferWriter() {
		try {
			fileWriter.close();
		} catch (IOException e) {
			System.err.println(" Exception Occured  Method File Processor -> Close Buffer Writer - \n");
			e.printStackTrace();
			System.exit(0);
		} finally {

		}
	}

	/**
	 * Method - readLine
	 */
	public String readLine() {
		String line = null;
		try {
			line = fileReader.readLine();
		} catch (Exception e) {
			System.err.println(" Exception Occured  Method File Processor -> ReadLine - \n");
			e.printStackTrace();
			System.exit(0);
		} finally {
			// closing file scanner where read line is called
		}
		return line;
	}

}
