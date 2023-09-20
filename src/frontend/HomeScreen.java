package frontend;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;


public class HomeScreen {

    JButton[] buttons = {new JButton("Details"), new JButton("ENROLL"), new JButton("View Students")};
    JPanel titlePanel = new JPanel();
    JPanel buttonPanel = new JPanel();

    public HomeScreen() {
        // title panel
        titlePanel.setLayout(new GridBagLayout());
        titlePanel.setBackground(new Color(WindowFrame.GREY));
        titlePanel.setBounds((int)((WindowFrame.WINDOW_WIDTH - 550) / 2), 
                             (int)((WindowFrame.WINDOW_HEIGHT / 3) - 100 / 2), 550, 100);

        // title label
        JLabel title = new JLabel();
        title.setText("Enroll Your Students");
        title.setFont(new Font("times new roman", Font.BOLD, 50));
        title.setForeground(Color.green);
        titlePanel.add(title);

        // buttons panel
        buttonPanel.setLayout(new GridBagLayout());
        buttonPanel.setOpaque(false);;
        buttonPanel.setBounds((int)((WindowFrame.WINDOW_WIDTH - 550) / 2), 
                              (int)((WindowFrame.WINDOW_HEIGHT / 3) + 100 / 2), 550, 100);
        GridBagConstraints gbc = new GridBagConstraints();

        // make buttons
        short position = 0;
        for (JButton button : buttons) {
            // appearance
            button.setFont(new Font("Arial", Font.BOLD, 15));
            button.setPreferredSize(new Dimension(130, 50));
            button.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
            button.setFocusable(false);

            // location on grid
            gbc.gridx = position;
            gbc.gridy = 0;

            // spacing between buttons
            if (button.getText().equals("Details"))
                gbc.insets = new Insets(40, 0, 10, 30);
            else if (button.getText().equals("ENROLL"))
                gbc.insets = new Insets(40, 10, 10, 10);
            else if (button.getText().equals("View Students"))
                gbc.insets = new Insets(40, 30, 10, 0);
            
            position++;
            buttonPanel.add(button, gbc);
        }
    }

    public void DrawScreen(JFrame window) {
        window.getContentPane().removeAll();
        window.add(titlePanel);
        window.add(buttonPanel);
        window.revalidate();
        window.repaint();
    }
}
