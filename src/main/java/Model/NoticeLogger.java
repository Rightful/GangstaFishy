package Model;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * Author: Kasper Grabarz
 */
public class NoticeLogger extends Logger {

	/** The loggertype used as a prefix in log messages */
	private static final String loggerType = "NOTICE";
	
	/**
	 * Instantiates a new notice logger.
	 */
	public NoticeLogger(){}
	
	
	/** 
	 * Writes a prefixed/timestamped log message to a file with the name and the message
	 * of the file passed as parameters 
	 */
	@Override
	public void writeMessage(String message, String filename) {
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		BufferedWriter writer;
		try {
			writer = new BufferedWriter(new FileWriter(filename, true));
			writer.write(loggerType + " " + timeStamp + " " + message + "\n");
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		

	}

}
