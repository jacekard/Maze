import javax.swing.*;
import java.util.Stack;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

/**
 * Created by Jacek on 2017-06-17.
 */
public class Maze {

    public Object[][] map;
    public int sizeX;
    public int sizeY;

    public Player player;
    public Cell current;
    public Cell next;
    public Stack<Cell> stack;
    public Screen screen;
    public boolean isSet = false;
    public boolean isPlayer = false;

    public Maze(Screen screen) {

        sizeX = 10;
        sizeY = 10;
        this.screen = screen;
        map = new Object[sizeY][sizeX];
        stack = new Stack<Cell>();

        for (int i = 0; i < sizeY; i++) {
            for (int j = 0; j < sizeX; j++) {
                map[i][j] = new Cell(this, j, i);
            }
        }

        current = (Cell) map[0][0];
        current.visited = true;
        //current.sprite = new Sprite("src/Sprites/cell-initial.png");


    }

    public void Generate() {
        boolean finish = false;
        while (!finish) {
            next = current.getNeighbour();
            if (next != null) {
                stack.push(current);
                current = next;
                current.visited = true;
                //current.sprite = new Sprite("src/Sprites/debug.png");
            } else if (stack.size() > 0) {
                current = stack.peek();
                stack.pop();
                //current.sprite = new Sprite("src/Sprites/debug2.png");
            } else {
                finish = true;
            }
        }
        player = new Player(this);
        isPlayer = true;
    }


    public boolean isValid(int x, int y) {
        if (x < 0 || (x > sizeX - 1) || y < 0 || (y > sizeY - 1))
            return false;
        else
            return true;
    }

    public int los(int a) {
        return ThreadLocalRandom.current().nextInt(0, a + 1);
    }

    public void czekaj() {
        try {
            Thread.sleep(10);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }

    }

}
