import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory();
        Terminal terminal = terminalFactory.createTerminal();

        Apple apple = new Apple(terminal);

      /*  terminal.setCursorPosition(1, 1);
        terminal.putCharacter('A');
        terminal.flush();

*/
    }
}
