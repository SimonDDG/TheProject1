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
                break;
            case 2: //ner
                break;
            case 3: //vänster
                break;
            case 4: //höger
                break;
            default:
                terminal.close();
        }
    }

    public void input(KeyStroke keyStroke) throws IOException {

        KeyType type = keyStroke.getKeyType();

        switch (type) {
            case ArrowUp:
                direction = 1;
                //Rörelse upp y-1
                break;
            case ArrowDown:
                direction = 2;
                //Rörelse ner y+1
                break;
            case ArrowLeft:
                direction = 3;
                //rörelse vänster x-1
                break;
            case ArrowRight:
                direction = 4;
                //rörelse höger x+1
                break;
            case Escape:
//                continueReadingInput = false;
                System.out.println("quit");
                terminal.close();
        }
    }

    private void printStuff(Position p) throws Exception {
        terminal.setCursorPosition(p.getX(), p.getY());
        terminal.putCharacter('\u2588');
    }

}
