package Model;

import static org.junit.Assert.*;
import java.awt.Image;
import java.awt.geom.Ellipse2D;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Jasper
 *
 */
public class testUnit {
	Unit unit;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setup() {
		unit = new Unit();
	}

	/**
	 * Test method for {@link Model.Unit#getBoundary()}.
	 * Test method for {@link Model.Unit#setBoundary()}.
	 */
	@Test
	public void testBoundary() {
		Ellipse2D el = new Ellipse2D.Double(2, 3, 4, 5);
		unit.setBoundary(el);
		assertEquals(el, unit.getBoundary());
	}

	/**
	 * Test method for {@link Model.Unit#getX()}.
	 * Test method for {@link Model.Unit#setX()}.
	 */
	@Test
	public void testX() {
		unit.setX(20);
		assertEquals(20, unit.getX());
	}

	/**
	 * Test method for {@link Model.Unit#getY()}.
	 * Test method for {@link Model.Unit#setY()}.
	 */
	@Test
	public void testY() {
		unit.setY(20);
		assertEquals(20, unit.getY());
	}

	/**
	 * Test method for {@link Model.Unit#getWidth()}.
	 * Test method for {@link Model.Unit#setWidth()}.
	 */
	@Test
	public void testWidth() {
		unit.setWidth(20);
		assertEquals(20, unit.getWidth());
	}

	/**
	 * Test method for {@link Model.Unit#getHeight()}.
	 * Test method for {@link Model.Unit#setHeight()}.
	 */
	@Test
	public void testHeight() {
		unit.setHeight(20);
		assertEquals(20, unit.getHeight());
	}

	/**
	 * Test method for {@link Model.Unit#isStop()}.
	 * Test method for {@link Model.Unit#setStop()}.
	 */
	@Test
	public void testStop() {
		unit.setStop(true);
		assertEquals(true, unit.isStop());
		unit.setStop(false);
		assertEquals(false, unit.isStop());
	}
	
	/**
	 * Test method for {@link Model.Unit#getSprite()}.
	 * Test method for {@link Model.Unit#setSprite()}.
	 */
	@Test
	public void testSprite() {
		unit.setSprite(null);
		assertEquals(null, unit.getSprite());
	}
	
	/**
	 * Test method for {@link Model.Unit#getSpeed()}.
	 * Test method for {@link Model.Unit#setSpeed()}.
	 */
	@Test
	public void testSpeed() {
		unit.setSpeed(10);
		assertEquals(10, unit.getSpeed());
	}
	
	/**
	 * Test method for {@link Model.Unit#getRepaintTime()}.
	 * Test method for {@link Model.Unit#setSpeed()}.
	 */
	@Test
	public void testRepaintTime() {
		unit.setSpeed(10);
		assertEquals(10, unit.getRepaintTime());
	}

}
