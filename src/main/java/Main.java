import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory();
        Terminal t = terminalFactory.createTerminal();

        GameLoop test = new GameLoop(t);
/*
        terminal.setCursorPosition(1, 1);
        terminal.putCharacter('A');
        terminal.flush();

        */

    }
}
