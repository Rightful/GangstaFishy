import java.awt.EventQueue;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import Controller.Controller;

/**
 * 
 * @author Kamran Tadzjibov
 *
 */

public class Application {

	public static synchronized void playSound(final String filename) {
		new Thread(new Runnable() {
			// The wrapper thread is unnecessary, unless it blocks on the
			// Clip finishing; see comments.
			public void run() {

		        AudioInputStream inputStream = null;
				try {
					inputStream = AudioSystem.getAudioInputStream(new File(filename));
				} catch (UnsupportedAudioFileException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		        Clip clip = null;
				try {
					clip = AudioSystem.getClip();
				} catch (LineUnavailableException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		        try {
					clip.open(inputStream);
				} catch (LineUnavailableException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		        clip.loop(Clip.LOOP_CONTINUOUSLY);
		        try {
					Thread.sleep(10000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} // looping as long as this thread is alive
			}
		}).start();
	}

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				Controller controller = new Controller();
				playSound("sound/Thug_Life_Music.wav");
				// controller.control();
			}
		});
	}
}
