package Controller;

import java.awt.geom.Ellipse2D;
import java.util.List;
import View.*;

import Model.Enemy;
import Model.Player;

public class Collision {
	
	public static void collide(List<Enemy> enemies, Player player){
		Ellipse2D pB = player.getBoundary();
		
		for (int i = 0; i < enemies.size(); i++){  
			Enemy e = enemies.get(i);
		    Ellipse2D eB = e.getBoundary();
		    
	        double distance = Math.sqrt(Math.pow((pB.getCenterX()) - (eB.getCenterX()),2) +
	        					Math.pow((pB.getCenterY()) - (eB.getCenterY()), 2));
	
	        if((int)distance<(pB.getWidth()) && pB.getWidth() > eB.getWidth()){
		        player.setScore(player.getScore() + 10);	
		        enemies.remove(e);
		        player.update();
			}
	        else if((int)distance<(pB.getWidth()) && pB.getWidth() < eB.getWidth()){
	        	player.setDead(true);
//	        	System.exit(0);
	        	// Moet eigenlijk naar 'enter name' pagina doorgestuurd worden en daarna naar 'high scores'/'start' panel.
	        }
		}
	}
}
