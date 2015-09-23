package Model;	

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class Juggernaut extends PowerUp{
	
	private BufferedImage spriteFinal;
	private Logger NOTICELOGGER = new NoticeLogger();
	
	public Juggernaut() {
		try {
			sprite = ImageIO.read(new File("img/Juggernog.gif"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		spriteFinal = ((BufferedImage) sprite);
		NOTICELOGGER.message("Juggernaut PowerUp created", Logger.NOTICE);
	}
	
	/**
	 * return the final image of the sprite.
	 * 
	 * @return final sprite.
	 */
	public BufferedImage getSpriteFinal() {
		return spriteFinal;
	}

	/**
	 * set the final image of the sprite.
	 * 
	 * @param spriteFinal
	 *            final image to be set.
	 */
	public void setSpriteFinal(BufferedImage spriteFinal) {
		this.spriteFinal = spriteFinal;
	}
	
}