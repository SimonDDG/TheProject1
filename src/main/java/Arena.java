import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;
import java.util.ArrayList;

public class Arena {

    Terminal terminal;

    public ArrayList<Position> wall1 = new ArrayList<>();
    public ArrayList<Position> wall2 = new ArrayList<>();
    public ArrayList<Position> wall3 = new ArrayList<>();
    public ArrayList<Position> wall4 = new ArrayList<>();

    public Arena(Terminal terminal) {
        this.terminal = terminal;
    }

    public void createWall() {
        int wall1Lenght = 26;
        for (int i = 0; i < wall1Lenght; i++) {
            wall1.add(new Position(0, 1+i));
        }
        int wall2Lenght = 80;
        for (int i = 0; i < wall2Lenght; i++) {
            wall2.add(new Position( 0+i, 1));
        }
        int wall3Lenght = 26;
        for (int i = 0; i < wall3Lenght; i++) {
            wall3.add(new Position(80, 1+i));
        }
        int wall4Lenght = 80;
        for (int i = 0; i < wall4Lenght; i++) {
            wall4.add(new Position(0+i, 80));
        }
    }

    public void printWall() throws IOException {

        createWall();

        for (int i = 0; i < wall1.size(); i++) {
            terminal.setCursorPosition(wall1.get(i).getX(), wall1.get(i).getY());
            terminal.putCharacter('\u2588');
        }
        for (int i = 0; i < wall2.size(); i++) {
            terminal.setCursorPosition(wall2.get(i).getX(), wall2.get(i).getY());
            terminal.putCharacter('\u2588');
        }
        for (int i = 0; i < wall3.size(); i++) {
            terminal.setCursorPosition(wall3.get(i).getX(), wall3.get(i).getY());
            terminal.putCharacter('\u2588');
        }
        for (int i = 0; i < wall4.size(); i++) {
            terminal.setCursorPosition(wall4.get(i).getX(), wall4.get(i).getY());
            terminal.putCharacter('\u2588');
        }

    }

    public boolean isWall(int x, int y) {

        for (int i = 0; i < wall1.size(); i++) {
            if (wall1.get(i).getX() == x && wall1.get(i).getY() == y) {
                return true;
            }
        }
        for (int i = 0; i < wall2.size(); i++) {
            if (wall2.get(i).getX() == x && wall2.get(i).getY() == y) {
                return true;
            }
        }
        for (int i = 0; i < wall3.size(); i++) {
            if (wall3.get(i).getX() == x && wall3.get(i).getY() == y) {
                return true;
            }
        }
        for (int i = 0; i < wall4.size(); i++) {
            if (wall4.get(i).getX() == x && wall4.get(i).getY() == y) {
                return true;
            }
        }
        return false;
    }
}
