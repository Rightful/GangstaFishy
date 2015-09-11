package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * 
 * @author Shivam
 *
 */
@SuppressWarnings("serial")
public class CommonPanel extends JPanel {
	private Image bgImage;
	private Frame viewFrame;
	private JButton backbutt;
	private char c;

	public CommonPanel(Frame vFrame) {
		viewFrame = vFrame;
		setLayout(null);
		try {
			bgImage = ImageIO.read(new File("img/bg1.jpg"));
		} catch (Exception e) {
			e.printStackTrace();
		}

		setVisible(false);
		backbutt = new JButton("Back");
		add(backbutt);
		backbutt.setBounds(vFrame.getWidth() / 2
				- (int) backbutt.getPreferredSize().getWidth() / 2,
		vFrame.getHeight() / 2
				- (int) backbutt.getPreferredSize().getHeight() / 2 + 120,
		(int) backbutt.getPreferredSize().getWidth(), (int) backbutt
				.getPreferredSize().getHeight());
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
	 * @return the viewFrame
	 */
	public Frame getViewFrame() {
		return viewFrame;
	}

	/**
	 * @param viewFrame
	 *            the viewFrame to set
	 */
	public void setViewFrame(Frame viewFrame) {
		this.viewFrame = viewFrame;
	}

	/**
	 * @return the backbutt
	 */
	public JButton getBackbutt() {
		return backbutt;
	}

	/**
	 * @param backbutt
	 *            the backbutt to set
	 */
	public void setBackbutt(JButton backbutt) {
		this.backbutt = backbutt;
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(bgImage, 0, 0, null);
		g.setFont(new Font("Calibri", Font.BOLD, 20));
		g.setColor(Color.RED);
		switch (c) {
		case 'a':
			about(g);
			break;
		case 'i':
			instruction(g);
			break;
		case 'g':
			gameOver(g);
			break;
		}
	}

	/**
	 * Paint the strings for the graphics panel.
	 * 
	 * @param g
	 */
	public void about(Graphics g) {
		g.drawString(
				"A tale of a mysterious GangstaFishy as he fight and struggles to",
				0, viewFrame.getHeight() / 4);
		g.drawString("survive in the deep dark ocean of terror.", 0,
				viewFrame.getHeight() / 4 + 20);
		repaint();
	}

	/**
	 * Paint the strings for instruction panel.
	 * 
	 * @param g
	 */
	public void instruction(Graphics g) {

		g.drawString("press \u2191 to move GangaFishy up", 20,
				viewFrame.getHeight() / 4);
		g.drawString("press \u2193 to move GangaFishy down", 20,
				viewFrame.getHeight() / 4 + 30);
		g.drawString("press \u2190 to move GangaFishy left", 20,
				viewFrame.getHeight() / 4 + 60);
		g.drawString("press \u2192 to move GangaFishy right", 20,
				viewFrame.getHeight() / 4 + 90);
		g.drawString(
				"Navigate GangstaFishy through the deep dark ocean of terror and",
				20, viewFrame.getHeight() / 4 + 120);
		g.drawString("devour smaller fishies.", 20,
				viewFrame.getHeight() / 4 + 150);
		g.drawString("Look out for bigger GangstaPiranhas and don't get eaten",
				20, viewFrame.getHeight() / 4 + 180);
		repaint();
	}

	public void gameOver(Graphics g) {
		g.drawString("         Game Over BITCH!!!", viewFrame.getWidth() / 3, viewFrame.getHeight() / 2);
		
		repaint();
	}
	/**
	 * Set the char ch to change from panels.
	 * 
	 * @param ch
	 */
	public void setchar(char ch) {
		c = ch;
	}

	/**
	 * get the current.
	 * 
	 * @return
	 */
	public char getchar() {
		return c;
	}

}
