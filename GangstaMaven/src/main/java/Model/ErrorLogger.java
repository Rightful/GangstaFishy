package Model;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ErrorLogger extends Logger {
	
	private static final String loggerType = "ERROR";
	public ErrorLogger(){}
	@Override
	public void writeMessage(String message) {
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		BufferedWriter writer;
		try {
			writer = new BufferedWriter(new FileWriter("application.log", true));
			writer.write(loggerType + " " + timeStamp + " " + message + "\n");
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		

	}
}
