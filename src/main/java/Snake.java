import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Snake {

    private Position pos;
    private List<Position> posses = new ArrayList<>();
    private int move;
    private int direction = 1;
    private Terminal terminal;

    //växa
    //KeyInput


    public Snake(Terminal terminal) {
        this.terminal = terminal;
    }

    public void printSnake() throws Exception {
        createSnake();
        for (int i = 0; i < posses.size(); i++) {
            printStuff(posses.get(i));
        }
    }

    private void createSnake(){
        int originLength = 3;
        for (int i = 0; i < originLength; i++) {
            posses.add(new Position(20, 10 + i));
        }
    }

    public void constantMove() throws IOException {
        if (move == 50) {
            moving();
            move = 0;
        }
        move++;
    }

    public void moving() throws IOException {

        switch (direction){
            case 1: //upp
                System.out.println("Upp");
                break;
            case 2: //ner
                System.out.println("Ner");
                break;
            case 3: //vänster
                System.out.println("Vänster");
                break;
            case 4: //höger
                System.out.println("höger");
                break;
            default:
                terminal.close();
        }
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

    private void printStuff(Position p) throws Exception {
        terminal.setCursorPosition(p.getX(), p.getY());
        terminal.putCharacter('\u2588');
    }

}
