package Controller;

import java.awt.geom.Ellipse2D;
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
	 *            List of enemies the player can collide with.
	 * @param player
	 *            The player of the game.
	 */
	public static void collide(List<Enemy> enemies, Player player) {

		Ellipse2D pB = player.getBoundary();

		for (int i = 0; i < enemies.size(); i++) {
			Enemy e = enemies.get(i);
			Ellipse2D eB = e.getBoundary();

			double distance = Math.sqrt(Math.pow(
					(pB.getCenterX()) - (eB.getCenterX()), 2)
					+ Math.pow((pB.getCenterY()) - (eB.getCenterY()), 2));

			double collDist = collDist(player, e);
			
			if ((int) distance < (pB.getHeight())
					&& pB.getHeight() > eB.getHeight()) {
				player.setScore(player.getScore() + 10);
				enemies.remove(e);
				player.update();

			}

			else if ((int) distance < (pB.getHeight()) && pB.getHeight() < eB.getHeight()) {
				player.setDead(true);
				NOTICELOGGER.message("player died", Logger.NOTICE);
			}

		}
	}
	
	/**
	 * Method for calculating the distance between two players.
	 * @param p Player
	 * @param e Enemy
	 * @return the distance between the two units.
	 */
	private static double collDist(Player p, Enemy e){
		double distance = 0;
		
		double pX = p.getBoundary().getCenterX(), pY = p.getBoundary().getCenterY(),
				eX = e.getBoundary().getCenterX(), eY = e.getBoundary().getCenterY();
		
		double wP = eX - pX, 
				kP = eY - pY;
		
		double tanThetaP = wP/kP;
		
		double pA = p.getWidth(), pB = p.getHeight(),
				eA = e.getWidth(), eB = e.getHeight();
		
		double Xplay = (pA*pB) / Math.sqrt( pB*pB + pA*pA*(tanThetaP*tanThetaP) );
		double arcTan = Math.atan(tanThetaP);

		if(!(arcTan < Math.PI/2 && arcTan > -Math.PI/2)){
			Xplay = 0-Xplay;
		}
		double Yplay = Xplay*tanThetaP;
		
		double distancePlayer = Math.sqrt( Math.pow(Xplay - pX, 2) + Math.pow(Yplay - pY, 2) );
		
		
		//ENEMY
		double wE = pX - eX, 
				kE = pY - eY;
		
		double tanThetaE = wE/kE;
		
		double Xenem = (eA*eB) / Math.sqrt( eB*eB + eA*eA*(tanThetaE*tanThetaE) );
		double arcTanEn = Math.atan(tanThetaE);

		if(!(arcTanEn < Math.PI/2 && arcTanEn > -Math.PI/2)){
			Xenem = 0-Xenem;
		}
		double Yenem = Xenem*tanThetaE;
		
		double distanceEnemy = Math.sqrt( Math.pow(Xenem - pX, 2) + Math.pow(Yenem - pY, 2) );
		
		distance = distanceEnemy + distancePlayer;
		
		return distance;
	}
}