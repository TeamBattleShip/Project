package graphicaluserinterface.robot;

import javax.swing.JTextArea;

public class TextTypingRobot extends Thread {
	private String stringToWrite;
	private JTextArea textArea;
	private int numberofchars;

	public TextTypingRobot(String stringToWrite, JTextArea textArea) {
		this.stringToWrite = stringToWrite;
		this.textArea = textArea;
		textArea.setText("");
		start();
	}

	public String type(char c) {
		try {
			Thread.sleep(50);
		} catch (InterruptedException ex) {
			Thread.currentThread().interrupt();
		}
		if (c == '.' || c == '!' || c == '?') {
			numberofchars = 0;
			return c + "\n";
		}
		return "" + c;
	}

	@Override
	public void run() {
		for (Character c : stringToWrite.toCharArray()) {
			numberofchars++;
			if (checkIfNewRow())
				textArea.setText(textArea.getText() + "\n");
			textArea.setText(textArea.getText() + type(c));
			textArea.repaint();
		}
	}

	private boolean checkIfNewRow() {
		if (numberofchars > 28) {
			numberofchars = 0;
			return true;
		}
		return false;
	}

}
