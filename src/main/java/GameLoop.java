import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.terminal.Terminal;

import java.util.Random;

public class GameLoop {

    Terminal terminal;
    Apple apple;
    Arena arena;
    Snake snake;
    int randomX;
    int randomY;
    boolean running = true;


    public GameLoop(Terminal terminal, Apple apple, Arena arena, Snake snake) {
        this.terminal = terminal;
        this.apple = apple;
        this.arena = arena;
        this.snake = snake;
    }

    public void runGame() throws Exception {

        arena.printWall();
        snake.printSnake();
        apple.putAppleAndScore();
        terminal.flush();

        do {

            KeyStroke keyStroke = null;
            do {
                Thread.sleep(5);
                snake.constantMove();
//                snake.checkClash(); Flyttat till snake update metoden
                snake.grow();
                keyStroke = terminal.pollInput();

                running = snake.continuePlay();
            } while (keyStroke == null);

            snake.readInput(keyStroke);

        } while (running);

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
        while (true) {
            randomX = r.nextInt(80);    // set boundaries within the wall
            randomY = r.nextInt(24);    // set boundaries within the wall
//            if (randomNewAppleKrockarInteMedSnake) {
//                break;
//            }
            }
        }

        // Creating a position with acceptable randomised x,y
        Position positionApple = new Position(randomX, randomY);
//        return positionApple;
    } // END createApplePosition()


    // Keep score AND Remove old apple (to be called from snake growing method)


    // Check if snake eats itself = game over SAMI


    // Check if snake hits wall = game over SAMI



