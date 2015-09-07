import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import Controller.Controller;
import View.StartPanel;

/**
 * 
 * @author Kamran Tadzjibov
 *
 */

public class Application {
	static boolean Sound = true;
	/**
	 * @return the playSound
	 */
	public boolean getSound() {
		return Sound;
	}

	/**
	 * @param playSound the playSound to set
	 */
	public void setSound(boolean playSound) {
		Application.Sound = playSound;
	}

<<<<<<< HEAD
	public static synchronized void playSound(final String filename) {
		//Dit moet eigenlijk deel zijn van de View.
		//Dit kan zonder Thread en alles mag in een try catch block als je toch alleen e.printStackTrace(); doet
		//Als je iets anders wilt doen voor een specifieke exception, een try met multiple catch blocks.
		
=======
	public synchronized static void playSound(final String filename) {
>>>>>>> Ravi
		new Thread(new Runnable() {
			// The wrapper thread is unnecessary, unless it blocks on the
			// Clip finishing; see comments.
			public void run() {
				if(Sound){
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
				}
			}// looping as long as this thread is alive
			}
		}).start();
	}

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				Controller controller = new Controller();
				StartPanel start = controller.getStartPanel();
				start.getHighbutt().addActionListener(new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent e) {
						Sound = false;
					}
				});

				playSound("sound/Thug_Life_Music.wav");
				// controller.control();
			}
		});
	}
}
