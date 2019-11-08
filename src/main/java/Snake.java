import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;
import java.util.ArrayList;

public class Snake {

    private static ArrayList<Position> snakePositions = new ArrayList<>();
    private int counter = 0;
    private int direction = 1;
    private Terminal terminal;
    private int level = 15; // Går att ändra svårighetsgrad om man ändra level
    private int growLevel = 3;
    boolean clash = false;
    Arena arena;
    int changeX = 0;
    int changeY = 0;
    private Apple apple;
    private boolean endGame = false;
    private StartStop startStop;
    private Position applePos;

    public Snake(Terminal terminal, Arena arena, Apple apple, StartStop startStop) throws Exception {
        this.terminal = terminal;
        this.arena = arena;
        this.apple = apple;
        this.startStop = startStop;
        createSnake();
    }

    public void printSnake() throws Exception {

        for (int i = 0; i < snakePositions.size(); i++) {
            Position p  = snakePositions.get(i);
            terminal.setCursorPosition(p.getX(), p.getY());
            terminal.putCharacter('\u25a0');
        }
        eraseTail();
    }

    private void createSnake() throws Exception {
        int originLength = 10;

        for (int i = 0; i < originLength; i++) {
            snakePositions.add(new Position(20, 10 + i));
        }
    }

    private void updateSnake() throws Exception {
        Position gamlaHuvudet = snakePositions.get(0);
        Position nyaHuvudet = new Position(gamlaHuvudet.getX() + changeX, gamlaHuvudet.getY() + changeY);
        snakePositions.add(0, nyaHuvudet);
        snakePositions.remove(snakePositions.size() - 1);
    }

    public void checkSnakeBody () throws Exception {
        int newX = snakePositions.get(0).getX();
        int newY = snakePositions.get(0).getY();

        for (int i = 1; i < snakePositions.size()-1; i++){
            if (newX == snakePositions.get(i).getX() && newY == snakePositions.get(i).getY()) {
                endGame();
            }
        }
    }

    public void checkWall() throws Exception {
        int newX = snakePositions.get(0).getX();
        int newY = snakePositions.get(0).getY();

        clash = arena.isWall(newX, newY);
        if (clash) {
           endGame();
        }
    }

    public void endGame() throws Exception {
        this.direction = 0;
    }

    public void constantMove() throws Exception {

        if (counter == level) {
            moving();
            counter = 0;
        }
        counter++;
    }

    private void moving() throws Exception {

        checkWall();
        checkSnakeBody();

        switch (direction){
            case 1: //upp
                changeX = 0;
                changeY = -1;
                updateSnake();
                printSnake();
                break;
            case 2: //ner
                changeX = 0;
                changeY = 1;
                updateSnake();
                printSnake();
                break;
            case 3: //vänster
                changeX = -1;
                changeY = 0;
                updateSnake();
                printSnake();
                break;
            case 4: //höger
                changeX = 1;
                changeY = 0;
                updateSnake();
                printSnake();
                break;
            default:
                endGame = true;
        }
        terminal.flush();
    }

    public void readInput(KeyStroke keyStroke) throws IOException {

        KeyType type = keyStroke.getKeyType();

        switch (type) {
            case ArrowUp:
                if (direction == 2) {
                    break;
                } else {
                    direction = 1;
                    break;
                }
            case ArrowDown:
                if (direction == 1) {
                    break;
                } else {
                    direction = 2;
                    break;
                }
            case ArrowLeft:
                if (direction == 4) {
                    break;
                } else {
                    direction = 3;
                    break;
                }
            case ArrowRight:
                if (direction == 3) {
                    break;
                } else {
                    direction = 4;
                    break;
                }
            case Escape:
                endGame = true;
        }
    }

    private void eraseTail() throws Exception {
        Position p = snakePositions.get(snakePositions.size()-1);
        terminal.setCursorPosition(p.getX(), p.getY());
        terminal.putCharacter(' ');
    }

    public void grow() throws Exception {
        applePos = apple.getApplePosition();
        if (snakePositions.get(0).getX() == applePos.getX() && snakePositions.get(0).getY() == applePos.getY()){
            apple.putAppleAndScore();
            terminal.flush();
            int antalSvans = growLevel; //för att testa att koden funkar, så ökar den med 10 svansar

            for (int i = 0; i < antalSvans; i++) {
                Position gamlaSvansen = snakePositions.get(snakePositions.size()-2);
                Position nyaSvansen = new Position(gamlaSvansen.getX() - changeX, gamlaSvansen.getY() - changeY);
                snakePositions.add(snakePositions.size()-2, nyaSvansen);
            }
        }
    }

    public boolean continuePlay() throws Exception {

        if (endGame) {
            MP3Player m = new MP3Player();
            m.play("Titanic.mp3");
            System.out.println("----> QUIT <----");
            startStop.printStopScreen();
            Thread.sleep(10000);
            terminal.close();
            m.stop("Titanic.mp3");
            return false;
        }
        return true;
    }

    static ArrayList<Position> getPos(){
        return snakePositions;
    }

}
