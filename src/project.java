/**
 * Created by Jacek on 2017-06-17.
 */

import java.awt.*;

public class project {
    public static void main(String []args) {

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Screen();
            }
        });


    }
}