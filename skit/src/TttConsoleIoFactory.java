
import game.io.InputUnit;
import game.io.IoFactory;
import game.io.OutputUnit;

/**
 *
 * @author thomas
 */
public class TttConsoleIoFactory implements IoFactory {

    InputUnit inputUnit = new TttConsoleInputUnit();
    OutputUnit outputUnit = new TttConsoleOutputUnit();

    @Override
    public InputUnit getInputUnit() {
        return inputUnit;
    }

    @Override
    public OutputUnit getOutputUnit() {
        return outputUnit;
    }

}
