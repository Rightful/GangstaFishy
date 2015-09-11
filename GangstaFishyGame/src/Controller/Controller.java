package Controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.List;
import java.util.Map.Entry;

import javax.swing.Timer;

import Model.Enemy;
import Model.JSonRW;
import Model.Player;
import View.AboutPanel;
import View.Frame;
import View.GamePanel;
import View.HighScorePanel;
import View.Sound;
import View.StartPanel;
/**
 * 
 * @author Kamran Tadzjibov
 *
 */

public class Controller {
	
	private Frame viewFrame = new Frame();
	StartPanel startPanel = new StartPanel(viewFrame);
	/**
	 * @return the startPanel
	 */
	public StartPanel getStartPanel() {
		return startPanel;
	}

	/**
	 * @param startPanel the startPanel to set
	 */
	public void setStartPanel(StartPanel startPanel) {
		this.startPanel = startPanel;
	}

	private AboutPanel aboutPanel = new AboutPanel(viewFrame);
	private HighScorePanel highPanel = new HighScorePanel(viewFrame);
	private Player p = new Player();
	private GamePanel gamePanel = new GamePanel(p);
	private BufferedImage sprite = (BufferedImage) p.getSprite();
	private Timer t;
	private double score;
	private int difficulty = 5;//easy
	private int gameSpeed = 15;//easy
	
	public Controller(){
		init();
		movePlayer();
	}
	
	/**
	 * Initializing a Game
	 */
	private void init(){
		Sound.playSound("sound/Thug_Life_Music.wav");
		score = p.getScore();
		configureGamePanel();
		configureStartPanel();
		configureHighPanel();
		configureAboutPanel();
		viewFrame.add(gamePanel);
		viewFrame.add(aboutPanel);
		viewFrame.add(highPanel);
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
//		gamePanel.setWidthPlayer((int)(1703/15*score));
//		gamePanel.setHeightPlayer((int)(1672/15*score));
//		gamePanel.setXPlayer(viewFrame.getWidth()/2-gamePanel.getWidthPlayer()/2);
//		gamePanel.setYPlayer(viewFrame.getHeight()/2-gamePanel.getHeightPlayer()/2);
		
		p.setX(viewFrame.getWidth()/2-p.getX()/2);
		p.setY(viewFrame.getHeight()/2-p.getY()/2);
		p.update();

	//	gamePanel.setPlayerSprite(sprite.getSubimage(0, 0, 1703, 1672));
		
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
		
		startPanel.getHighbutt().addActionListener(new ActionListener(){

			@Override 
			public void actionPerformed(ActionEvent e){
				highPanel.setVisible(true);
				startPanel.setVisible(false);
			}
		});

		startPanel.getAbbutt().addActionListener(new ActionListener(){

			@Override 
			public void actionPerformed(ActionEvent e){
				aboutPanel.setVisible(true);
				startPanel.setVisible(false);
			}
		});

		startPanel.getExbutt().addActionListener(new ActionListener(){
			@Override 
			public void actionPerformed(ActionEvent e){
			viewFrame.dispose();
			}
		});
		
	}
	
	private void configureHighPanel(){
		highPanel.setSize(viewFrame.getSize());
		
		List<Entry<String, Integer>> highscore = p.getHighscore();
		for(int i = 0; i< highPanel.getTable().getRowCount(); i++){

			highPanel.getTable().setValueAt(i+1, i, 0);
			if(i<highscore.size()){
				highPanel.getTable().setValueAt(highscore.get(i).getKey(), i, 1);
				highPanel.getTable().setValueAt(highscore.get(i).getValue(), i, 2);
			}
		}
		highPanel.getBackbutt().addActionListener(new ActionListener(){
			@Override 
			public void actionPerformed(ActionEvent e){
				highPanel.setVisible(false);
				startPanel.setVisible(true);				
			}
		});
	}

	private void configureAboutPanel(){
		aboutPanel.setSize(viewFrame.getSize());
		aboutPanel.getBackbutt().addActionListener(new ActionListener(){
			@Override 
			public void actionPerformed(ActionEvent e){
				aboutPanel.setVisible(false);
				startPanel.setVisible(true);
			}
		});
	}

	/**
	 * update game state (scores etc.)
	 */
	public void update(){
		score = p.getScore();
		//gamePanel.setScore((int)(score*10-10));
	}
	
	//Opmerking: Functies moeten doen wat de naam zegt. Deze functie doet te veel. 
	//De structuur van de Controller en van het spel is onoverzichtelijk en moet verbeterd worden.  
	
	public void movePlayer(){
		ActionListener move = new ActionListener() {
	         @Override
	         public void actionPerformed(ActionEvent evt) {
	        	Collision.collide(gamePanel.getEnemies(), p);
	        	movingHandler();
	        	 
	        	if(gamePanel.getEnemies().size()<difficulty){
	        		gamePanel.getEnemies().add(Enemy.createEnemy());
	        	}
	     		gamePanel.repaint();
	     		p.speedController();
	     		gamePanel.setFishSpeed(p.getSpeed() + "/"+p.getRepaintTime() + "  accelerating: "+p.isAccelerating() + " moving: "+p.isMoving() + " dir: "+p.getDir() + " lastDir:"+p.getLastDir());
//	     		t.setDelay(p.getRepaintTime());
	         }
	      };
	      t =  new Timer(gameSpeed, move);//p.getRepaintTime()
	      
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
				p.moveLeft(viewFrame.getWidth());
			}
			if(dir.contains("right")){
				p.moveRight(viewFrame.getWidth());
			}
			
			if(dir.contains("up")){
				p.moveUp();
			}
			if(dir.contains("down")){
				p.moveDown(viewFrame.getHeight());
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
		e.getBoundary().setFrame(e.getX(), e.getY(), e.getWidth(), e.getHeight());
	}
	
}
