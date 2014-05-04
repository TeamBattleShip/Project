package graphicaluserinterface;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class GamePanel extends JPanel {

	private static final long serialVersionUID = 553271986550975218L;
	Image img;

	public GamePanel(Image img) {
		this.img = img;
		paintComponents(img.getGraphics());
		setBorder(BorderFactory.createMatteBorder(-5, -5, -5, -5, Color.black));
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
	}

}
