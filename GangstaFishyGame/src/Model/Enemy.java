package Model;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
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

	private static List<Image> sprites = new ArrayList<Image>();
	private BufferedImage animSprite;
	private static Random generator = new Random();
	private boolean toLeft = false;

	/**
	 * Load all sprites only once and reuse them
	 */
	public static void loadSprites() {
		try {
			sprites.add(ImageIO.read(new File("img/enemy1.png")));
			sprites.add(ImageIO.read(new File("img/rwina.png")));
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
		e.setSprite(sprites.get(generator.nextInt(sprites.size())));
		e.setWidth(generator.nextInt(200) + 50);

		e.setHeight(e.getSprite().getHeight(null) * e.getWidth() * 2
				/ e.getSprite().getWidth(null));

		if (generator.nextBoolean()) {
			e.setX(-e.getWidth());
			e.setAnimSprite(((BufferedImage) e.getSprite()).getSubimage(e
					.getSprite().getWidth(null) / 2, 0,
					e.getSprite().getWidth(null) / 2,
					e.getSprite().getHeight(null)));
		} else {
			e.setX(Frame.getFrameWidth());
			e.setAnimSprite(((BufferedImage) e.getSprite()).getSubimage(0, 0, e
					.getSprite().getWidth(null) / 2,

			e.getSprite().getHeight(null)));
			e.setToLeft(true);
		}
		e.setY(generator.nextInt(Frame.getFrameHeight()));

		e.setSpeed(generator.nextInt(5) + 1);

		return e;
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

}
