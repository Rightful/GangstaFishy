package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 * 
 * @author Shivam
 *
 */
@SuppressWarnings("serial")
public class HighScorePanel extends JPanel {
  private Image bgImage;
  private Frame viewFrame;
  private JButton backbutt;
  private JTable table;

  public HighScorePanel(Frame vFrame) {
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
    backbutt.setBounds(
        vFrame.getWidth() / 2
            - (int) backbutt.getPreferredSize().getWidth() / 2,
        vFrame.getHeight() / 2
            - (int) backbutt.getPreferredSize().getHeight() / 2 + 120,
        (int) backbutt.getPreferredSize().getWidth(),
        (int) backbutt.getPreferredSize().getHeight());

    String[] columnNames = { "Rank", "Name", "Score" };

    Object[][] data = { { "", "", "" }, { "", "", "" }, { "", "", "" },
        { "", "", "" }, { "", "", "" } };
    table = new JTable(data, columnNames);
    table.setMinimumSize(new Dimension(600, 200));
    JScrollPane pane = new JScrollPane(table);
    pane.setMinimumSize(new Dimension(600, 23));
    table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
    add(pane);
    setLayout(new BorderLayout());
    add(table.getTableHeader(), BorderLayout.PAGE_START);
    add(table, BorderLayout.CENTER);
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
   * @return the backbutt
   */
  public JButton getBackbutt() {
    return backbutt;
  }

  /**
   * @param backbutt
   *          the backbutt to set
   */
  public void setBackbutt(JButton backbutt) {
    this.backbutt = backbutt;
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    g.drawImage(bgImage, 0, 0, null);
    g.setFont(new Font("Calibri", Font.BOLD, 35));
    g.setColor(Color.BLUE);
    g.drawString("GangstaFishy", viewFrame.getWidth() / 3,
        viewFrame.getHeight() / 4);

  }

  /**
   * Get the table of with high scores.
   * 
   * @return
   */
  public JTable getTable() {
    return table;
  }

  /**
   * set the table for highscores.
   * 
   * @param table
   */
  public void setTable(JTable table) {
    this.table = table;
  }
}
