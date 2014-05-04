package graphicaluserinterface;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class HowToPlayGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private HowToPlayGUI frame = this;
	private JLabel background = new JLabel();

	public HowToPlayGUI() {
		frame.setForeground(Color.BLACK);
		frame.setBackground(Color.BLUE);
		frame.setLayout(null);

		initialize();
		labels();
	}
	
	private void initialize() {
		frame.setBounds(0, 0, 1000, 700);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	private void labels() {
		background.setBounds(0, 0, 1000, 700);
		background.setIcon(new ImageIcon("Pictures\\ship.jpg"));
		frame.add(background);
	}

}

