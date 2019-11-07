import com.googlecode.lanterna.TextColor;
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
        terminal.setCursorPosition(25, 10);
        terminal.setBackgroundColor(TextColor.ANSI.BLACK);
        terminal.setForegroundColor(TextColor.ANSI.GREEN);
        String startGame = "ARE YOU READY TO PLAY SNAKE?\n\n \t\t\t\t\t\tPRESS ENTER TO START THE GAME";
        for (int i = 0; i < startGame.length(); i++) {
            terminal.putCharacter(startGame.charAt(i));
        }
            terminal.flush();
            terminal.resetColorAndSGR();
    }
}
