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
 */

public class GamePanel extends JPanel{
	
	private Image playerSprite; 
	private Image bgImage;
	private int xPlayer, yPlayer, widthPlayer, heightPlayer, score;
	
	public GamePanel(){
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
		g.setFont (new Font ("Calibri", Font.BOLD , 30));
		g.setColor(Color.white);
		g.drawString("Score: " + score, 30, 30);
		
		// Collision Boundary will use later
		g.drawOval(xPlayer, yPlayer, widthPlayer, heightPlayer);
	}

	
	public Image getPlayerSprite() {
		return playerSprite;
	}

	public void setPlayerSprite(Image playerSprite) {
		this.playerSprite = playerSprite;
	}

	public int getXPlayer() {
		return xPlayer;
	}

	public void setXPlayer(int xPlayer) {
		this.xPlayer = xPlayer;
	}

	public int getYPlayer() {
		return yPlayer;
	}

	public void setYPlayer(int yPlayer) {
		this.yPlayer = yPlayer;
	}

	public int getWidthPlayer() {
		return widthPlayer;
	}

	public void setWidthPlayer(int widthPlayer) {
		this.widthPlayer = widthPlayer;
	}

	public int getHeightPlayer() {
		return heightPlayer;
	}

	public void setHeightPlayer(int heightPlayer) {
		this.heightPlayer = heightPlayer;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

}
