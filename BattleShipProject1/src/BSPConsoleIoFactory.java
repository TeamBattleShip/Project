import game.io.InputUnit;
import game.io.IoFactory;
import game.io.OutputUnit;

public class BSPConsoleIoFactory implements IoFactory{

    InputUnit inputUnit = new BSPConsoleInputUnit();
    OutputUnit outputUnit = new BSPOConsoleOutputUnit();
	
	@Override
	public InputUnit getInputUnit() {
		return inputUnit;
	}

	@Override
	public OutputUnit getOutputUnit() {
		return outputUnit;
	}

}
