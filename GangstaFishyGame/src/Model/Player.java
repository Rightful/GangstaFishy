package Model;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * 
 * @author Kamran Tadzjibov
 *
 */

public class Player {
	
	private int score = 0;
	private Image sprite;

	public Player(){
		try {
			sprite = ImageIO.read(new File("img/player.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public Image getSprite() {
		return sprite;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
}
