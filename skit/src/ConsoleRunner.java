import game.init.Runner;

/**
 *
 * @author thomas
 */
public class ConsoleRunner {

	public static void main(String[] args) {
		new Runner(new TttGameState(), new TttConsoleIoFactory()).run();
	}
}
