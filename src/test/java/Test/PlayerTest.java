package Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import Model.Player;

public class PlayerTest {
  Player player;

  @Before
  public void setup() {
    player = new Player();
  }

  @Test
  public void testScore() {
    player.setScore(100.0);
    assertTrue(player.getScore() == 100.0);

  }

  @Test
  public void testMoving() {
    player.setMoving(true);
    assertEquals(true, player.isMoving());
    player.setMoving(false);
    assertEquals(false, player.isMoving());
  }

  @Test
  public void testStop() {
    player.setStop(true);
    assertEquals(true, player.isStop());
    player.setStop(false);
    assertEquals(false, player.isStop());
  }

  /*
   * @Test public void testDir() {
   * 
   * }
   */

  @Test
  public void testAccelerating() {
    player.setAccelerating(true);
    assertEquals(true, player.isAccelerating());
    player.setAccelerating(false);
    assertEquals(false, player.isAccelerating());
  }

  @Test
  public void testMaxSpeed() {

    int x = player.getMaxSpeed();
    player.setMaxSpeed(21);
    assertEquals(x, player.getMaxSpeed());

    int m = player.getMaxSpeed();
    player.setMaxSpeed(19);
    assertNotEquals(m, player.getMaxSpeed());

    player.setMaxSpeed(20);
    assertEquals(20, player.getMaxSpeed());

  }

  @Test
  public void testDead() {
    player.setDead(true);
    assertEquals(true, player.isDead());
    player.setDead(false);
    assertEquals(false, player.isDead());
  }

  @Test
  public void testSpriteFinal() {
    player.setSpriteFinal(null);
    assertEquals(null, player.getSpriteFinal());
  }

}
