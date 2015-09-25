package Controller;

import java.util.ArrayList;
import java.util.List;

import Model.Enemy;
import Model.Logger;
import Model.NoticeLogger;
import Model.Player;

/**
 * Class to calculate collisions.
 * 
 * @author Kamran
 *
 */
public class Collision {

  private static Logger NOTICELOGGER = new NoticeLogger();

  /**
   * Method for determining a collision between the player and enemies.
   * 
   * @param enemies
   *          List of enemies the player can collide with.
   * @param player
   *          The player of the game.
   */
  public static void collide(List<Enemy> enemies, Player player) {

    double distance;

    List<Enemy> enemyToRemove = new ArrayList<Enemy>();
    for (int i = 0; i < enemies.size(); i++) {
      Enemy e = enemies.get(i);
      distance = Math.sqrt(Math
          .pow((player.getHeight() / 2 + player.getY())
              - (e.getHeight() / 2 + e.getY()), 2)
          + Math.pow((player.getWidth() / 2 + player.getX())
              - (e.getWidth() / 2 + e.getX()), 2));

      if (distance <= player.getHeight() / 2 + e.getHeight() / 2) {
        for (int j = 0; j < player.getBoundsPro().npoints; j++) {
          if (e.getBoundsPro().contains(player.getBoundsPro().xpoints[j],
              player.getBoundsPro().ypoints[j])) {
            if (player.getHeight() >= e.getHeight()) {
              player.setScore(player.getScore() + 10);
              enemyToRemove.add(e);
              player.update();

            }

            else {
              player.setDead(true);
              NOTICELOGGER.message("player died", Logger.NOTICE);
            }
          }
        }
      }
    }

    for (Enemy e : enemyToRemove) {
      enemies.remove(e);
    }
  }

  /**
   * Method for calculating the distance between two players.
   * 
   * @param p
   *          Player
   * @param e
   *          Enemy
   * @return the distance between the two units.
   */
  private static double collDist(Player p, Enemy e) {
    double distance = 0;

    double pX = p.getBoundary().getCenterX(), pY = p.getBoundary().getCenterY(),
        eX = e.getBoundary().getCenterX(), eY = e.getBoundary().getCenterY();

    double wP = eX - pX, kP = eY - pY;

    double tanThetaP = wP / kP;

    double pA = p.getWidth(), pB = p.getHeight(), eA = e.getWidth(),
        eB = e.getHeight();

    double Xplay = (pA * pB)
        / Math.sqrt(pB * pB + pA * pA * (tanThetaP * tanThetaP));
    double arcTan = Math.atan(tanThetaP);

    if (!(arcTan < Math.PI / 2 && arcTan > -Math.PI / 2)) {
      Xplay = 0 - Xplay;
    }
    double Yplay = Xplay * tanThetaP;

    double distancePlayer = Math
        .sqrt(Math.pow(Xplay - pX, 2) + Math.pow(Yplay - pY, 2));

    // ENEMY
    double wE = pX - eX, kE = pY - eY;

    double tanThetaE = wE / kE;

    double Xenem = (eA * eB)
        / Math.sqrt(eB * eB + eA * eA * (tanThetaE * tanThetaE));
    double arcTanEn = Math.atan(tanThetaE);

    if (!(arcTanEn < Math.PI / 2 && arcTanEn > -Math.PI / 2)) {
      Xenem = 0 - Xenem;
    }
    double Yenem = Xenem * tanThetaE;

    double distanceEnemy = Math
        .sqrt(Math.pow(Xenem - pX, 2) + Math.pow(Yenem - pY, 2));

    distance = distanceEnemy + distancePlayer;

    return distance;
  }
}
