import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;

public class Apple {

    Terminal terminal;
    Snake snake;
    final char apple = 'o';
    int appleX;
    int appleY;
    int keepScore = 0;

    Position applePosition = new Position(appleX, appleY);
    //test


    //Äpplet hämtar arena position
    //Äpplet hämtar snake position --> häntar Snake ArrayList<Position>
    //Äpplet kollar dessa position innan print.

    public Apple(Terminal terminal) throws IOException {
        this.terminal = terminal;
    }

    public void putAppleAndScore() throws IOException {
        System.out.println("SKRIVER ÄPPLE");
        int randomNumberX = ThreadLocalRandom.current().nextInt(2, 78);
        int randomNumberY = ThreadLocalRandom.current().nextInt(2, 23);
        appleX = randomNumberX;
        appleY = randomNumberY;
        applePosition.setX(appleX);
        applePosition.setY(appleY);
        terminal.setCursorPosition(appleX, appleY);
        terminal.putCharacter(apple);

        String score = "Score: ";
        for (int i = 0; i < score.length(); i++) {
            terminal.setCursorPosition(0+i,0);
            terminal.putCharacter(score.charAt(i));
        }

        String keepScoreString = Integer.toString(keepScore);
        if (keepScore < 10) {
        for (int i = 0; i < keepScoreString.length(); i++) {
            terminal.setCursorPosition(7, 0);
            terminal.putCharacter(keepScoreString.charAt(i));
        }

        }
        if (keepScore >= 10) {
            keepScoreString = "1";
            terminal.setCursorPosition(7, 0);
            terminal.putCharacter(keepScoreString.charAt(0));
            terminal.setCursorPosition(8,0);
            terminal.putCharacter(Integer.toString(keepScore).charAt(1));
        }
        if (keepScore >= 20) {
            keepScoreString = "2";
            terminal.setCursorPosition(7, 0);
            terminal.putCharacter(keepScoreString.charAt(0));
            terminal.setCursorPosition(8,0);
            terminal.putCharacter(Integer.toString(keepScore).charAt(1));

        }

        keepScore++;
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
