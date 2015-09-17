package Model;

public abstract class Logger {
	
	public static final int ERROR = 1;
	public static final int NOTICE = 2;
	public static final int DEBUG = 3;
	public static final String filename = "application.log";
	
	/** 
	 * Writes a prefixed/timestamped log message to a file with the name and the message
	 * of the file passed as parameters 
	 */
	public abstract void writeMessage(String message, String filename);

	/**
	 * passthrough function that takes a mode argument
	 * to be used in possible future implementations	 * 
	 */
	public void message(String message, int mode)
	{
		writeMessage(message, filename);
	}
	
}
