package main.java.View;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 * For creating background music.
 * 
 * @author Shivam
 *
 */
public class Sound {
	/**
	 * create thread to play the sound.
	 * 
	 * @param filename
	 */
	public synchronized static void playSound(final String filename) {
		new Thread(new Runnable() {
			public void run() {
				AudioInputStream inputStream = null;
				try {
					inputStream = AudioSystem.getAudioInputStream(new File(
							filename));
				} catch (UnsupportedAudioFileException | IOException e) {
					e.printStackTrace();
				}
				Clip clip = null;
				try {
					clip = AudioSystem.getClip();
				} catch (LineUnavailableException e) {
					e.printStackTrace();
				}
				try {
					clip.open(inputStream);
				} catch (LineUnavailableException | IOException e) {
					e.printStackTrace();
				}
				clip.loop(Clip.LOOP_CONTINUOUSLY);
				try {
					Thread.sleep(10000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}).start();
	}

}
