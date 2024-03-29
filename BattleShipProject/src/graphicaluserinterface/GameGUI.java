package graphicaluserinterface;

import game.api.GameState;
import game.impl.BoardLocation;
import graphicaluserinterface.gamelabels.GameLabelBlank;
import graphicaluserinterface.gamelabels.GameLabelContext;
import graphicaluserinterface.gamelabels.GameLabelStrategy;
import graphicaluserinterface.listeners.EnemyLabelClicked;
import graphicaluserinterface.listeners.ExitGameOption;
import graphicaluserinterface.listeners.PlayerLabelClicked;
import graphicaluserinterface.listeners.StartGameListener;
import graphicaluserinterface.robot.TextTypingRobot;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class GameGUI extends JFrame {

	private static final long serialVersionUID = 8292954314171245311L;

	private static HashMap<String, GameLabelBlank> playerBoard;
	private static HashMap<String, GameLabelBlank> enemyBoard;
	private JPanel enemyPanel;
	private JPanel playerPanel;
	private JPanel panelHolder;
	private JPanel mainPanel;
	private JLabel destroyer = new JLabel("1");
	private JLabel cruiser = new JLabel("2");
	private JLabel submarine = new JLabel("3");
	private JLabel battleship = new JLabel("4");
	private JLabel aircraftCarrier = new JLabel("5");
	private JButton ready = new JButton();
	private JButton exit = new JButton();
	private JPanel boats = new JPanel();
	private JTextArea statusText;
	private static GameState state;

	public GameGUI(GameState state) {
		GameGUI.state = state;
		initialize();
	}

	private void initialize() {
		setVisible(true);
		playerBoard = new HashMap<String, GameLabelBlank>();
		enemyBoard = new HashMap<String, GameLabelBlank>();
		// setUndecorated(true);
		setFrameProperties();
		makeJPanels1();
		makeAllJLabels();
		makeMidPanel();

	}

	private void setFrameProperties() {
		setResizable(false);
		setBounds(100, 100, 1500, 800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout(0, 0));
	}

	private void makeJPanels1() {

		panelHolder = new JPanel();
		getContentPane().add(panelHolder, BorderLayout.CENTER);
		panelHolder.setLayout(new GridLayout(0, 3, 0, 0));

		try {
			playerPanel = new GamePanel(ImageIO.read(new File(
					"Pictures//Ocean2.jpg")));
			enemyPanel = new GamePanel(ImageIO.read(new File(
					"Pictures//Ocean2.jpg")));
			mainPanel = new GamePanel2(ImageIO.read(new File(
					"Pictures//MidPanelPic.jpg")));

		} catch (IOException e) {

		}
		enemyPanel.setLayout(new GridLayout(12, 12, 0, 0));
		panelHolder.add(playerPanel);

		panelHolder.add(mainPanel);
		playerPanel.setLayout(new GridLayout(12, 12, 0, 0));

		panelHolder.add(enemyPanel);

	}

	private void makeAllJLabels() {
		for (int i = 0, i2 = 0; i2 < 12; i = (i + 1) % 12) {
			makeJLabel(i2, i);
			if (i == 11)
				i2++;
		}

	}

	private void makeJLabel(int i2, int i) {
		final String[] coordinates = { " ", "A", "B", "C", "D", "E", "F", "G",
				"H", "I", "J", "-" };
		GameLabelStrategy playerLabels;
		GameLabelStrategy enemyLabels;
		playerLabels = new GameLabelContext(coordinates[i2] + i).getLabel();
		enemyLabels = new GameLabelContext(coordinates[i2] + i).getLabel();

		if (playerLabels instanceof GameLabelBlank
				&& enemyLabels instanceof GameLabelBlank) {
			GameLabelBlank player = (GameLabelBlank) playerLabels;
			player.addMouseListener(new PlayerLabelClicked(player));
			GameLabelBlank enemy = (GameLabelBlank) enemyLabels;
			enemy.addMouseListener(new EnemyLabelClicked(enemy));
			playerBoard.put(coordinates[i2] + i, player);
			enemyBoard.put(coordinates[i2] + i, enemy);
		}

		playerPanel.add((JLabel) playerLabels);
		enemyPanel.add((JLabel) enemyLabels);
	}

	private void makeMidPanel() {
		boats.setLayout(new GridLayout(5, 0));
		boats.add(destroyer);
		boats.add(cruiser);
		boats.add(submarine);
		boats.add(battleship);
		boats.add(aircraftCarrier);

		statusText = new JTextArea();
		statusText.setBackground(Color.black.brighter());
		statusText.setForeground(Color.green.darker());
		statusText.setBounds(235, 178, 200, 100);
		mainPanel.add(statusText);

		exit.setBounds(193, 718, 121, 59);
		ready.setBounds(244, 397, 200, 96);

		Font font = new Font("Verdana", Font.BOLD, 12);

		statusText.setFont(font);
		statusText.setEditable(false);

		ready.setIcon(new ImageIcon("Pictures//buttonRed.gif"));
		ready.setBorderPainted(false);
		ready.setFocusable(false);
		ready.setContentAreaFilled(false);

		exit.setIcon(new ImageIcon("Pictures//exitButton.gif"));
		exit.setBorderPainted(false);
		exit.setFocusable(false);
		exit.setContentAreaFilled(false);

		ready.addActionListener(new StartGameListener());
		exit.addActionListener(new ExitGameOption(this));

		mainPanel.add(ready);
		mainPanel.add(exit);
		new TextTypingRobot(
				"Welcome to Battleship!Please drag your ships to the board and place them where you want them to be located",
				statusText);

	}

	public static GameState getGameState() {
		return GameGUI.state;
	}

	public static void updateBoard() {
		String temp;
		GameLabelBlank glb;
		System.out.println("---------");
		for (BoardLocation bl : state.getBoard().getLocations()) {
			temp = bl.getId();
			if (bl.getPiece() != null || playerBoard.containsKey(temp)) {
				try {

					System.out.println(bl.getPiece().getId());
					glb = playerBoard.get(temp);
					glb.changeColor(Color.black);
					glb.setOpaque(true);
					glb.repaint();
					glb.click();
				} catch (Exception e) {
					System.out.println("fel");
				}

			}
		}
		System.out.println("---------");
	}

}
