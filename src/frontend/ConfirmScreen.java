package frontend;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ConfirmScreen {

    private JFrame window;
    private JPanel information;
    private JPanel buttons;

    private JButton cancel;
    private JButton enroll;

    
    public ConfirmScreen(JFrame window) {
        this.window = window;

        // information panel
        information = new JPanel();
        information.setLayout(new GridBagLayout());
        information.setBounds(100, 75, 580, 250);
        information.setBackground(Color.LIGHT_GRAY);

        GridBagConstraints gbc = new GridBagConstraints();
        JLabel id = new JLabel("Student ID:");
        id.setFont(new Font("arial", Font.BOLD, 20));

        JLabel name = new JLabel("Name:");
        name.setFont(new Font("arial", Font.BOLD, 20)); 

        // buttons panel
        buttons = new JPanel();
        buttons.setLayout(new GridBagLayout());
        buttons.setBounds(195, 375, 400, 50);
        buttons.setBackground(Color.red);
    }


    public void DrawScreen() {
        window.getContentPane().removeAll();
        window.add(information);
        window.add(buttons);
        window.revalidate();
        window.repaint();
    }
}
