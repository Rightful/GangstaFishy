/**
 * 
 */
package Test;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.Collection;
import java.util.Scanner;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import Model.DebugLogger;
import Model.ErrorLogger;
import Model.Logger;
import Model.NoticeLogger;

/**
 * @author Kasper Grabarz
 *
 */
@RunWith(Parameterized.class)
public class LoggerTest {
	
	private Logger logger;
	/**
	 * constructor for Collisionmap tests.
	 * @param collisionmap the collisionmap.
	 */
	public LoggerTest(Logger logger) {
		this.logger = logger;
	}

	/**
	 * Test method for {@link Model.Logger#writeMessage(java.lang.String)}.
	 * Tests if a file containing the message gets created
	 */
	@Test
	public void testWriteMessageFileCreation() {
		String filename = "testfile";
		String teststring = "teststring";
		File file = new File(filename);
		assertFalse(file.exists());
		if(file.exists())
		{
			return;
		}
		
		logger.writeMessage(teststring, filename);

		assertTrue(file.exists());
		Scanner scanner = null;
		try {
			scanner = new Scanner(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String lineFromFile = scanner.nextLine();
		assertTrue(lineFromFile.contains(teststring));
		scanner.close();		
		file.delete();
	}

	
	/**
	 * parameters used for this test.
	 * @return list of parameters
	 */	
	@Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[]{new ErrorLogger()},
				new Object[]{new DebugLogger()},
				new Object[]{new NoticeLogger()}
				); 
	}
}
