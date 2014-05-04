import game.init.Runner;

public class BSPConsoleRunner {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new Runner(new BSPGameState(), new BSPConsoleIoFactory()).run();
	}

}
