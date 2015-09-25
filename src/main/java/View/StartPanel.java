package View;

import java.awt.Color;
import java.awt.Font;
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
  private Frame viewFrame;
  private JButton highbutt;
  private JButton startbutt;
  private JButton helpbutt;
  private JButton sbutt;
  private JButton abbutt;
  private JButton exbutt;

  /**
   * Start panel for mainmenu.
   * 
   * @param vframe
   */
  public StartPanel(Frame vframe) {

    try {
      bgImage = ImageIO.read(new File("img/bg1.jpg"));
    } catch (IOException e) {
      e.printStackTrace();
    }

    setVisible(true);
    viewFrame = vframe;
    setLayout(null);

    startbutt = new JButton("Start");
    add(startbutt);
    startbutt.setBounds(
        vframe.getWidth() / 2
            - (int) startbutt.getPreferredSize().getWidth() / 2,
        vframe.getHeight() / 2
            - (int) startbutt.getPreferredSize().getHeight() / 2 - 30,
        (int) startbutt.getPreferredSize().getWidth(),
        (int) startbutt.getPreferredSize().getHeight());

    sbutt = new JButton("Settings");
    add(sbutt);
    sbutt.setBounds(
        vframe.getWidth() / 2 - (int) sbutt.getPreferredSize().getWidth() / 2,
        vframe.getHeight() / 2 - (int) sbutt.getPreferredSize().getHeight() / 2,
        (int) sbutt.getPreferredSize().getWidth(),
        (int) sbutt.getPreferredSize().getHeight());

    helpbutt = new JButton("Instructions");
    add(helpbutt);
    helpbutt.setBounds(
        vframe.getWidth() / 2
            - (int) helpbutt.getPreferredSize().getWidth() / 2,
        vframe.getHeight() / 2
            - (int) helpbutt.getPreferredSize().getHeight() / 2 + 30,
        (int) helpbutt.getPreferredSize().getWidth(),
        (int) helpbutt.getPreferredSize().getHeight());

    highbutt = new JButton("HighScore");
    add(highbutt);
    highbutt.setBounds(
        vframe.getWidth() / 2
            - (int) highbutt.getPreferredSize().getWidth() / 2,
        vframe.getHeight() / 2
            - (int) highbutt.getPreferredSize().getHeight() / 2 + 60,
        (int) highbutt.getPreferredSize().getWidth(),
        (int) highbutt.getPreferredSize().getHeight());

    abbutt = new JButton("About");
    add(abbutt);
    abbutt.setBounds(
        vframe.getWidth() / 2 - (int) abbutt.getPreferredSize().getWidth() / 2,
        vframe.getHeight() / 2 - (int) abbutt.getPreferredSize().getHeight() / 2
            + 90,
        (int) abbutt.getPreferredSize().getWidth(),
        (int) abbutt.getPreferredSize().getHeight());

    exbutt = new JButton("Exit");
    add(exbutt);
    exbutt.setBounds(
        vframe.getWidth() / 2 - (int) exbutt.getPreferredSize().getWidth() / 2,
        vframe.getHeight() / 2 - (int) exbutt.getPreferredSize().getHeight() / 2
            + 120,
        (int) exbutt.getPreferredSize().getWidth(),
        (int) exbutt.getPreferredSize().getHeight());

  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    g.drawImage(bgImage, 0, 0, null);
    g.setFont(new Font("Calibri", Font.BOLD, 35));
    g.setColor(Color.WHITE);
    g.drawString("     GangstaFishy", viewFrame.getWidth() / 3,
        viewFrame.getHeight() / 4);
  }

  /**
   * @return the exbutt
   */
  public JButton getExbutt() {
    return exbutt;
  }

  /**
   * @param exbutt
   *          the exbutt to set
   */
  public void setExbutt(JButton exbutt) {
    this.exbutt = exbutt;
  }

  /**
   * @return the bgImage
   */
  public Image getBgImage() {
    return bgImage;
  }

  /**
   * @param bgImage
   *          the bgImage to set
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
   *          the viewFrame to set
   */
  public void setViewFrame(Frame viewFrame) {
    this.viewFrame = viewFrame;
  }

  /**
   * @return the highbutt
   */
  public JButton getHighbutt() {
    return highbutt;
  }

  /**
   * @param highbutt
   *          the highbutt to set
   */
  public void setHighbutt(JButton highbutt) {
    this.highbutt = highbutt;
  }

  /**
   * @return the startbutt
   */
  public JButton getStartbutt() {
    return startbutt;
  }

  /**
   * @param startbutt
   *          the startbutt to set
   */
  public void setStartbutt(JButton startbutt) {
    this.startbutt = startbutt;
  }

  /**
   * @return the helpbutt
   */
  public JButton getHelpbutt() {
    return helpbutt;
  }

  /**
   * @param helpbutt
   *          the helpbutt to set
   */
  public void setHelpbutt(JButton helpbutt) {
    this.helpbutt = helpbutt;
  }

  /**
   * @return the sbutt
   */
  public JButton getSbutt() {
    return sbutt;
  }

  /**
   * @param sbutt
   *          the sbutt to set
   */
  public void setSbutt(JButton sbutt) {
    this.sbutt = sbutt;
  }

  /**
   * @return the abbutt
   */
  public JButton getAbbutt() {
    return abbutt;
  }

  /**
   * @param abbutt
   *          the abbutt to set
   */
  public void setAbbutt(JButton abbutt) {
    this.abbutt = abbutt;
  }
}
