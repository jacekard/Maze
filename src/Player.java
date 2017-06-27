/**
 * Created by Jacek on 2017-06-18.
 */
public class Player extends Object {
    public int x;
    public int y;
    public Maze maze;
    public int size=1;

    public Player(Maze maze) {
        x = 0;
        y = 0;
        sprite = new Sprite("src/Sprites/dingiel.png");
        this.maze = maze;
        //maze.map[0][0] = this;
    }
    public void przeladuj(){
        if(this.size==5){
            sprite = new Sprite("src/Sprites/dingielusus.png");
        }else if(this.size==7){
            sprite = new Sprite("src/Sprites/wolololo.png");
        }
    }

    public void ruch(int x, int y, int w) {
        //0 left, 1 top, 2 bottom, 3 right
        if (maze.isValid(this.x+x, this.y+y)) {
            //maze.map[this.y][this.x] = null;
            if(((Cell)maze.map[this.y][this.x]).walls[w]==false) {
                this.x += x;
                this.y += y;
            }
            if(((Cell)maze.map[this.y][this.x]).coined){
                ((Cell)maze.map[this.y][this.x]).coined=false;
                this.size+=1;
                this.przeladuj();
            }
            //maze.map[this.y][this.x] = this;
        }


    }
}
