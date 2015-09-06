package View;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * 
 * @author Shivam
 *
 */
@SuppressWarnings("serial")
public class StartPanel extends JPanel {
	private Image bgImage;
	private JButton highbutt;
	private JButton startbutt;
	private JButton helpbutt;
	private JButton sbutt;
	private JButton abbutt;

	public StartPanel(Frame vframe) {
		setVisible(true);
		setLayout(null);
		startbutt = new JButton("Start");
		add(startbutt);
		startbutt.setBounds(vframe.getWidth() / 2 - (int) startbutt.getPreferredSize().getWidth() / 2,
				vframe.getHeight() / 2 - (int) startbutt.getPreferredSize().getHeight() / 2 - 30,
				(int) startbutt.getPreferredSize().getWidth(), (int) startbutt.getPreferredSize().getHeight());

		sbutt = new JButton("Settings");
		add(sbutt);
		sbutt.setBounds(vframe.getWidth() / 2 - (int) sbutt.getPreferredSize().getWidth() / 2,
				vframe.getHeight() / 2 - (int) sbutt.getPreferredSize().getHeight() / 2,
				(int) sbutt.getPreferredSize().getWidth(), (int) sbutt.getPreferredSize().getHeight());

		helpbutt = new JButton("Instructions");
		add(helpbutt);
		helpbutt.setBounds(vframe.getWidth() / 2 - (int) helpbutt.getPreferredSize().getWidth() / 2,
				vframe.getHeight() / 2 - (int) helpbutt.getPreferredSize().getHeight() / 2 + 30,
				(int) helpbutt.getPreferredSize().getWidth(), (int) helpbutt.getPreferredSize().getHeight());

		highbutt = new JButton("HighScore");
		add(highbutt);
		highbutt.setBounds(vframe.getWidth() / 2 - (int) highbutt.getPreferredSize().getWidth() / 2,
				vframe.getHeight() / 2 - (int) highbutt.getPreferredSize().getHeight() / 2 + 60,
				(int) highbutt.getPreferredSize().getWidth(), (int) highbutt.getPreferredSize().getHeight());

		abbutt= new JButton("About");
		add(abbutt);
		abbutt.setBounds(vframe.getWidth() / 2 - (int) abbutt.getPreferredSize().getWidth() / 2,
				vframe.getHeight() / 2 - (int) abbutt.getPreferredSize().getHeight() / 2 + 90,
				(int) abbutt.getPreferredSize().getWidth(), (int) abbutt.getPreferredSize().getHeight());

		try {
			bgImage = ImageIO.read(new File("img/bg1.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Image getBgImage() {
		return bgImage;
	}

	public void setBgImage(Image bgImage) {
		this.bgImage = bgImage;
	}

	public JButton getStartbutt() {
		return startbutt;
	}

	public void setStartbutt(JButton startbutt) {
		this.startbutt = startbutt;
	}

	public JButton getHelpbutt() {
		return helpbutt;
	}

	public void setHelpbutt(JButton helpbutt) {
		this.helpbutt = helpbutt;
	}

	public JButton getSbutt() {
		return sbutt;
	}

	public void setSbutt(JButton sbutt) {
		this.sbutt = sbutt;
	}

	public JButton getAbbutt() {
		return abbutt;
	}

	public void setAbbutt(JButton abbutt) {
		this.abbutt = abbutt;
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(bgImage, 0, 0, null);

	}

}
