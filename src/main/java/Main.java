import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory();
        Terminal terminal = terminalFactory.createTerminal();

        terminal.setCursorVisible(false);

        Apple apple = new Apple(terminal);
        Arena arena = new Arena(terminal);
        Snake snake = new Snake(terminal);
        GameLoop test = new GameLoop(terminal, apple);


        arena.printWall();

    }
}
