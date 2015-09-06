import java.awt.EventQueue;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import Controller.Controller;
import sun.applet.Main;

/**
 * 
 * @author Kamran Tadzjibov
 *
 */

public class Application {

	public static synchronized void playSound() {
		new Thread(new Runnable() {
			// The wrapper thread is unnecessary, unless it blocks on the
			// Clip finishing; see comments.
			public void run() {
				try {
					Clip clip = AudioSystem.getClip();
					AudioInputStream inputStream = AudioSystem
							.getAudioInputStream(Main.class.getResourceAsStream("sounds/Thug Life Music.mp3"));
					clip.open(inputStream);
					clip.start();
				} catch (Exception e) {
					System.err.println(e.getMessage());
				}
			}
		}).start();
	}

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				playSound();
				Controller controller = new Controller();
				// controller.control();
			}
		});
	}
}
