package Model;

public abstract class Logger {
	
	public static int ERROR = 1;
	public static int NOTICE = 2;
	public static int DEBUG = 3;
	
	
	public abstract void writeMessage(String message);
	public void message(String message, int mode)
	{
		writeMessage(message);
	}
}
