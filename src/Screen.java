import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by Jacek on 2017-06-17.
 */
public class Screen extends JFrame implements KeyListener {
    public JFrame frame;
    public Maze maze;
    public Dimension size;

    public Screen() {
        super("-- Maze --");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //frame.getContentPane().setBackground(Color.GRAY);
        //setExtendedState(JFrame.MAXIMIZED_BOTH);

        addKeyListener(this);
        setSize(500, 500);
        frame = new JFrame();
        maze = new Maze(this);

        JPanel panel = new DrawPanel(maze);
        add(panel);
        pack();

        setVisible(true);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);


    }

    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        switch (code) {
            case KeyEvent.VK_SPACE:
                maze.Generate();
                break;
            case KeyEvent.VK_UP:
                if (maze.isPlayer)
                    maze.player.ruch(0, -1, 1);
                break;
            case KeyEvent.VK_DOWN:
                if (maze.isPlayer)
                    maze.player.ruch(0, 1, 2);
                break;
            case KeyEvent.VK_LEFT:
                if (maze.isPlayer)
                    maze.player.ruch(-1, 0, 0);
                break;
            case KeyEvent.VK_RIGHT:
                if (maze.isPlayer)
                    maze.player.ruch(1, 0, 3);
                break;
        }
        validate();
        repaint();
    }

    public void keyReleased(KeyEvent e) {
    }

    public void keyTyped(KeyEvent e) {
    }

}
