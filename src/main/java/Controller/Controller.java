package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.AbstractMap;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map.Entry;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.Timer;

import Model.Enemy;
import Model.JSonRW;
import Model.Player;
import View.CommonPanel;
import View.Frame;
import View.GamePanel;
import View.HighScorePanel;
import View.MP3;
import View.StartPanel;
import javazoom.jl.decoder.JavaLayerException;

/**
 * 
 * @author Kamran Tadzjibov
 *
 */

public class Controller {

	private Frame viewFrame = new Frame();
	StartPanel startPanel = new StartPanel(viewFrame);
	private MP3 mp3 = new MP3();
	

	/**
	 * @return the startPanel
	 */
	public StartPanel getStartPanel() {
		return startPanel;
	}

	/**
	 * @param startPanel
	 *            the startPanel to set
	 */
	public void setStartPanel(StartPanel startPanel) {
		this.startPanel = startPanel;
	}

	private CommonPanel commonPanel = new CommonPanel(viewFrame);
	private HighScorePanel highPanel = new HighScorePanel(viewFrame);
	private Player p = new Player();
	private GamePanel gamePanel = new GamePanel(p);
	private BufferedImage sprite = (BufferedImage) p.getSprite();
	private Timer t;
	private double score;
	ScheduledExecutorService exec;
	private int difficulty = 5;
	private int gameSpeed = 15;
	private KeyListener kl;

	/**
	 * Constructor to initialize the Controller.
	 * @throws IOException 
	 * @throws UnsupportedAudioFileException 
	 */
	public Controller() throws UnsupportedAudioFileException, IOException {

		init();
		updateFrames();
	}

	/**
	 * Initializing a Game
	 * @throws IOException 
	 * @throws UnsupportedAudioFileException 
	 */
	private void init() throws UnsupportedAudioFileException, IOException {
		exec = Executors.newSingleThreadScheduledExecutor();
		exec.scheduleAtFixedRate(new Runnable() {
		  @Override
		  public void run() {
				mp3.setupPlayer("music/Space.mp3");
				try {
					mp3.getPlayer().play();
				} catch (JavaLayerException e) {
					e.printStackTrace();
				}
		  }
		  
		}, 0, 190, TimeUnit.SECONDS);
		score = p.getScore();
		configureIntructionPanel();
		configureGamePanel();
		configureStartPanel();
		configureHighPanel();
		configureAboutPanel();
		viewFrame.add(gamePanel);
		viewFrame.add(commonPanel);
		viewFrame.add(highPanel);
		viewFrame.add(startPanel);
		Enemy.loadSprites();
		viewFrame.setVisible(true);
		kl = new KeyListener();
		kl.movePlayerKeyListener(p);

		p.setMaxSpeed(7);

	}

	/**
	 * initial configuration of the game panel
	 */
	private void configureGamePanel() {

		gamePanel.setSize(viewFrame.getSize());

		p.setX(viewFrame.getWidth() / 2 - p.getX() / 2);
		p.setY(viewFrame.getHeight() / 2 - p.getY() / 2);
		p.translateBounds(p.getX(), p.getY());
		p.update();

		update();
	}

	/**
	 * initial configuration of the Start panel Adding the menu button
	 * functions.
	 */
	private void configureStartPanel() {
		startPanel.getStartbutt().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				gamePanel.setVisible(true);
				startPanel.setVisible(false);

				t.start();
			}
		});

		startPanel.getHighbutt().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				List<Entry<String, Integer>> highscore = p.getHighscore();
				for (int i = 0; i < highPanel.getTable().getRowCount(); i++) {

					highPanel.getTable().setValueAt(i + 1, i, 0);
					if (i < highscore.size()) {

						highPanel.getTable()
								.setValueAt(highscore.get(i).getKey(), i, 1);
						highPanel.getTable().setValueAt(highscore.get(i).getValue(), i,
								2);

					}
				}
				highPanel.setVisible(true);
				startPanel.setVisible(false);
			}
		});

		startPanel.getAbbutt().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				commonPanel.setC('a');
				commonPanel.setVisible(true);
				startPanel.setVisible(false);
			}
		});
		startPanel.getHelpbutt().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				commonPanel.setC('i');
				commonPanel.setVisible(true);
				startPanel.setVisible(false);
			}
		});

		startPanel.getExbutt().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				viewFrame.dispose();
				exec.shutdown();
				mp3.close();
			}
		});

	}

	/**
	 * Configure the highscore panel to show top scores.
	 */

	private void configureHighPanel() {
		highPanel.setSize(viewFrame.getSize());

		
		highPanel.getBackbutt().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				highPanel.setVisible(false);
				startPanel.setVisible(true);
			}
		});
	}

	/**
	 * Configure About panel and the back button.
	 */

	private void configureAboutPanel() {
		commonPanel.setC('a');
		commonPanel.setSize(viewFrame.getSize());
		commonPanel.getBackbutt().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				commonPanel.setVisible(false);
				startPanel.setVisible(true);
			}
		});
	}

	private void configureIntructionPanel() {
		commonPanel.setC('i');
		commonPanel.setSize(viewFrame.getSize());
		commonPanel.getBackbutt().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				commonPanel.setVisible(false);
				startPanel.setVisible(true);
			}
		});
	}

	/**
	 * Update game state (scores etc.).
	 */
	public void update() {
		score = p.getScore();
		
	}

	/**
	 * Update the frame when the player moves by repainting the scene.
	 */

	public void updateFrames() {
		ActionListener move = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
//				if (p.isDead()) {
//
//				} else {
				gameOver();
					Collision.collide(gamePanel.getEnemies(), p);
					movingHandler();

					if (gamePanel.getEnemies().size() < difficulty) {
						gamePanel.getEnemies().add(Enemy.createEnemy());
					}
					gamePanel.repaint();
					p.speedController();

					gamePanel.setFishSpeed(p.getSpeed() + "/"
							+ p.getRepaintTime() + "  accelerating: "
							+ p.isAccelerating() + " moving: " + p.isMoving()
							+ " dir: " + p.getDir() + " lastDir:"
							+ p.getLastDir());
					// t.setDelay(p.getRepaintTime());
//				}
			}
		};
		t = new Timer(gameSpeed, move);// p.getRepaintTime()
		kl.setT(t);
		
	}

	/**
	 * Handle the direction the player is moving and send to appropriate
	 * function.
	 */

	public void movingHandler() {
		if (p.isMoving()) {
			String dir = "";
			if (p.getDir().equals("")) {
				dir = p.getLastDir();
			} else {
				dir = p.getDir();
			}
			if (dir.contains("left")) {
				p.moveLeft(viewFrame.getWidth());
				p.setBoundsPro(p.getBoundsProLeft());
			}
			if (dir.contains("right")) {
				p.moveRight(viewFrame.getWidth());
				p.setBoundsPro(p.getBoundsProRight());
			}

			if (dir.contains("up")) {
				p.moveUp();
			}
			if (dir.contains("down")) {
				p.moveDown(viewFrame.getHeight());
			}
		}

		int i = 0;
		while (i < gamePanel.getEnemies().size()) {

			moveEnemy(gamePanel.getEnemies().get(i));
			i++;

		}
	}

	public void gameOver(){
		if(p.isDead()){
			t.stop();
			commonPanel.setC('g');
			commonPanel.setScore((int)p.getScore());
			saveScores();
			p.clean();
			gamePanel.getEnemies().removeAll(gamePanel.getEnemies());
			commonPanel.setSize(viewFrame.getSize());
			commonPanel.setVisible(true);
			gamePanel.setVisible(false);
			commonPanel.getBackbutt().addActionListener(new ActionListener(){
				@Override 
				public void actionPerformed(ActionEvent e){
					commonPanel.setVisible(false);
					startPanel.setVisible(true);
//					p.clean();
					gamePanel.getEnemies().clear();
				}
			});
		}
	}
	
	/**
	 * Function to move the enemy and repaint it on the Frame.
	 * 
	 * @param e
	 *            The current enemy you want to move and repaint.
	 */
	private void moveEnemy(Enemy e) {
		if (e.isToLeft()) {
			e.setX(e.getX() - e.getSpeed());
			e.setBoundsPro(e.getBoundsProLeft());
		} else {
			e.setX(e.getX() + e.getSpeed());
			e.setBoundsPro(e.getBoundsProRight());
		}
			e.translateBounds(e.getX(), e.getY());

		if (e.getX() > Frame.getFrameWidth() + 10
				|| e.getX() < -e.getWidth() - 10) {

			gamePanel.getEnemies().remove(e);
		}
		e.getBoundary().setFrame(e.getX(), e.getY(), e.getWidth(),
				e.getHeight());
	}
	
	public void saveScores(){
		String gangstaName;
		try
		{
		    InetAddress addr;
		    addr = InetAddress.getLocalHost();
		    gangstaName = addr.getHostName();
		}
		catch (UnknownHostException ex)
		{
			gangstaName = "Anonymous";
		    System.out.println("Hostname can not be resolved");
		}
		p.getHighscore().add(new AbstractMap.SimpleEntry<String, Integer>(
				gangstaName, (int)p.getScore()));
		
		Collections.sort(p.getHighscore(), new Comparator<Entry<String, Integer>>() {
			@Override
			public int compare(Entry<String, Integer> x,
					Entry<String, Integer> y) {

				return y.getValue() - x.getValue();
			}
		});
		JSonRW.writer(p.getHighscore());
	}

}
