package Controller;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

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
	
	public Controller(){
		init();
		movePlayer();
	}
	
	private void init(){
		configureGamePnale();
		viewFrame.setGamePanel(gamePanel);
		viewFrame.add(gamePanel);
		
		viewFrame.setVisible(true);
	}
	
	private void configureGamePnale(){
		
		gamePanel.setSize(viewFrame.getSize());
		gamePanel.setWidthPlayer((int)(1703/15*score));
		gamePanel.setHeightPlayer((int)(1672/15*score));
		gamePanel.setXPlayer(viewFrame.getWidth()/2-gamePanel.getWidthPlayer()/2);
		gamePanel.setYPlayer(viewFrame.getHeight()/2-gamePanel.getHeightPlayer()/2);
		
		gamePanel.setPlayerSprite(sprite.getSubimage(0, 0, 1703, 1672));
		
		update();
	}
	
	
	public void update(){
		gamePanel.setScore((int)(score*10-10));
	}
	
	public void movePlayer(){
		KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(new KeyEventDispatcher() {

            @Override
            public boolean dispatchKeyEvent(KeyEvent ke) {
            	if(ke.getID() == KeyEvent.KEY_PRESSED){
	                    switch (ke.getKeyCode()) {
	                    case KeyEvent.VK_LEFT:
	                    	if(gamePanel.getXPlayer()>0){
	                    		gamePanel.setXPlayer(gamePanel.getXPlayer()-5);
	                    		gamePanel.setPlayerSprite(sprite.getSubimage(0, 0, 1703, 1672));
	                    	}
	                        break;
	                    case KeyEvent.VK_RIGHT:
	                    	if(gamePanel.getXPlayer()<(viewFrame.getWidth() - gamePanel.getWidthPlayer()-10)){
	                    		gamePanel.setXPlayer(gamePanel.getXPlayer()+5);
	                    		gamePanel.setPlayerSprite(sprite.getSubimage(1703, 0, 1703, 1672));
	                    	}
	                        break;
	                    case KeyEvent.VK_UP:
	                    	if(gamePanel.getYPlayer()>0){
	                    		gamePanel.setYPlayer(gamePanel.getYPlayer()-5);
	                    	}
	                        break;
	                    case KeyEvent.VK_DOWN:
	                    	if(gamePanel.getYPlayer()<(viewFrame.getHeight() - gamePanel.getHeightPlayer()-30)){
	                    		gamePanel.setYPlayer(gamePanel.getYPlayer()+5);
	                    	}
	                        break;
	                    }
	                    
	                    gamePanel.repaint();
	                    
	                }
                   return false;
            
            }
            
        });
	}
}
