package Model;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Timer;

/**
 * 
 * @author Kamran Tadzjibov
 *
 */

public class Player {
	
	private int score = 0;
	private Image sprite;
	private double speed = 10, repaintTime = 10;
	private Timer t;
	private boolean moving = false, stop = true, accelerating = false;
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
//			System.out.println(speed);
			setSpeed(speed+0.5);
		}
		else if(!accelerating && speed>1){
			setSpeed(speed-0.5);
		}
		
		if(speed<=1.0 && dir.equals("")){//
			moving = false;
		}
		//System.out.println("Player dir: " + dir);
		//speed = 50;
//	    if(speed == 15 || (dir.equals("") && speed == 1)){
//	    	moving = false;
//	    }
//	    if(t!=null){
//	    	t.stop();
//	    }
//	    else if(moving){
//			ActionListener move = new ActionListener() {
//		         @Override
//		         public void actionPerformed(ActionEvent evt) {
//		        	if(moving && speed < 15){
//		        		speed+=0.01;
//		        	}
//		        	if(!moving && speed > 1){
//		        		speed-=0.01;
//		        	}
//		        	System.out.println("Plaeyer speed: "+ speed);
//		         }
//		      };
//		      t =  new Timer((int)(50), move);
//		      t.start();
//	    }
	}
	
	public void setMovingDirection(String dir){
		
//		if(speed<=1.0 && dir.equals("")){//
//			moving = false;
//		}
//		else{
//			moving = true;
//		}
		moving = true;
		this.dir = dir;
		System.out.println("==="+dir+"===");
		if(!dir.equals("")){
			lastDir = dir;
			accelerating = true;
		}else{
			accelerating = false;
		}
//		if(moving){
//			if(dir.contains("left")){
//				
//			}else if( dir.contains("right")){
//
//			}
//			if(dir.contains("up")){
//
//			}else if(dir.contains("down")){
//
//			}
//		}
	}
	
	public Image getSprite() {
		return sprite;
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

	public int getRepaintTime() {
		return (int)repaintTime;
	}

	public int getSpeed() {
//		System.out.println("Player speed: " + speed);
		return (int)speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
		repaintTime = 20 - speed;
		
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
