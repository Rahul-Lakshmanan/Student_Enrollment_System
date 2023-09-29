package frontend;

import java.awt.Color;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class ConfirmScreen {

    private JFrame window;
    private JPanel information;
    private JPanel buttons;

    
    public ConfirmScreen(JFrame window) {
        this.window = window;

        information = new JPanel();
        information.setLayout(new GridBagLayout());
        information.setBounds(100, 75, 580, 250);
        information.setBackground(Color.LIGHT_GRAY);

    }


    public void DrawScreen() {
    }
}
