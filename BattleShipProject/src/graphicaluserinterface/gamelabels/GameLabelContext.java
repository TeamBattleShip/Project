package graphicaluserinterface.gamelabels;

import java.util.HashMap;

public class GameLabelContext {
	private HashMap<Character, GameLabelStrategy> container;
	private String strategy;

	public GameLabelContext(String strategy) {
		this.strategy = strategy;
		container = new HashMap<Character, GameLabelStrategy>();
		container.put(' ', new GameLabelPrintNumbers(strategy));
		container.put('0', new GameLabelLetter(strategy));
		container.put('-', new GameLabelFilled(strategy));
	}

	public GameLabelStrategy getLabel() {

		if (strategy.substring(1).equals("11"))
			return new GameLabelFilled(strategy);

		if (checkIfContainsKey(strategy.charAt(0))) {
			return getStrategy(strategy.charAt(0));
		}

		if (checkIfContainsKey(strategy.charAt(1))) {
			return getStrategy(strategy.charAt(1));
		}

		return new GameLabelBlank(strategy);
	}

	private GameLabelStrategy getStrategy(char c) {
		return container.get(c);
	}

	private boolean checkIfContainsKey(char c) {
		return container.containsKey(c);
	}
}
