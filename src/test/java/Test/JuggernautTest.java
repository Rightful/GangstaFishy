/**
 * 
 */
package Test;

import static org.junit.Assert.*;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.junit.Before;
import org.junit.Test;

import Model.Juggernaut;
import Model.PowerUp;

/**
 * @author jasper
 *
 */
public class JuggernautTest {
	
	Juggernaut Juggernaut2;
	
	@Before
	public void initialize() {
		Juggernaut2 = new Juggernaut();
	}

	/**
	 * Test method for {@link Model.Juggernaut#Juggernaut()}.
	 */
	@Test
	public void testJuggernaut() {
		assertNotNull(Juggernaut2);
	}

	/**
	 * Test method for {@link Model.Juggernaut#getSpriteFinal()}.
	 * @throws IOException 
	 */
	@Test
	public void testGetSpriteFinal() throws IOException {
		assertNotNull(Juggernaut2.getSpriteFinal());
	}

	/**
	 * Test method for {@link Model.Juggernaut#setSpriteFinal(java.awt.image.BufferedImage)}.
	 */
	@Test
	public void testSetSpriteFinal() {
		Juggernaut2.setSpriteFinal(null);
		assertNull(Juggernaut2.getSpriteFinal());
	}

	/**
	 * Test method for {@link Model.PowerUp#getStatus()}.
	 */
	@Test
	public void testGetStatus() {
		assertFalse(Juggernaut2.getStatus());
	}

	/**
	 * Test method for {@link Model.PowerUp#setStatus(boolean)}.
	 */
	@Test
	public void testSetStatus() {
		Juggernaut2.setStatus(true);
		assertTrue(Juggernaut2.getStatus());
	}

}
