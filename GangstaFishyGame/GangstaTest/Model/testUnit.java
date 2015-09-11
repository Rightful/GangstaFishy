package Model;

import static org.junit.Assert.*;
import java.awt.Image;
import java.awt.geom.Ellipse2D;

import org.junit.Before;
import org.junit.Test;

public class testUnit {
	Unit unit;

	@Before
	public void setup() {
		unit = new Unit();
	}

	@Test
	public void testBoundary() {
		Ellipse2D el = new Ellipse2D.Double(2, 3, 4, 5);
		unit.setBoundary(el);
		assertEquals(el, unit.getBoundary());
	}

	@Test
	public void testX() {
		unit.setX(20);
		assertEquals(20, unit.getX());
	}

	@Test
	public void testY() {
		unit.setY(20);
		assertEquals(20, unit.getY());
	}

	@Test
	public void testWidth() {
		unit.setWidth(20);
		assertEquals(20, unit.getWidth());
	}

	@Test
	public void testHeight() {
		unit.setHeight(20);
		assertEquals(20, unit.getHeight());
	}

	@Test
	public void testStop() {
		unit.setStop(true);
		assertEquals(true, unit.isStop());
		unit.setStop(false);
		assertEquals(false, unit.isStop());
	}

}
