package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import Model.Enemy;
import Model.Player;
import Model.Juggernaut;

/**
 * 
 * @author Kamran Tadzjibov
 *
 *         Canvas to draw sprites etc.
 */

@SuppressWarnings("serial")
public class GamePanel extends JPanel {

	private Player player;
	private Image bgImage;
	private String fishSpeed = "0 / 0";
	private List<Enemy> enemies = new ArrayList<Enemy>();
	private Juggernaut Juggernaut;
	
	public GamePanel(Player player) {
		this.player = player;
		setVisible(false);
		try {
			bgImage = ImageIO.read(new File("img/bg1.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(bgImage, 0, 0, null);
		for (Enemy e : enemies) {
//			g.drawOval(e.getX(), e.getY(), e.getWidth(), e.getHeight());
			g.drawImage(e.getAnimSprite(), e.getX(), e.getY(), e.getWidth(),
					e.getHeight(), this);
		}
		g.drawImage(Juggernaut.getSpriteFinal(), Juggernaut.getX(), Juggernaut.getY(),
				Juggernaut.getWidth(), Juggernaut.getHeight(), this);
		g.drawImage(player.getSpriteFinal(), player.getX(), player.getY(),
				player.getWidth(), player.getHeight(), this);
		g.setFont(new Font("Calibri", Font.BOLD, 30));
		g.setColor(Color.white);
		g.drawString("Score: " + player.getScore(), 30, 30);
		g.setFont(new Font("Calibri", Font.BOLD, 16));
		g.drawString("speed/repaintTime: " + fishSpeed, 30, 60);
		
		Graphics2D g2d = (Graphics2D) g;
		if(player.getSpriteFinal().equals(player.getSpriteLeft()))
			g2d.drawPolygon(player.getBoundsProLeft());
		else{
			g2d.drawPolygon(player.getBoundsProRight());
		}
		
		g2d.fillOval(100, 100, 10, 10);
	}

	/**
	 * @return the bgImage
	 */
	public Image getBgImage() {
		return bgImage;
	}

	/**
	 * @param bgImage
	 *            the bgImage to set
	 */
	public void setBgImage(Image bgImage) {
		this.bgImage = bgImage;
	}

	/**
	 * @return the fishSpeed
	 */
	public String getFishSpeed() {
		return fishSpeed;
	}

	/**
	 * @param fishSpeed
	 *            the fishSpeed to set
	 */
	public void setFishSpeed(String fishSpeed) {
		this.fishSpeed = fishSpeed;
	}

	/**
	 * @param enemies
	 *            the enemies to set
	 */
	public void setEnemies(List<Enemy> enemies) {
		this.enemies = enemies;
	}

	/**
	 * get list of the enemies.
	 * 
	 * @return
	 */
	public List<Enemy> getEnemies() {
		return enemies;
	}

	/**
	 * @return the player
	 */
	public Player getPlayer() {
		return player;
	}

	/**
	 * @param player
	 *            the player to set
	 */
	public void setPlayer(Player player) {
		this.player = player;
	}

}
