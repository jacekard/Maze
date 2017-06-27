import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Jacek on 2017-06-17.
 */

public class Cell extends Object {

    public Maze maze;
    public boolean walls[] = {true, true, true, true};
    public ArrayList<Cell> neighbours;
    private Cell cell;
    public boolean visited;
    public int x;
    public int y;
    public boolean coined=false;
    public Sprite coin_sprite;

    public Cell(Maze maze, int x, int y) {
        this.maze = maze;
        if(this.maze.los(100)<10){
            this.coined=true;
        }
        sprite = new Sprite("src/Sprites/cell-full.png");
        coin_sprite = new Sprite("src/Sprites/coin.png");
        sprite.size = 150;
        visited = false;
        this.x = x;
        this.y = y;
    }

    public Cell getNeighbour() {

        neighbours = new ArrayList<>();

        if (maze.isValid(x + 1, y)) {
            cell = (Cell) maze.map[y][x + 1];
            if (!cell.visited)
                neighbours.add(cell);
        }

        if (maze.isValid(x,y - 1)) {
            cell = (Cell) maze.map[y - 1][x];
            if (!cell.visited)
                neighbours.add(cell);
        }

        if (maze.isValid(x, y + 1)) {
            cell = (Cell) maze.map[y + 1][x];
            if (!cell.visited)
                neighbours.add(cell);
        }

        if (maze.isValid(x - 1, y)) {
            cell = (Cell) maze.map[y][x - 1];
            if (!cell.visited)
                neighbours.add(cell);
        }



        if (neighbours.size() > 0) {
            cell = neighbours.get(maze.los(neighbours.size() - 1));

            if (this.x - cell.x == -1) {
                walls[3] = false;
                cell.walls[0] = false;
            } else if (this.x - cell.x == 1) {
                walls[0] = false;
                cell.walls[3] = false;
            }

            if (this.y - cell.y == -1) {
                walls[2] = false;
                cell.walls[1] = false;
            } else if (this.y - cell.y == 1) {
                walls[1] = false;
                cell.walls[2] = false;
            }

            this.removeWalls();
            cell.removeWalls();

            return cell;
        }

        return null;
    }

    public void removeWalls() {
        if (!walls[0] && walls[1] && walls[2] && walls[3])
            sprite = new Sprite("src/Sprites/cell-left.png");
        else if (walls[0] && walls[1] && walls[2] && !walls[3])
            sprite = new Sprite("src/Sprites/cell-right.png");
        else if (!walls[0] && walls[1] && walls[2] && !walls[3])
            sprite = new Sprite("src/Sprites/cell-left-right.png");
        else if (walls[0] && !walls[1] && walls[2] && walls[3])
            sprite = new Sprite("src/Sprites/cell-top.png");
        else if (walls[0] && walls[1] && !walls[2] && walls[3])
            sprite = new Sprite("src/Sprites/cell-bottom.png");
        else if (walls[0] && !walls[1] && !walls[2] && walls[3])
            sprite = new Sprite("src/Sprites/cell-top-bottom.png");
        else if (walls[0] && !walls[1] && walls[2] && !walls[3])
            sprite = new Sprite("src/Sprites/cell-right-top.png");
        else if (walls[0] && walls[1] && !walls[2] && !walls[3])
            sprite = new Sprite("src/Sprites/cell-right-bottom.png");
        else if (!walls[0] && !walls[1] && walls[2] && walls[3])
            sprite = new Sprite("src/Sprites/cell-left-top.png");
        else if (!walls[0] && walls[1] && !walls[2] && walls[3])
            sprite = new Sprite("src/Sprites/cell-left-bottom.png");
        else if (!walls[0] && walls[1] && !walls[2] && !walls[3])
            sprite = new Sprite("src/Sprites/cell-left-right-bottom.png");
        else if (!walls[0] && !walls[1] && walls[2] && !walls[3])
            sprite = new Sprite("src/Sprites/cell-left-right-top.png");
        else if (!walls[0] && !walls[1] && !walls[2] && walls[3])
            sprite = new Sprite("src/Sprites/cell-left-top-bottom.png");
        else if (walls[0] && !walls[1] && !walls[2] && !walls[3])
            sprite = new Sprite("src/Sprites/cell-right-top-bottom.png");


    }

}
