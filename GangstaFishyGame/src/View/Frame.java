package View;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * 
 * @author Kamran Tadzjibov
 *
 */

public class Frame extends JFrame{
	 
	private GamePanel gamePanel;


	/**
	 * scherm breedte en hoogte
	 */
	private static int frameWidth = 800;//(int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();//1000;//
	private static int frameHeight = 600;//(int) Toolkit.getDefaultToolkit().getScreenSize().getHeight()-30;//600;//
	
	
	
	public Frame(){
		//setUndecorated(true);
	    setSize(frameWidth,frameHeight);    
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2-15);
//	    setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Fishy Game - Group 36");  

//		gamePanel = new GamePanel();
	    //gamePanel.setLayout(new BorderLayout());
//	    gamePanel.setSize(this.getSize());
	    //gamePanel.setBackground(Color.red);
	    //add(gamePanel);
	    
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
