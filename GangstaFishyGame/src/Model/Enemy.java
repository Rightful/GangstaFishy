package Model;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

public class Enemy {
	
	private static List<Image> sprites = new ArrayList<Image>();
	private Image sprite;
	private int size;
	
	public Enemy(int size){
		this.size = size;
	}

	/**
	 *  Load all sprites only once and reuse them
	 */
	public static void loadSprites(){
		try {
			sprites.add(ImageIO.read(new File("img/enemy1.png")));
			sprites.add(ImageIO.read(new File("img/enemy2.png")));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Enemy1 creator method
	 */
	public void createEnemy1(){
		sprite = sprites.get(0);
	}
	
	/**
	 * Enemy2 creator method
	 */
	public void createEnemy2(){
		sprite = sprites.get(1);
	}
	
	public Image getSprite() {
		return sprite;
	}
	public void setSprite(Image sprite) {
		this.sprite = sprite;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	

}
