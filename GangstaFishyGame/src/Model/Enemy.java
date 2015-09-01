package Model;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Enemy {
	
	private Image sprite;
	private int size;
	
	public Enemy(int size){
		this.size = size;
	}
//comment
	public void createEnemy1(){
		try {
			sprite = ImageIO.read(new File("img/enemy1.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void createEnemy2(){
		try {
			sprite = ImageIO.read(new File("img/enemy2.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
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
