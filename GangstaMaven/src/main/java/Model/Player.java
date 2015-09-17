package Model;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map.Entry;

import javax.imageio.ImageIO;

import View.Frame;

/**
 * 
 * @author Kamran Tadzjibov
 *
 */

public class Player extends Unit {

	private List<Entry<String, Integer>> highscore;
	private double score = 0, acceleration = 0.2;

	private boolean moving = false, accelerating = false;
	private int maxSpeed = 7;
	private String dir = "", lastDir = "";
	private boolean isDead = false;
	private BufferedImage spriteLeft;
	private BufferedImage spriteRight;
	private BufferedImage spriteFinal;
	private Logger NOTICELOGGER = new NoticeLogger();

	/**
	 * Constructor for the player.
	 */
	public Player() {
		highscore = JSonRW.readDatabase();
		getBoundsProLeft().setPolygon( JSonRW.readBoundaries("gangsta").getKey());
		getBoundsProRight().setPolygon( JSonRW.readBoundaries("gangsta").getValue());
//		System.out.println("Player: width, npoints"+getBoundsPro().getWidth() + " " + getBoundsPro().npoints);
		
//		getBoundsPro().translate(x, y);
//		System.out.println("Player: x,y = " + getBoundsPro().getX() + ", " + getBoundsPro().getY());
		
//		getBoundsPro().scaleTo(300, 300);
//		getBoundsPro().scaleTo(50, 50);
//		getBoundsPro().scaleTo(70, 70);
//		
		
		try {
			sprite = ImageIO.read(new File("img/gangsta.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		spriteLeft = ((BufferedImage) sprite).getSubimage(0, 0, sprite.getWidth(null)/2, sprite.getHeight(null));
		spriteRight = ((BufferedImage) sprite).getSubimage(sprite.getWidth(null)/2, 0, sprite.getWidth(null)/2, sprite.getHeight(null));
		spriteFinal = spriteLeft;
		update();
	}

	/**
	 * Set the speed at which the player can move.
	 */

	public void speedController() {
		if (accelerating && speed < maxSpeed) {
			setSpeed(speed + acceleration);
		} else if (!accelerating && speed > 1) {
			setSpeed(speed - acceleration);
		}

		if (speed <= 1.0 && dir.equals("")) {
			moving = false;
			speed = 1;
			moveDown(Frame.getFrameHeight());
		}
	}

	/**
	 * Set the direction the player is moving to.
	 * 
	 * @param dir
	 *            The direction the player is moving to.
	 */
	public void setMovingDirection(String dir) {
		moving = true;
		this.dir = dir;

		if (!dir.equals("")) {
			lastDir = dir;
			accelerating = true;
		} else {
			accelerating = false;
		}
	}

	/**
	 * configure the move left action.
	 * 
	 * @param fWidth
	 *            distance the player has moved.
	 */

	public void moveLeft(int fWidth) {
		NOTICELOGGER.message("player moved left", Logger.NOTICE);
		if (x < -width) {
			x = fWidth;
		}
		x -= speed;
		spriteFinal = spriteLeft;
		boundary.setFrame(x, y, width, height);
		translateBounds(x, y);
		
		
	}

	/**
	 * configure the move right action.
	 * 
	 * @param fWidth
	 *            distance the player has moved.
	 */

	public void moveRight(int fWidth) {
		NOTICELOGGER.message("player moved right", Logger.NOTICE);
		if (x > fWidth) {
			x = -width;
		}
		x += speed;
		spriteFinal = spriteRight;
		boundary.setFrame(x, y, width, height);
		translateBounds(x, y);
	}

	/**
	 * configure the move up action.
	 */

	public void moveUp() {
		NOTICELOGGER.message("player moved up", Logger.NOTICE);
		if (y > 0) {
			y -= speed;
			boundary.setFrame(x, y, width, height);
			translateBounds(x, y);
		}

	}

	/**
	 * configure the move down action.
	 * 
	 * @param fWidth
	 *            distance the player has moved.
	 */

	public void moveDown(int fHeight) {
		NOTICELOGGER.message("player moved down", Logger.NOTICE);
		if (y < fHeight - height - 30) {
			y += speed;
			boundary.setFrame(x, y, width, height);
			translateBounds(x, y);			
		}
	}

	/**
	 * update the width and the height of the player with corresponding
	 * boundaries.
	 */
	public void update() {
		if (width < 500 && height < 500) {
			width = (int) (score + 75);
			height = (int) (score + 75);
		}
		boundary.setFrame(x, y, width, height);
//		System.out.println(spriteFinal.getWidth() + " " + spriteFinal.getHeight());
		scaleBounds(width, height);//-(int)(width*0.07)
	}

	
	public void clean(){
		score = 0;
		acceleration = 0.2;
		moving = false;
		accelerating = false;
		maxSpeed = 7;
		dir = "";
		lastDir = "";
		isDead = false;
		width = (int) (score + 75);
		height = (int) (score + 75);
		x = Frame.getFrameWidth() / 2 - width / 2;
		y = Frame.getFrameHeight() / 2 - width / 2;
		boundary.setFrame(x, y, width, height);
	}
	
	/**
	 * get score of player.
	 * 
	 * @return score of the player.
	 */

	public double getScore() {
		return score;
	}

	/**
	 * Set the score of the player.
	 * 
	 * @param score
	 *            new score of the player.
	 */
	public void setScore(double score) {
		NOTICELOGGER.message("player scored: " + score + " points", Logger.NOTICE);
		this.score = score;
	}

	/**
	 * determine if the player is moving.
	 * 
	 * @return true if player is moving, false if still.
	 */
	public boolean isMoving() {
		return moving;
	}

	/**
	 * Set if player is moving.
	 * 
	 * @param moving
	 *            true if for moving, false if not.
	 */
	public void setMoving(boolean moving) {
		this.moving = moving;
	}

	/**
	 * check if the player has stopped.
	 */
	public boolean isStop() {
		return stop;
	}

	/**
	 * Set that the player has stopped.
	 */
	public void setStop(boolean stop) {
		this.stop = stop;
	}

	/**
	 * Get the direction the player is moving.
	 * 
	 * @return direction the player facing.
	 */
	public String getDir() {
		return dir;
	}

	/**
	 * 
	 * @return Return the previous direction player was facing.
	 */
	public String getLastDir() {
		return lastDir;
	}

	/**
	 * 
	 * @return true if the player is accelerating.
	 */
	public boolean isAccelerating() {
		return accelerating;
	}

	/**
	 * Set if the player is accelerating.
	 * 
	 * @param accelerating
	 *            true if accelerating, false if not.
	 */
	public void setAccelerating(boolean accelerating) {
		this.accelerating = accelerating;
	}

	/**
	 * Get max speed of the player.
	 * 
	 * @return return max speed.
	 */
	public int getMaxSpeed() {
		return maxSpeed;
	}

	/**
	 * set the max speed of the player.
	 * 
	 * @param maxSpeed
	 *            maxspeed to be set.
	 */
	public void setMaxSpeed(int maxSpeed) {
		if (maxSpeed <= 20)
			this.maxSpeed = maxSpeed;
	}

	/**
	 * Determine if the player is dead.
	 * 
	 * @return true if the player is eaten.
	 */

	public boolean isDead() {
		return this.isDead;
	}

	/**
	 * set that the player is dead.
	 * 
	 * @param isDead
	 *            true if the player is eaten, false if not.
	 */

	public void setDead(boolean isDead) {
		this.isDead = isDead;
	}

	/**
	 * Return left facing sprite of the player.
	 * 
	 * @return leftsprite.
	 */
	public BufferedImage getSpriteLeft() {
		return spriteLeft;
	}

	/**
	 * Return right facing sprite.
	 * 
	 * @return right sprite.
	 */
	public BufferedImage getSpriteRight() {
		return spriteRight;
	}

	/**
	 * A list of player names and highscores.
	 * 
	 * @return list of highscores and names.
	 */
	public List<Entry<String, Integer>> getHighscore() {
		return highscore;
	}

	/**
	 * return the final image of the sprite.
	 * 
	 * @return final sprite.
	 */
	public BufferedImage getSpriteFinal() {
		return spriteFinal;
	}

	/**
	 * set the final image of the sprite.
	 * 
	 * @param spriteFinal
	 *            final image to be set.
	 */
	public void setSpriteFinal(BufferedImage spriteFinal) {
		this.spriteFinal = spriteFinal;
	}
}
