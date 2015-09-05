package Controller;

import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.KeyEvent;

import Model.Player;

public class KeyListener {

	private boolean leftPressed, rightPressed, upPressed, downPressed;
	private String dir = "";
	
	public void movePlayerKeyListener(Player p){
		KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(new KeyEventDispatcher() {

            @Override
            public boolean dispatchKeyEvent(KeyEvent ke) {
            	
            	if(ke.getID() == KeyEvent.KEY_PRESSED){
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
	                    }
	                    
	              }
            	if(ke.getID() == KeyEvent.KEY_RELEASED){
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
                    } 
            	}

            	calcDir();
            	p.setMovingDirection(dir);
                return false;
            }
            
        });
	}
	
	public void calcDir(){
		if(leftPressed && !rightPressed && !dir.contains("left"))
    		dir += " left";
		if(!leftPressed && rightPressed && !dir.contains("right"))
    		dir += " right";
		if(upPressed && !downPressed && !dir.contains("up"))
    		dir += " up";
		if(!upPressed && downPressed && !dir.contains("down"))
    		dir += " down";
		
		if(!leftPressed){
			dir = dir.replaceAll(" left", "");
		}
		if(!rightPressed){
			dir = dir.replaceAll(" right", "");
		}
		if(!upPressed){
			dir = dir.replaceAll(" up", "");
		}
		if(!downPressed){
			dir = dir.replaceAll(" down", "");
		}

		
	}
}
