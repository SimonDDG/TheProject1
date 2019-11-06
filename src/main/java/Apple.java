import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;
import java.util.Random;

public class Apple {

    Terminal terminal;
    final char apple = 'o';

    //Äpplet hämtar arena position
    //Äpplet hämtar snake position --> häntar Snake ArrayList<Position>
    //Äpplet kollar dessa position innan print.

    public Apple(Terminal terminal) throws IOException {
        this.terminal = terminal;
    }

    public void putApple() throws IOException {
        Random r = new Random();
        Position applePosition = new Position(r.nextInt(20), r.nextInt(30));
        terminal.setCursorPosition(applePosition.x, applePosition.y);
        terminal.putCharacter(apple);

        terminal.flush();

    }


}
