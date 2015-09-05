package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 * 
 * @author Kamran Tadzjibov
 *
 * Canvas to draw sprites etc.
 */

@SuppressWarnings("serial")
public class GamePanel extends JPanel{
	
	private Image playerSprite; 
	private Image bgImage;
	private int xPlayer, yPlayer, widthPlayer, heightPlayer, score;
	private String fishSpeed = "0 / 0";
	
	public GamePanel(){
		setVisible(false);
		try {
			bgImage = ImageIO.read(new File("img/bg1.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	@Override
    protected void paintComponent(Graphics g) {
    	super.paintComponent(g);
    	g.drawImage(bgImage, 0, 0, null);
		g.drawImage(playerSprite, xPlayer, yPlayer, widthPlayer, heightPlayer, this);
		g.setFont(new Font ("Calibri", Font.BOLD , 30));
		g.setColor(Color.white);
		g.drawString("Score: " + score, 30, 30);
		g.setFont(new Font ("Calibri", Font.BOLD , 16));
		g.drawString("speed/repaintTime: " + fishSpeed, 30, 60);
		// Collision Boundary will use later
//		g.drawOval(xPlayer, yPlayer, widthPlayer, heightPlayer);
	}

	/**
	 * 
	 * @return Sprite image of the player
	 */
	public Image getPlayerSprite() {
		return playerSprite;
	}

	/**
	 * 
	 * @param playerSprite Sprite image of the player 
	 */
	public void setPlayerSprite(Image playerSprite) {
		this.playerSprite = playerSprite;
	}
	
	/**
	 * 
	 * @return get x-coordinate of the player 
	 */
	public int getXPlayer() {
		return xPlayer;
	}
	
	/**
	 * 
	 * @param set x-coordinate of the player
	 */
	public void setXPlayer(int xPlayer) {
		this.xPlayer = xPlayer;
	}

	/**
	 * 
	 * @return get y-coordinate of the player 
	 */
	public int getYPlayer() {
		return yPlayer;
	}

	/**
	 * 
	 * @param set y-coordinate of the player
	 */
	public void setYPlayer(int yPlayer) {
		this.yPlayer = yPlayer;
	}
	
	/**
	 * 
	 * @return get width of the player (sprite) 
	 */
	public int getWidthPlayer() {
		return widthPlayer;
	}
	
	/**
	 * 
	 * @param set width of the player (sprite) 
	 */
	public void setWidthPlayer(int widthPlayer) {
		this.widthPlayer = widthPlayer;
	}

	/**
	 * 
	 * @return get height of the player (sprite) 
	 */
	public int getHeightPlayer() {
		return heightPlayer;
	}

	/**
	 * 
	 * @param set height of the player (sprite) 
	 */
	public void setHeightPlayer(int heightPlayer) {
		this.heightPlayer = heightPlayer;
	}

	/**
	 * 
	 * @return player score
	 */
	public int getScore() {
		return score;
	}
	
	/**
	 * 
	 * @return player score
	 */
	public void setScore(int score) {
		this.score = score;
	}

	public String getFishSpeed() {
		return fishSpeed;
	}

	public void setFishSpeed(String fishSpeed) {
		this.fishSpeed = fishSpeed;
	}

}
