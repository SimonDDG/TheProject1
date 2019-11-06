import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.terminal.Terminal;

import java.util.ArrayList;
import java.util.List;

public class Snake {

    private Position pos;
    private List<Position> posses = new ArrayList<>();
    private int move;
    private int direction = 1;

    //växa
    //KeyInput

    public void printSnake(){
//
//        posses.add(new )
//        for (int i = 0; i < wallLength; i++) {
//            wall.add(new Pos(5, 5 + i));
//        }
    }

    public void constantMove() {
        if (move % 50 == 0) {
            moving();
            move = 0;
        }
        move++;
    }

    public void moving(){

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

    public void input(KeyStroke keyStroke){

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

}
