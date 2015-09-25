package Model;

import java.awt.Image;
import java.awt.geom.Ellipse2D;

/**
 * 
 * @author Kamran Tadzjibov 
 *
 * Parent class for Player and Enemy
 */
public abstract class Unit {

	protected double speed = 10, repaintTime = 10;
	protected Image sprite;
	protected boolean stop = true;
	protected int x = 0, y = 0, width = 100, height = 100;
	protected Ellipse2D boundary = new Ellipse2D.Double();
	
	protected BoundsPro boundsProLeft = new BoundsPro();
	protected BoundsPro boundsProRight = new BoundsPro();
	protected BoundsPro boundsPro = new BoundsPro();
	/**
	 * Constuctor for the unit class.
	 */
	public Unit() {

	}
	
	

	public void translateBounds(int x, int y){
		getBoundsProLeft().translateTo(x, y);
		getBoundsProRight().translateTo(x, y);
	}
	

	public void scaleBounds(int w, int h){
		getBoundsProLeft().scaleTo(w, h);
		getBoundsProRight().scaleTo(w, h);
	}
	/**
	 * Get the collision boundaries for the units.
	 * 
	 * @return
	 */

	public Ellipse2D getBoundary() {
		return boundary;
	}

	/**
	 * set the collision boundaries for the units.
	 * 
	 * @param boundary
	 */
	public void setBoundary(Ellipse2D boundary) {
		this.boundary = boundary;
	}

	/**
	 * get the repaint time for the unit.
	 * 
	 * @return
	 */
	public int getRepaintTime() {
		return (int) repaintTime;
	}

	/**
	 * get the speed of the unit.
	 * 
	 * @return speed of unit.
	 */
	public int getSpeed() {
		return (int) speed;
	}

	/**
	 * set the speed of the unit.
	 * 
	 * @param speed
	 *            speed of the unit.
	 */
	public void setSpeed(double speed) {
		this.speed = speed;
		repaintTime = 20 - speed;

	}

	/**
	 * return the image of the unit.
	 * 
	 * @return image of the unit.
	 */
	public Image getSprite() {
		return sprite;
	}

	/**
	 * set the image of the unit.
	 * 
	 * @param sprite
	 *            set the new image of the unit.
	 */
	public void setSprite(Image sprite) {
		this.sprite = sprite;
	}

	/**
	 * check if the unit is still.
	 * 
	 * @return
	 */
	public boolean isStop() {
		return stop;
	}

	/**
	 * set that the unit is still or not.
	 * 
	 * @param stop
	 */
	public void setStop(boolean stop) {
		this.stop = stop;
	}

	/**
	 * get the X value of the unit.
	 * 
	 * @return
	 */
	public int getX() {
		return x;
	}

	/**
	 * set the x value of the unit.
	 * 
	 * @param x
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * get the y value of the unit.
	 * 
	 * @return y value.
	 */
	public int getY() {
		return y;
	}

	/**
	 * set the y value of the unit.
	 * 
	 * @param y
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * get the width of the unit.
	 * 
	 * @return
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * set the width of the unit.
	 * 
	 * @param width
	 */
	public void setWidth(int width) {
		this.width = width;
	}

	/**
	 * Get the height of the player.
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * set the height of the unit.
	 * 
	 * @param height
	 */
	public void setHeight(int height) {
		this.height = height;
	}

	public BoundsPro getBoundsProLeft() {
		return boundsProLeft;
	}

	public BoundsPro getBoundsProRight() {
		return boundsProRight;
	}



	public BoundsPro getBoundsPro() {
		return boundsPro;
	}



	public void setBoundsPro(BoundsPro boundsPro) {
		this.boundsPro = boundsPro;
	}

}
