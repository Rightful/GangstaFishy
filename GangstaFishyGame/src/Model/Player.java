package Model;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.AbstractMap;
import java.util.List;
import java.util.Map.Entry;

import javax.imageio.ImageIO;

import View.Frame;

/**
 * 
 * @author Kamran Tadzjibov
 *
 */

public class Player extends Unit{
	
	private List<Entry<String, Integer>> highscore;
	private double score = 0, acceleration = 0.2;
//	private Image sprite;
	//private double speed = 10, repaintTime = 10;
	private boolean moving = false, accelerating = false;
	private int maxSpeed = 7;
	private String dir = "", lastDir="";
	private boolean isDead = false;
	private BufferedImage spriteLeft;
	private BufferedImage spriteRight;
	private BufferedImage spriteFinal;

	public Player(){
		highscore = JSonRW.reader();
		//highscore.add(new AbstractMap.SimpleEntry<String, Integer>("Jasper Gangsta",99999));
		//JSonRW.writer(highscore);
		try {
			sprite = ImageIO.read(new File("img/player.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		spriteLeft = ((BufferedImage)sprite).getSubimage(0, 0, 1703, 1672);
		spriteRight = ((BufferedImage)sprite).getSubimage(1703, 0, 1703, 1672);
		spriteFinal = spriteLeft;
		update();
	}
	
	public void speedController(){
		if(accelerating && speed<maxSpeed){
			setSpeed(speed+acceleration);
		}
		else if(!accelerating && speed>1){
			setSpeed(speed-acceleration);
		}
		
		if(speed<=1.0 && dir.equals("")){
			moving = false;
			speed = 1;
			moveDown(Frame.getFrameHeight());
		}
	}
	/*
	 * if(alive)
	 * setsound
	 */
	
	public void setMovingDirection(String dir){
		moving = true;
		this.dir = dir;
//		System.out.println("==="+dir+"===");
		if(!dir.equals("")){
			lastDir = dir;
			accelerating = true;
		}else{
			accelerating = false;
		}
	}

	public void moveLeft(int fWidth){
		if(x < -width){
			x = fWidth;
    	}
		x -= speed;
		spriteFinal = spriteLeft;
		boundary.setFrame(x, y, width, height);
	}
	
	public void moveRight(int fWidth){
		if(x > fWidth){
			x = -width;
    	}
		x += speed;
		spriteFinal = spriteRight;
		boundary.setFrame(x, y, width, height);
	}
	
	public void moveUp(){
		if(y > 0){
			y -= speed;
			boundary.setFrame(x, y, width, height);
    	}
//		if(gamePanel.getYPlayer()>0){
//    		gamePanel.setYPlayer(gamePanel.getYPlayer()-p.getSpeed());
//    	}
	}
	
	public void moveDown(int fHeight){
		if(y < fHeight - height - 30){
			y += speed;
			boundary.setFrame(x, y, width, height);
    	}
//		if(gamePanel.getYPlayer()<(viewFrame.getHeight() - gamePanel.getHeightPlayer()-30)){
//    		gamePanel.setYPlayer(gamePanel.getYPlayer()+p.getSpeed());
//    	}
	}
	
	public void update(){
		//boundary.getBounds().setSize((int)(1703/15*score), (int)(1672/15*score));
		if (width < 200 && height < 200){
			//width = (int)(1703/20*score);
			//height = (int)(1672/20*score);
			width = (int)(score+75);
			height = (int)(score+75);
		}
		boundary.setFrame(x, y, width, height);
	}
	
	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	public boolean isMoving() {
		return moving;
	}

	public void setMoving(boolean moving) {
		this.moving = moving;
	}

	public boolean isStop() {
		return stop;
	}

	public void setStop(boolean stop) {
		this.stop = stop;
	}

	public String getDir() {
		return dir;
	}


	public String getLastDir() {
		return lastDir;
	}

	public boolean isAccelerating() {
		return accelerating;
	}

	public void setAccelerating(boolean accelerating) {
		this.accelerating = accelerating;
	}

	public int getMaxSpeed() {
		return maxSpeed;
	}

	public void setMaxSpeed(int maxSpeed) {
		if(maxSpeed<=20)
			this.maxSpeed = maxSpeed;
	}
	
	public boolean isDead() {
		return this.isDead;
	}
	
	public void setDead(boolean isDead) {
		this.isDead = isDead;
	}

	public BufferedImage getSpriteLeft() {
		return spriteLeft;
	}

	public BufferedImage getSpriteRight() {
		return spriteRight;
	}

	public List<Entry<String, Integer>> getHighscore() {
		return highscore;
	}

	public BufferedImage getSpriteFinal() {
		return spriteFinal;
	}

	public void setSpriteFinal(BufferedImage spriteFinal) {
		this.spriteFinal = spriteFinal;
	}
}
