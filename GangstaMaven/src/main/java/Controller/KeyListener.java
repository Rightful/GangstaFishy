package main.java.Controller;

import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.KeyEvent;

import javax.swing.Timer;

import main.java.Model.Player;

/**
 * 
 * @author Kamran Tadzjibov
 * 
 *         Handle keyboard input
 *
 */
public class KeyListener {

	private boolean leftPressed, rightPressed, upPressed, downPressed,
			paused = false;
	private Timer t;

	public Timer getT() {
		return t;
	}

	public void setT(Timer t) {
		this.t = t;
	}

	private String dir = "";

	/**
	 * Checking what key is pressed and determining what direction the player
	 * should move to.
	 * 
	 * @param p
	 *            The player of the game.
	 */
	public void movePlayerKeyListener(final Player p) {
		KeyboardFocusManager.getCurrentKeyboardFocusManager()
				.addKeyEventDispatcher(new KeyEventDispatcher() {

					@Override
					public boolean dispatchKeyEvent(KeyEvent ke) {

						if (ke.getID() == KeyEvent.KEY_PRESSED) {
							switch (ke.getKeyCode()) {
							case KeyEvent.VK_LEFT:
								leftPressed = true;
								break;
							case KeyEvent.VK_RIGHT:
								rightPressed = true;
								break;
							case KeyEvent.VK_UP:
								upPressed = true;
								break;
							case KeyEvent.VK_DOWN:
								downPressed = true;
								break;
							case KeyEvent.VK_A:
								leftPressed = true;
								break;
							case KeyEvent.VK_D:
								rightPressed = true;
								break;
							case KeyEvent.VK_W:
								upPressed = true;
								break;
							case KeyEvent.VK_S:
								downPressed = true;
								break;
							case KeyEvent.VK_P:
								if (t != null) {
									if (paused) {
										paused = false;
										t.start();
									} else {
										paused = true;
										t.stop();
									}
								}
								break;
							}

						}
						if (ke.getID() == KeyEvent.KEY_RELEASED) {
							switch (ke.getKeyCode()) {
							case KeyEvent.VK_LEFT:
								leftPressed = false;
								break;
							case KeyEvent.VK_RIGHT:
								rightPressed = false;
								break;
							case KeyEvent.VK_UP:
								upPressed = false;
								break;
							case KeyEvent.VK_DOWN:
								downPressed = false;
								break;
							case KeyEvent.VK_A:
								leftPressed = false;
								break;
							case KeyEvent.VK_D:
								rightPressed = false;
								break;
							case KeyEvent.VK_W:
								upPressed = false;
								break;
							case KeyEvent.VK_S:
								downPressed = false;
								break;
							}
						}

						calcDir();
						p.setMovingDirection(dir);
						return false;
					}

				});
	}

	/**
	 * calculate what direction the player will move depending on the key that
	 * was pressed.
	 */

	public void calcDir() {
		if (leftPressed && !rightPressed && !dir.contains("left"))
			dir += " left";
		if (!leftPressed && rightPressed && !dir.contains("right"))
			dir += " right";
		if (upPressed && !downPressed && !dir.contains("up"))
			dir += " up";
		if (!upPressed && downPressed && !dir.contains("down"))
			dir += " down";

		if (!leftPressed) {
			dir = dir.replaceAll(" left", "");
		}
		if (!rightPressed) {
			dir = dir.replaceAll(" right", "");
		}
		if (!upPressed) {
			dir = dir.replaceAll(" up", "");
		}
		if (!downPressed) {
			dir = dir.replaceAll(" down", "");
		}

	}

	// methode aanmaken voor pauzeren.

}
