import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.terminal.Terminal;

public class StartStop {

    Terminal terminal;

    public StartStop(Terminal terminal) {
        this.terminal = terminal;
    }

    public void start() throws Exception {

        KeyStroke keyStroke = null;
        printStartScreen();

        do {
            Thread.sleep(5);
            keyStroke = terminal.pollInput();
        } while (keyStroke == null);
    }

    private void printStartScreen(){

    }
}
