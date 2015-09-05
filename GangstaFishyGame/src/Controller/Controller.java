package Controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.Timer;

import Model.Player;
import View.Frame;
import View.GamePanel;
import View.StartPanel;

/**
 * 
 * @author Kamran Tadzjibov
 *
 */

public class Controller {
	
	private Frame viewFrame = new Frame();
	private StartPanel startPanel = new StartPanel(viewFrame);
	private GamePanel gamePanel = new GamePanel();
	private Player p = new Player();
	private BufferedImage sprite = (BufferedImage) p.getSprite();
	private Timer t;
	private double score = 1;
	
	public Controller(){
		init();
		movePlayer();
	}
	
	/**
	 * Initializing a Game
	 */
	private void init(){
		configureGamePanel();
		configureStartPanel();
		viewFrame.add(gamePanel);
		viewFrame.add(startPanel);	
		
		viewFrame.setVisible(true);
		
		p.setMaxSpeed(7);
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
	 * initial configuration of the game panel
	 */
	private void configureStartPanel(){
		startPanel.getStartbutt().addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				gamePanel.setVisible(true);
				startPanel.setVisible(false);
			}
			
		});
		
	}
	
	
	/**
	 * update game state (scores etc.)
	 */
	public void update(){
		gamePanel.setScore((int)(score*10-10));
	}
	
	public void movePlayer(){
		KeyListener kl = new KeyListener();
		kl.movePlayerKeyListener(p);
		ActionListener move = new ActionListener() {
	         @Override
	         public void actionPerformed(ActionEvent evt) {
	        	movingHandler();
	        	 
	     		gamePanel.repaint();
	     		p.speedController();
	     		gamePanel.setFishSpeed(p.getSpeed() + "/"+p.getRepaintTime() + "  accelerating: "+p.isAccelerating() + " moving: "+p.isMoving() + " dir: "+p.getDir() + " lastDir:"+p.getLastDir());
	     		t.setDelay(p.getRepaintTime());
	         }
	      };
	      t =  new Timer(p.getRepaintTime(), move);
	      t.start();
	}
	
	public void movingHandler(){
		if(p.isMoving()){
			String dir = "";
			if(p.getDir().equals("")){
				dir = p.getLastDir();
			}else{
				dir = p.getDir();
			}
			if(dir.contains("left")){
				moveLeft();
			}
			if(dir.contains("right")){
				moveRight();
			}
			
			if(dir.contains("up")){
				moveUp();
			}
			if(dir.contains("down")){
				moveDown();
			}
		}
	}
	
	private void moveLeft(){
		if(gamePanel.getXPlayer() < -gamePanel.getWidthPlayer()){
			gamePanel.setXPlayer(viewFrame.getWidth());
    	}
		gamePanel.setXPlayer(gamePanel.getXPlayer()-p.getSpeed());
		gamePanel.setPlayerSprite(sprite.getSubimage(0, 0, 1703, 1672));
	}
	
	private void moveRight(){
		if(gamePanel.getXPlayer()>(viewFrame.getWidth())){
			gamePanel.setXPlayer(-gamePanel.getWidthPlayer());
		}
    	gamePanel.setXPlayer(gamePanel.getXPlayer()+p.getSpeed());
    	gamePanel.setPlayerSprite(sprite.getSubimage(1703, 0, 1703, 1672));    	
	}
	
	private void moveUp(){
		if(gamePanel.getYPlayer()>0){
    		gamePanel.setYPlayer(gamePanel.getYPlayer()-p.getSpeed());
    	}
	}
	
	private void moveDown(){
		if(gamePanel.getYPlayer()<(viewFrame.getHeight() - gamePanel.getHeightPlayer()-30)){
    		gamePanel.setYPlayer(gamePanel.getYPlayer()+p.getSpeed());
    	}
	}
}
