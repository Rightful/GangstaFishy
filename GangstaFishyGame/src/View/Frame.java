package View;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * 
 * @author Kamran Tadzjibov
 *
 * Actual game window
 */

@SuppressWarnings("serial")
public class Frame extends JFrame{
	 
	private GamePanel gamePanel;


	/**
	 * screen width and height
	 */
	private static int frameWidth = 800;
	private static int frameHeight = 600;
	
	public Frame(){
	    setSize(frameWidth,frameHeight);    
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2-15);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Fishy Game - Group 36");  
	}

	
	
	/**
	 * @return the frameWidth
	 */
	public static int getFrameWidth() {
		return frameWidth;
	}

	/**
	 * @return the frameHeight
	 */
	public static int getFrameHeight() {
		return frameHeight;
	}

	
	/**
	 * @return the gamePanel
	 */
	public JPanel getGamePanel() {
		return gamePanel;
	}		

	public void setGamePanel(GamePanel gamePanel) {
		this.gamePanel = gamePanel;
	}
}
