package graphicaluserinterface;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class HowToPlayGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private HowToPlayGUI frame = this;
	private JButton newGame = new JButton();
	private JButton options = new JButton();
	private JButton exit = new JButton();
	private JButton titlePic = new JButton();
	private JLabel backgroundPic = new JLabel();

	public HowToPlayGUI() {
		frame.setForeground(Color.BLACK);
		frame.setBackground(Color.BLUE);
		frame.setLayout(null);

		initialize();
		labels();
		buttons();
		listeners();
//		soundActionPerformed(null);
	}

	
	private void initialize() {
		frame.setBounds(0, 0, 1000, 700);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);

	}

	private void buttons() {

		newGame.setBorderPainted(false);
		newGame.setIcon(new ImageIcon("Pictures\\newGame.jpg"));
		newGame.setBounds(642, 175, 293, 70);
		frame.add(newGame);

		options.setBorderPainted(false);
		options.setIcon(new ImageIcon("Pictures\\Options.jpg"));
		options.setBounds(688, 339, 208, 75);
		frame.add(options);

		exit.setBorderPainted(false);
		exit.setIcon(new ImageIcon("Pictures\\Exit.jpg"));
		exit.setBounds(730, 500, 111, 69);
		frame.add(exit);
		
		titlePic.setBorderPainted(false);
		titlePic.setIcon(new ImageIcon("Pictures\\BattleshipTitle.jpg"));
		titlePic.setBounds(304, 17, 341, 45);
		frame.add(titlePic);

	}

	private void listeners() {
		newGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int answ = JOptionPane.showConfirmDialog(frame, "Open a new game");
				if (answ == JOptionPane.YES_OPTION)
					System.exit(0);
			}

		});

		options.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int answ = JOptionPane.showConfirmDialog(frame, "Open Options");
				if (answ == JOptionPane.YES_OPTION)
					System.exit(0);
			}
		});

		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				exit();
			}
		});

	}

	private void labels() {

//		backgroundPic.setIcon(new ImageIcon("Pictures\\BattleshipMain.jpg"));
		frame.setContentPane(backgroundPic);

	}

	private void exit() {
		int answ = JOptionPane.showConfirmDialog(frame, "Do you want to quit?");
		if (answ == JOptionPane.YES_OPTION)
			System.exit(0);

	}

}

