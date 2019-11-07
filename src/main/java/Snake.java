import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Snake {

    private Position pos;
    private List<Position> snakePositions = new ArrayList<>();
    private int counter = 0;
    private int direction = 1;
    private Terminal terminal;
    private int level = 50; // Går att ändra svårighetsgrad om man ändra level
    boolean clash = false;
    Arena arena;


    //växa
    //KeyInput


    public Snake(Terminal terminal, Arena arena) throws Exception {
        this.terminal = terminal;
        this.arena = arena;
        createSnake();
    }

    public void printSnake() throws Exception {
        for (int i = 0; i < snakePositions.size(); i++) {

            Position p  = snakePositions.get(i);

            terminal.setCursorPosition(p.getX(), p.getY());
            terminal.putCharacter('\u2588');
        }
        eraseTail();
    }

    private void createSnake() throws Exception {
        int originLength = 10;
        for (int i = 0; i < originLength; i++) {
            snakePositions.add(new Position(20, 10 + i));
        }
    }

    private void updateSnake(int changeX, int changeY){

        Position gamlaHuvudet = snakePositions.get(0);
        Position nyaHuvudet = new Position(gamlaHuvudet.getX() + changeX, gamlaHuvudet.getY() + changeY);
        snakePositions.add(0, nyaHuvudet);
        snakePositions.remove(snakePositions.size() - 1);

        // Call check snake clash method, if snake eats itself = game over
    }

    // SAMI 6
    public void checkClash() throws Exception {
        int newX = snakePositions.get(0).getX();
        int newY = snakePositions.get(0).getY();

        for (Position p : snakePositions) {

        }
        clash = arena.isWall(newX, newY);
        if (clash) {
           endGame();
        }
    }

    public void endGame() throws Exception {
        this.direction = 0;
    }

    // END SAMI 6

    public void constantMove() throws Exception {

        if (counter == level) {
            moving();
            counter = 0;
        }
        counter++;
    }

    public void moving() throws Exception {

        switch (direction){
            case 1: //upp
                updateSnake(0, -1);
                printSnake();
                System.out.println("Upp");
                break;
            case 2: //ner
                updateSnake(0, 1);
                printSnake();
                System.out.println("Ner");
                break;
            case 3: //vänster
                updateSnake(-1, 0);
                printSnake();
                System.out.println("Vänster");
                break;
            case 4: //höger
                updateSnake(1, 0);
                printSnake();
                System.out.println("höger");
                break;
            default:
                terminal.close();
        }
        terminal.flush();
    }

    public boolean readInput(KeyStroke keyStroke) throws IOException {

        KeyType type = keyStroke.getKeyType();

        switch (type) {
            case ArrowUp:
                if (direction == 2) {
                    System.out.println("Byter inte till upp");
                    break;
                } else {
                    direction = 1;
                    System.out.println("Rörelse upp y-1");
                    break;
                }
            case ArrowDown:
                if (direction == 1) {
                    System.out.println("Byter inte till ner");
                    break;
                } else {
                    direction = 2;
                    System.out.println("Rörelse ner y+1");
                    break;
                }
            case ArrowLeft:
                if (direction == 4) {
                    System.out.println("Byter inte till vänster");
                    break;
                } else {
                    direction = 3;
                    System.out.println("rörelse vänster x-1");
                    break;
                }
            case ArrowRight:
                if (direction == 3) {
                    System.out.println("Byter inte till höger");
                    break;
                } else {
                    direction = 4;
                    System.out.println("rörelse höger x+1");
                    break;
                }
            case Escape:
                System.out.println("----> QUIT <----");
                terminal.close();
                return false;
        }
        return true;
    }

    private void eraseTail() throws Exception {
        Position p = snakePositions.get(snakePositions.size()-1);
        terminal.setCursorPosition(p.getX(), p.getY());
        terminal.putCharacter(' ');

    }

}
