import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;

public class StartStop {

    Terminal terminal;

    public StartStop(Terminal terminal) {
        this.terminal = terminal;
    }

    public void start() throws Exception {

        printStartScreen();
        KeyStroke keyStroke = null;

        do {
            Thread.sleep(5);
            keyStroke = terminal.pollInput();
        } while (keyStroke == null);

        terminal.clearScreen();
    }

    private void printStartScreen() throws Exception {
        terminal.setCursorPosition(30, 15);
        terminal.putCharacter('\u2605');
    }
}
