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

public class Enemy extends Unit{
	
	private static List<Image> sprites = new ArrayList<Image>();
	private BufferedImage animSprite;
	private static Random generator = new Random();
	private boolean toLeft = false;
//	private double speed = 10, repaintTime = 10;
	
	

	/**
	 *  Load all sprites only once and reuse them
	 */
	public static void loadSprites(){
		try {
			sprites.add(ImageIO.read(new File("img/enemy1.png")));
//			sprites.add(ImageIO.read(new File("img/enemy2.png")));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * Enemy creator method
	 */
	public static Enemy createEnemy(){
		Enemy e = new Enemy();
		e.setSprite(sprites.get(generator.nextInt(sprites.size())));
		e.setWidth(generator.nextInt(250)+50);
		e.setHeight(e.getSprite().getHeight(null)*e.getWidth()*2/e.getSprite().getWidth(null));
		
		if(generator.nextBoolean()){
			e.setX(-e.getWidth());
			e.setAnimSprite(((BufferedImage)e.getSprite()).getSubimage(e.getSprite().getWidth(null)/2, 0, e.getSprite().getWidth(null)/2, e.getSprite().getHeight(null)));
		}else{
			e.setX(Frame.getFrameWidth());
			e.setAnimSprite(((BufferedImage)e.getSprite()).getSubimage(0, 0, e.getSprite().getWidth(null)/2, e.getSprite().getHeight(null)));
			e.setToLeft(true);
		}
		e.setY(generator.nextInt(Frame.getFrameHeight()));
		
		e.setSpeed(generator.nextInt(5)+1);
		
		return e;
	}
	
	public boolean isToLeft() {
		return toLeft;
	}

	public void setToLeft(boolean toLeft) {
		this.toLeft = toLeft;
	}

	public BufferedImage getAnimSprite() {
		return animSprite;
	}

	public void setAnimSprite(BufferedImage animSprite) {
		this.animSprite = animSprite;
	}
	

}
