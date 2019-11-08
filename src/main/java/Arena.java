import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;
import java.util.ArrayList;

public class Arena {

    Terminal terminal;

    public ArrayList<Position> leftWall = new ArrayList<>();
    public ArrayList<Position> topWall = new ArrayList<>();
    public ArrayList<Position> rightWall = new ArrayList<>();
    public ArrayList<Position> bottomWall = new ArrayList<>();

    public Arena(Terminal terminal) {
        this.terminal = terminal;
    }

    public void createWall() {
        int wall1Lenght = 26;
        for (int i = 0; i < wall1Lenght; i++) {
            leftWall.add(new Position(0, 1+i));
        }
        int wall2Lenght = 80;
        for (int i = 0; i < wall2Lenght; i++) {
            topWall.add(new Position( 0+i, 1));
        }
        int wall3Lenght = 26;
        for (int i = 0; i < wall3Lenght; i++) {
            rightWall.add(new Position(80, 1+i));
        }
        int wall4Lenght = 80;
        for (int i = 0; i < wall4Lenght; i++) {
            bottomWall.add(new Position(0+i, 80));
        }
    }

    public void printWall() throws IOException {

        createWall();

        //Vänstra väggen = wall1
        for (int i = 0; i < leftWall.size(); i++) {
            terminal.setCursorPosition(leftWall.get(i).getX(), leftWall.get(i).getY());
            terminal.putCharacter('\u2588');
        }

        //Övre väggen = wall2
        for (int i = 0; i < topWall.size(); i++) {
            terminal.setCursorPosition(topWall.get(i).getX(), topWall.get(i).getY());
            terminal.putCharacter('\u2588');
        }

        //Högra väggen = wall3
        for (int i = 0; i < rightWall.size(); i++) {
            terminal.setCursorPosition(rightWall.get(i).getX(), rightWall.get(i).getY());
            terminal.putCharacter('\u2588');
        }

        //Nedre väggen = wall4
        for (int i = 0; i < bottomWall.size(); i++) {
            terminal.setCursorPosition(bottomWall.get(i).getX(), bottomWall.get(i).getY());
            terminal.putCharacter('\u2588');
        }

    }

    public boolean isWall(int x, int y) {

        for (int i = 0; i < leftWall.size(); i++) {
            if (leftWall.get(i).getX() == x && leftWall.get(i).getY() == y) {
                return true;
            }
        }

        for (int i = 0; i < topWall.size(); i++) {
            if (topWall.get(i).getX() == x && topWall.get(i).getY() == y) {
                return true;
            }
        }
        for (int i = 0; i < rightWall.size(); i++) {
            if (rightWall.get(i).getX() == x && rightWall.get(i).getY() == y) {
                return true;
            }
        }
        for (int i = 0; i < bottomWall.size(); i++) {
            if (bottomWall.get(i).getX() == x && bottomWall.get(i).getY() == y) {
                return true;
            }
        }

        return false;
    }
}
