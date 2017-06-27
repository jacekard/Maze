import javax.swing.*;
import java.awt.*;

import static java.lang.StrictMath.abs;

/**
 * Created by Jacek on 2017-06-17.
 */

public class DrawPanel extends JPanel {
    private int img_size;
    private Maze maze;
    private int size;

    DrawPanel(Maze maze) {
        this.maze = maze;

        setLayout(null);
        setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        img_size = (abs((int)screenSize.getWidth()/maze.sizeX - (int)screenSize.getHeight()/maze.sizeY))+10;
        setPreferredSize(new Dimension(maze.sizeX*img_size, maze.sizeY*img_size));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
            for (int y = 0; y < maze.sizeY; y++) {
                for (int x = 0; x < maze.sizeX; x++) {
                    if (maze.map[y][x] != null) {

                        g.drawImage(
                                maze.map[y][x].sprite.img.getScaledInstance(img_size, img_size, Image.SCALE_DEFAULT),
                                img_size * x,
                                img_size * y,
                                this);
                        if(((Cell)maze.map[y][x]).coined && maze.isPlayer){
                            g.drawImage(
                                    ((Cell)maze.map[y][x]).coin_sprite.img.getScaledInstance(img_size, img_size, Image.SCALE_DEFAULT),
                                    maze.los(1)+img_size * x,
                                    maze.los(1)+img_size * y,
                                    this);
                        }
                    }

                }
            }

        if (maze.player != null) {
            g.drawImage(maze.player.sprite.img.getScaledInstance(img_size, img_size, Image.SCALE_DEFAULT),
                    img_size * maze.player.x,
                    img_size * maze.player.y,
                    this);
        }
    }
}
