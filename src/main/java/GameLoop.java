import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;
import java.util.Random;

public class GameLoop {

    Terminal terminal;
    int randomX;
    int randomY;


    public GameLoop(Terminal terminal) {
        this.terminal = terminal;
    }

    // KeyInput


    // Call print wall method


    // Snake moving


    // Snake growing


    // Randomising an acceptable new apple position
    public Position createApplePosition() {

        Random r = new Random();

        // Do-while loop to check if x,y clashes with snake body
        // While clash is true, a new randomised position will be created
        while (true)
            randomX = r.nextInt(80);    // set boundaries within the wall
            randomY = r.nextInt(24);    // set boundaries within the wall
            if (randomNewAppleKrockarInteMedSnake) {
                break;
            }
        }

        // Creating a position with acceptable randomised x,y
        Position positionApple = new Position(randomX, randomY);
        return positionApple;
    } // END createApplePosition()


    // Printing new apple
    public void printApple() throws IOException {
        Position p = createApplePosition();
        terminal.setCursorPosition(p.getX(), p.getY());
        terminal.putCharacter('APPLESYMBOL');
        terminal.flush();
    }


    // Keep score AND Remove old apple (to be called from snake growing method)


    // Check if snake eats itself = game over


    // Check if snake hits wall = game over


}
