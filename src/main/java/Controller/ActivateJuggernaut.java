package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import Model.Player;

public class ActivateJuggernaut {

	public static void activateJuggernaut () {
		Player.getJuggernaut().setStatus(true);
		Timer t = new Timer(5000, new MyTimerActionListener());
		
		t.start();
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		t.stop();
	}
}
class MyTimerActionListener implements ActionListener {
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Player.getJuggernaut().setStatus(false);
	}
}