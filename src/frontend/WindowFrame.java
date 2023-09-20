package frontend;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class WindowFrame extends JFrame {
    public final static int LIGHT_GREEN = 0xAFFCCE;
    public final static int GREY = 0x4C4D4C;
    public final static int WINDOW_WIDTH = 800;
    public final static int WINDOW_HEIGHT = 600;

    public WindowFrame() {
        // create window
        this.setTitle("School Enrollment");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));
        this.setResizable(false);
        this.getContentPane().setBackground(new Color(LIGHT_GREEN));

        // set window icon
        ImageIcon image = new ImageIcon("assets/school_icon.png");
        this.setIconImage(image.getImage());

        this.setVisible(true);
    }
}
