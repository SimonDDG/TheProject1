import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws Exception {
        DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory();
        Terminal terminal = terminalFactory.createTerminal();

        terminal.setCursorVisible(false);

        Apple apple = new Apple(terminal);
        Arena arena = new Arena(terminal);
        Snake snake = new Snake(terminal, arena);
        GameLoop gameLoop = new GameLoop(terminal, apple, arena, snake);
        StartStop startStop = new StartStop(terminal);

        startStop.start();
        gameLoop.runGame();

        //if
        terminal.clearScreen();
        terminal.setCursorPosition(25, 12);
        terminal.setBackgroundColor(TextColor.ANSI.GREEN);
        terminal.setForegroundColor(TextColor.ANSI.MAGENTA);
        String gameOver = "GAME OVER";
        for (int i = 0; i < gameOver.length(); i++) {
            terminal.putCharacter(gameOver.charAt(i));
        }
        terminal.flush();
    }


}

