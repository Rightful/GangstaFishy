package Controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.Timer;

import Model.Enemy;
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
	private double score;
	
	public Controller(){
		init();
		movePlayer();
	}
	
	/**
	 * Initializing a Game
	 */
	private void init(){
		score = p.getScore();
		configureGamePanel();
		configureStartPanel();
		viewFrame.add(gamePanel);
		viewFrame.add(startPanel);
		
		Enemy.loadSprites();	
		
		viewFrame.setVisible(true);

		KeyListener kl = new KeyListener();
		kl.movePlayerKeyListener(p);
		
		//temp
		p.setMaxSpeed(7);
//		Enemy e = new Enemy();
//		e.createEnemy1();
//		gamePanel.getEnemies().add(Enemy.createEnemy1());
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
				//start animation
				t.start();
			}
			
		});
		
	}
	
	
	/**
	 * update game state (scores etc.)
	 */
	public void update(){
		score = p.getScore();
		gamePanel.setScore((int)(score*10-10));
	}
	
	public void movePlayer(){
		ActionListener move = new ActionListener() {
	         @Override
	         public void actionPerformed(ActionEvent evt) {
	        	movingHandler();
	        	 
	        	if(gamePanel.getEnemies().size()<5){
	        		gamePanel.getEnemies().add(Enemy.createEnemy());
	        	}
	        	
	     		gamePanel.repaint();
	     		p.speedController();
	     		gamePanel.setFishSpeed(p.getSpeed() + "/"+p.getRepaintTime() + "  accelerating: "+p.isAccelerating() + " moving: "+p.isMoving() + " dir: "+p.getDir() + " lastDir:"+p.getLastDir());
//	     		t.setDelay(p.getRepaintTime());
	         }
	      };
	      t =  new Timer(15, move);//p.getRepaintTime()
	      
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
		
		int i = 0;
		while(i<gamePanel.getEnemies().size()){
//		for(Enemy e: gamePanel.getEnemies()){
			moveEnemy(gamePanel.getEnemies().get(i));
			i++;
			
		}
	}
	
	private void moveEnemy(Enemy e){
		if(e.isToLeft()){
			e.setX(e.getX() - e.getSpeed());
		}else{
			e.setX(e.getX() + e.getSpeed());
		}
		if(e.getX()>Frame.getFrameWidth()+10 || e.getX()<-e.getWidth()-10){
			gamePanel.getEnemies().remove(e);
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
