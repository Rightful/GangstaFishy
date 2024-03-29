package Model;

import java.awt.Image;
import java.awt.Polygon;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Random;

import javax.imageio.ImageIO;

import View.Frame;

/**
 * enemy fishes of the game.
 * 
 * @author Kamran
 *
 */
public class Enemy extends Unit {

	private static List<Entry<Polygon, Polygon>> boundsList = new ArrayList<Entry<Polygon, Polygon>>();
	private static List<Image> sprites = new ArrayList<Image>();
	private BufferedImage animSprite;
	private static Random generator = new Random();
	private boolean toLeft = false;

	/**
	 * Load all sprites only once and reuse them
	 */
	public static void loadSprites() {
		boundsList.add(JSonRW.readBoundaries("yellowpiranha.png"));
		boundsList.add(JSonRW.readBoundaries("yellow.png"));
		boundsList.add(JSonRW.readBoundaries("Brown.png"));
		boundsList.add(JSonRW.readBoundaries("bluepiranha.png"));
		boundsList.add(JSonRW.readBoundaries("redpiranha.png"));
		
		try {
			sprites.add(ImageIO.read(new File("img/yellowpiranha.png")));
			sprites.add(ImageIO.read(new File("img/yellow.png")));
			sprites.add(ImageIO.read(new File("img/Brown.png")));
			sprites.add(ImageIO.read(new File("img/bluepiranha.png")));
			sprites.add(ImageIO.read(new File("img/redpiranha.png")));

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Enemy creator method
	 */
	public static Enemy createEnemy() {
		Enemy e = new Enemy();
		int enemyIdx = generator.nextInt(sprites.size());
		e.setSprite(sprites.get(enemyIdx));
		e.setWidth(generator.nextInt(200) + 50);
		e.setHeight(e.getSprite().getHeight(null) * e.getWidth() * 2 / e.getSprite().getWidth(null));
		if (generator.nextBoolean()) {
			e.generateRightEnemy(e);
		} else {
			e.generateLeftEnemy(e);
		}
		e.setEnemyBounds(enemyIdx); 
		e.setY(generator.nextInt(Frame.getFrameHeight()-e.getHeight()));
		e.translateBounds(e.getX(), e.getY());
		e.scaleBounds(e.width,e.height);
		e.setSpeed(generator.nextInt(5) + 1);
		return e;
	}

	/**
	 * Generate the direction the enemy is facing
	 */
	public void generateRightEnemy(Enemy e) {
		e.setX(-e.getWidth());
		e.setAnimSprite(((BufferedImage) e.getSprite()).getSubimage(e.getSprite().getWidth(null) / 2, 0,
				e.getSprite().getWidth(null) / 2, e.getSprite().getHeight(null)));
		e.setBoundsPro(e.getBoundsProRight());
	}

	/**
	 * Generate a left facing enemy
	 */
	public void generateLeftEnemy(Enemy e) {
		e.setX(Frame.getFrameWidth());
		e.setAnimSprite(((BufferedImage) e.getSprite()).getSubimage(0, 0, e.getSprite().getWidth(null) / 2,

		e.getSprite().getHeight(null)));
		e.setToLeft(true);
		e.setBoundsPro(e.getBoundsProLeft());
	}
	
	/**
	 * Generate the direction the enemy is facing
	 */
	private void setEnemyBounds(int i) {
		getBoundsProLeft().setPolygon(boundsList.get(i).getKey());
		getBoundsProRight().setPolygon(boundsList.get(i).getValue());
	}


	/**
	 * Check whether the enemy is facing left.
	 * 
	 * @return true if the enemy is set to look left, false if the enemy looks
	 *         right.
	 */

	public boolean isToLeft() {
		return toLeft;
	}

	/**
	 * Set the direction the enemy is looking to.
	 * 
	 * @param toLeft
	 *            true if the enemy is set to look left, false if the enemy
	 *            looks right.
	 */
	public void setToLeft(boolean toLeft) {
		this.toLeft = toLeft;
	}

	/**
	 * the image of the enemy.
	 * 
	 * @return image of the enemy.
	 */
	public BufferedImage getAnimSprite() {
		return animSprite;
	}

	/**
	 * set what image to use for the enemy image.
	 * 
	 * @param animSprite
	 *            image to set for use.
	 */
	public void setAnimSprite(BufferedImage animSprite) {
		this.animSprite = animSprite;
	}
	/**
	 * Returns the list of sprites
	 * @return sprites
	 */
	public static List<Image> getSprites() {
		return sprites;
	}


}
