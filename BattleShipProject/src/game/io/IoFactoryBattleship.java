package game.io;

public class IoFactoryBattleship implements IoFactory {
	private InputUnit inputUnit = new InputUnitBattleship();
	private OutputUnit outputUnit = new OutputUnitBattleship();

	@Override
	public InputUnit getInputUnit() {
		return inputUnit;
	}

	@Override
	public OutputUnit getOutputUnit() {	
		return outputUnit;
	}
}
