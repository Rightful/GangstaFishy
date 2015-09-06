import java.awt.EventQueue;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import Controller.Controller;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import sun.audio.AudioData;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
import sun.audio.ContinuousAudioDataStream;

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
				AudioPlayer MGP = AudioPlayer.player;
				AudioStream BGM;
				AudioData MD;

				ContinuousAudioDataStream loop = null;

				try {
					InputStream test = new FileInputStream(filename);
					BGM = new AudioStream(test);
					AudioPlayer.player.start(BGM);
					// MD = BGM.getData();
					// loop = new ContinuousAudioDataStream(MD);

				} catch (FileNotFoundException e) {
					System.out.print(e.toString());
				} catch (IOException error) {
					System.out.print(error.toString());
				}
				MGP.start(loop);
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
