package Model;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * 
 * @author Kamran Tadzjibov
 *
 */

public class Player extends Unit{
	
	private int score = 0;
//	private Image sprite;
	//private double speed = 10, repaintTime = 10;
	private boolean moving = false, accelerating = false;
	private int maxSpeed = 7;
	private String dir = "", lastDir="";

	public Player(){
		try {
			sprite = ImageIO.read(new File("img/player.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void speedController(){
		if(accelerating && speed<maxSpeed){
			setSpeed(speed+0.5);
		}
		else if(!accelerating && speed>1){
			setSpeed(speed-0.5);
		}
		
		if(speed<=1.0 && dir.equals("")){//
			moving = false;
		}
	}
	
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

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
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
}
