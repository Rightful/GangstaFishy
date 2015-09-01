package Controller;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import javax.swing.Timer;

import Model.Player;
import View.Frame;
import View.GamePanel;

/**
 * 
 * @author Kamran Tadzjibov
 *
 */

public class Controller {
	
	Frame viewFrame = new Frame();
	GamePanel gamePanel = new GamePanel();
	Player p = new Player();
	BufferedImage sprite = (BufferedImage) p.getSprite();
	
	private double score = 1;
	private double left = 0;
	private double right = 0;
	private double up = 0;
	private double down = 0;
	private double inertiaStep = 0.8;
	private boolean leftPressed, rightPressed, upPressed, downPressed;
	
	public Controller(){
		init();
		movePlayer();
	}
	
	/**
	 * Initializing a Game
	 */
	private void init(){
		configureGamePanel();
		viewFrame.setGamePanel(gamePanel);
		viewFrame.add(gamePanel);
		
		viewFrame.setVisible(true);
	}
	
	/**
	 * initial configuration of the game panel
	 */
	private void configureGamePanel(){
		
		gamePanel.setSize(viewFrame.getSize());
		gamePanel.setWidthPlayer((int)(1703/15*score));
		gamePanel.setHeightPlayer((int)(1672/15*score));
		gamePanel.setXPlayer(viewFrame.getWidth()/2-gamePanel.getWidthPlayer()/2);
		gamePanel.setYPlayer(viewFrame.getHeight()/2-gamePanel.getHeightPlayer()/2);
		
		gamePanel.setPlayerSprite(sprite.getSubimage(0, 0, 1703, 1672));
		
		update();
	}
	
	/**
	 * update game state (scores etc.)
	 */
	public void update(){
		gamePanel.setScore((int)(score*10-10));
	}
	
	
	public void movePlayerKeyListener(){
		KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(new KeyEventDispatcher() {

            @Override
            public boolean dispatchKeyEvent(KeyEvent ke) {
            	if(ke.getID() == KeyEvent.KEY_PRESSED){
	                    switch (ke.getKeyCode()) {
	                    case KeyEvent.VK_LEFT:
	                    	leftPressed = true;
	                        break;
	                    case KeyEvent.VK_RIGHT:
	                    	rightPressed = true;
	                        break;
	                    case KeyEvent.VK_UP:
	                    	upPressed = true;
	                        break;
	                    case KeyEvent.VK_DOWN:
	                    	downPressed = true;
	                        break;
	                    }
	                    
//	                    gamePanel.repaint();
	              }
            	if(ke.getID() == KeyEvent.KEY_RELEASED){
                    switch (ke.getKeyCode()) {
                    case KeyEvent.VK_LEFT:
                    	leftPressed = false;
                        break;
                    case KeyEvent.VK_RIGHT:
                    	rightPressed = false;
                        break;
                    case KeyEvent.VK_UP:
                    	upPressed = false;
                        break;
                    case KeyEvent.VK_DOWN:
                    	downPressed = false;
                        break;
                    } 
            	}
//            	
//            	movePlayer();
                return false;
            }
            
        });
	}
	
	public void movePlayer(){
		movePlayerKeyListener();
		ActionListener move = new ActionListener() {
	         @Override
	         public void actionPerformed(ActionEvent evt) {
	        	 increaseMoveCredits();
	        	 moveIfEnoughCredits();
	     		
	     		gamePanel.repaint();
	         }
	      };
	      Timer t =  new Timer(50, move);
	      t.start();
	}
	
	private void increaseMoveCredits(){
		if(leftPressed)
			left += 1;
		if(rightPressed)
			right += 1;
		if(upPressed)
			up += 1;
		if(downPressed)
			down += 1;
	}
	private void moveIfEnoughCredits(){
		if(left > 0){
 			moveLeft();
 		}
 		if(right > 0){
 			moveRight();
 		}
 		if(up > 0){
 			moveUp();
 		}
 		if(down > 0){
 			moveDown();
 		}
	}
	
	private void moveLeft(){
		if(gamePanel.getXPlayer()>0){
    		gamePanel.setXPlayer(gamePanel.getXPlayer()-5);
    		gamePanel.setPlayerSprite(sprite.getSubimage(0, 0, 1703, 1672));
 			left -= inertiaStep;
    	}
	}
	
	private void moveRight(){
		if(gamePanel.getXPlayer()<(viewFrame.getWidth() - gamePanel.getWidthPlayer()-10)){
    		gamePanel.setXPlayer(gamePanel.getXPlayer()+5);
    		gamePanel.setPlayerSprite(sprite.getSubimage(1703, 0, 1703, 1672));
 			right -= inertiaStep;
    	}
	}
	
	private void moveUp(){
		if(gamePanel.getYPlayer()>0){
    		gamePanel.setYPlayer(gamePanel.getYPlayer()-5);
 			up -= inertiaStep;
    	}
	}
	
	private void moveDown(){
		if(gamePanel.getYPlayer()<(viewFrame.getHeight() - gamePanel.getHeightPlayer()-30)){
    		gamePanel.setYPlayer(gamePanel.getYPlayer()+5);
 			down -= inertiaStep;
    	}
	}
}
