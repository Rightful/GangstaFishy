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
		backbutt.setBounds(vFrame.getWidth() / 5, vFrame.getHeight() - vFrame.getHeight() / 5,
				(int) backbutt.getPreferredSize().getWidth(), (int) backbutt.getPreferredSize().getHeight());
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
		g.drawString("A tale of a mysterious GangstaFishy as he fight and struggles to", 0, viewFrame.getHeight() / 4);
		g.drawString("survive in the deep dark ocean of terror.", 0, viewFrame.getHeight() / 4 + 20);

	}
}
