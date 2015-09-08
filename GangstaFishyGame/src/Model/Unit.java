package Model;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Ellipse2D.Double;

/**
 * 
 * @author Kamran Tadzjibov
 *	
 *	Parent class for Player and Enemy
 */
public class Unit {

	protected double speed = 10, repaintTime = 10;
	protected Image sprite;
	protected boolean stop = true;
	protected int x = 0, y = 0;
    protected Ellipse2D boundary = new Ellipse2D.Double();
	
	public Ellipse2D getBoundary() {
		return boundary;
	}

	public void setBoundary(Ellipse2D boundary) {
		this.boundary = boundary;
	}

	public int getRepaintTime() {
		return (int)repaintTime;
	}

	public int getSpeed() {
		return (int)speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
		repaintTime = 20 - speed;
		
	}
	
	public Image getSprite() {
		return sprite;
	}
	public void setSprite(Image sprite) {
		this.sprite = sprite;
	}
	public boolean isStop() {
		return stop;
	}
	public void setStop(boolean stop) {
		this.stop = stop;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	// Draai afbeelding andere kant op
	public void flipImage(String dir) {
		if (dir.contains("left")){
			// Draai naar rechts
		}else {
			// Draai naar links
		}
	}

}
