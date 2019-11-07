import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;

public class Apple {

    Terminal terminal;
    Snake snake;
    final char apple = 'o';
    int randomNumberX = ThreadLocalRandom.current().nextInt(1, 79);
    int randomNumberY = ThreadLocalRandom.current().nextInt(1, 24);
    int appleX = randomNumberX;
    int appleY = randomNumberY;
    //test


    //Äpplet hämtar arena position
    //Äpplet hämtar snake position --> häntar Snake ArrayList<Position>
    //Äpplet kollar dessa position innan print.

    public Apple(Terminal terminal) throws IOException {
        this.terminal = terminal;
    }

    public void putApple() throws IOException {
            terminal.setCursorPosition(appleX, appleY);
            terminal.putCharacter(apple);
    }

    public void spawnApple(int x, int y) throws IOException {
//        if (appleX == x && appleY == y) {
//            spawnApple(snake.snakePositions.get(0).getX(), snake.snakePositions.get(0).getY());
//            putApple();
//        } else System.out.println("");
//    }


//        Random r = new Random();
//        Position applePosition = new Position(r.nextInt(20), r.nextInt(30));
//        terminal.setCursorPosition(applePosition.x, applePosition.y);
//        terminal.putCharacter(apple);
//
//        terminal.flush();

    }
}
