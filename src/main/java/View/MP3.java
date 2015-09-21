package View;

import java.io.BufferedInputStream;
import java.io.FileInputStream;

import javazoom.jl.player.Player;

public class MP3 {
	private String filename;
	private Player player;

	public MP3() {

	}

	public void close() {
		if (player != null)
			player.close();
	}

	/**
	 * play the MP3 file to the sound card
	 */
	public void setupPlayer(String filename) {
		this.filename = filename;
		try {
			FileInputStream fis = new FileInputStream(filename);
			BufferedInputStream bis = new BufferedInputStream(fis);
			player = new Player(bis);
		} catch (Exception e) {
			System.out.println("Problem playing file " + filename);
			e.printStackTrace();
		}
	}

	/**
	 * @return the filename
	 */
	public String getFilename() {
		return filename;
	}

	/**
	 * @param filename the filename to set
	 */
	public void setFilename(String filename) {
		this.filename = filename;
	}

	/**
	 * @return the player
	 */
	public Player getPlayer() {
		return player;
	}

	/**
	 * @param player the player to set
	 */
	public void setPlayer(Player player) {
		this.player = player;
	}

/*	*//**
	 * Get the audio file length
	 * @throws IOException 
	 * @throws UnsupportedAudioFileException 
	 *//*
	public double getAudioLength() throws UnsupportedAudioFileException, IOException{
		double duration = 0;
		try {
		  AudioFile audioFile = AudioFileIO.read(new File(this.filename));
		  duration = audioFile.getAudioHeader().getTrackLength();

		} catch (Exception e) {
		  e.printStackTrace();

		}
		return duration;
	}*/
	
	/**
	 * Run in new thread to play in background
	 */
	public Thread createPlayerThread() {
		Thread thread = new Thread() {
			public void run() {
				while(true){
				try {
					player.play();
				} catch (Exception e) {
					System.out.println(e);
				}
			}}
		};
		return thread;
	}

}
