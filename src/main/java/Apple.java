import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;

public class Apple {

    Terminal terminal;
    final char apple = 'o';
    int appleX;
    int appleY;

    Position applePosition = new Position(appleX, appleY);
    //test


    //Äpplet hämtar arena position
    //Äpplet hämtar snake position --> häntar Snake ArrayList<Position>
    //Äpplet kollar dessa position innan print.

    public Apple(Terminal terminal) throws IOException {
        this.terminal = terminal;
    }

    public void putApple() throws IOException {
        System.out.println("SKRIVER ÄPPLE");

        boolean isSnake = true;

        do {
            System.out.println("NYTT RANDOM NUMMER");
//            int randomNumberX = ThreadLocalRandom.current().nextInt(2, 78);
//            int randomNumberY = ThreadLocalRandom.current().nextInt(2, 23);

            int randomNumberX = ThreadLocalRandom.current().nextInt(25, 30);
            int randomNumberY = ThreadLocalRandom.current().nextInt(15, 20);
            appleX = randomNumberX;
            appleY = randomNumberY;

            for (int i = 0; i < Snake.getPos().size(); i++) {
                if (appleX != Snake.getPos().get(i).getX() && appleY != Snake.getPos().get(i).getY()) {
                    isSnake = false;
                }
            }

        } while (isSnake);

        applePosition.setX(appleX);
        applePosition.setY(appleY);

        terminal.setCursorPosition(appleX, appleY);
        terminal.putCharacter(apple);
    }

    public Position getApplePosition() {
        return applePosition;
    }

    public void spawnApple(int x, int y) throws IOException {
//        if (appleX == x && appleY == y) {
//            spawnApple(snake.snakePositions.get(0).getX(), snake.snakePositions.get(0).getY());
//            putApple();
//        } else System.out.println("");
//    }

// SAMI
//        Random r = new Random();
//        Position applePosition = new Position(r.nextInt(20), r.nextInt(30));
//        terminal.setCursorPosition(applePosition.x, applePosition.y);
//        terminal.putCharacter(apple);
//
//        terminal.flush();

    }
}
