import java.awt.EventQueue;

import Controller.Controller;

/**
 * 
 * @author Kamran Tadzjibov
 *
 */

public class Application{

	public static void main(String[] args) {
	    EventQueue.invokeLater(new Runnable() {
	      
	    	@Override
	      public void run() {
//	    	  Frame viewFrame = new Frame();

              Controller controller = new Controller();
//              controller.control();
	    	}
	    });
	  }	
}
