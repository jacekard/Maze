/**
 * Created by Jacek on 2017-06-17.
 */

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Sprite {

    public BufferedImage img;
    public int size;

    public Sprite(String path) {
        size = 50;
        try {
            img = ImageIO.read(new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
