package graphicaluserinterface;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class GamePanel2 extends JPanel {
	private Image img;
	/**
	 * 
	 */
	private static final long serialVersionUID = -2969730010550028372L;

	/**
	 * Create the panel.
	 */
	public GamePanel2(Image img) {
		this.img = img;
		paintComponents(img.getGraphics());
		setBorder(BorderFactory.createMatteBorder(-5, -5, -5, -5, Color.black));
		setLayout(null);

	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
	}
	
	
}
