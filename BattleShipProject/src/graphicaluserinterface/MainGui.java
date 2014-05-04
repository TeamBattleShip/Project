package graphicaluserinterface;

import game.api.GameStateBattleship;
import game.init.Runner;
import game.io.IoFactoryBattleship;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class MainGui extends JFrame {

	private static final long serialVersionUID = 1L;
	private MainGui frame = this;
	private JButton newGame = new JButton();
	private JButton options = new JButton();
	private JButton exit = new JButton();
	private JButton titlePic = new JButton();
	private JLabel backgroundPic = new JLabel();
	

	public MainGui() {
		setUpFrame();
		initialize();
		labels();
		buttons();
		listeners();

	}

	private void setUpFrame() {
		frame.setVisible(true);
		frame.setForeground(Color.BLACK);
		frame.setBackground(Color.BLUE);
		frame.setLayout(null);
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
		options.setIcon(new ImageIcon("Pictures\\howtoplay.jpg"));
		options.setBounds(650, 339, 315, 73);
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
				dispose();
				new Runner(new GameStateBattleship(), new IoFactoryBattleship()).run();

			}});

		options.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new HowToPlayGUI();
				dispose();
			}
		});

		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				exit();
			}
		});

	}

	private void labels() {

		backgroundPic.setIcon(new ImageIcon("Pictures\\BattleshipMain.jpg"));
		frame.setContentPane(backgroundPic);

	}

	private void exit() {
		int answ = JOptionPane.showConfirmDialog(frame, "Do you want to quit?");
		if (answ == JOptionPane.YES_OPTION)
			System.exit(0);

	}

}
