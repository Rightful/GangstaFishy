package Test;

/**
 * 
 */

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Model.Enemy;

/**
 * @author Jasper
 *
 */
public class EnemyTest {
	
	Enemy enemy;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		enemy = new Enemy();
	}

	/**
	 * Test method for {@link Model.Enemy#loadSprites()}.
	 */
	@Test
	public void testLoadSprites() {
		Enemy.loadSprites();
		assertEquals(5, enemy.getSprites().size());
	
	}

	/**
	 * Test method for {@link Model.Enemy#createEnemy()}.
	 */
	/*@Test
	public void testCreateEnemy() {
		Enemy e = enemy.createEnemy();
		assertNotNull(e);
	}*/

	/**
	 * Test method for {@link Model.Enemy#isToLeft()}.
	 */
	@Test
	public void testIsToLeft() {
		assertFalse(enemy.isToLeft());
	}

	/**
	 * Test method for {@link Model.Enemy#setToLeft(boolean)}.
	 */
	@Test
	public void testSetToLeft() {
		enemy.setToLeft(true);
		assertTrue(enemy.isToLeft());
	}

	/**
	 * Test method for {@link Model.Enemy#getAnimSprite()}.
	 * Test method for {@link Model.Enemy#setAnimSprite(java.awt.image.BufferedImage)}.
	 */
	@Test
	public void testAnimSprite() {
		enemy.setAnimSprite(null);
		assertNull(enemy.getAnimSprite());
	}

}