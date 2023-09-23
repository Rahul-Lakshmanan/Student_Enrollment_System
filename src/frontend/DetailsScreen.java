package frontend;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

import backend.DetailsHandler;

public class DetailsScreen {
    
    JFrame window;
    JPanel textBackground;
    JPanel backPanel;
    JButton back;

    public DetailsScreen(JFrame window) {
        this.window = window;
        
        // text panel
        textBackground = new JPanel();
        textBackground.setLayout(new GridBagLayout());
        textBackground.setBackground(new Color(WindowFrame.GREY));
        textBackground.setBounds(100, 75, 580, 250);
        GridBagConstraints gbc = new GridBagConstraints();

        // text
        String text1 = "This is a fake student management system where you can";
        String text2 = "enroll \"students\" into a school. Simply hit the ENROLL";
        String text3 = "button on the home screen and enter in the student's information.";
        String text4 = "Once enrolled, the student's information will be saved and can be";
        String text5 = "viwed under \"View Student\" on the home screen.";

        gbc.gridx = 0;
        JLabel line1 = new JLabel("WELCOME!");
        line1.setFont(new Font(null, Font.BOLD, 30));
        line1.setForeground(new Color(WindowFrame.LIGHT_GREEN));
        gbc.gridy = 0;
        textBackground.add(line1, gbc);
        
        JLabel line2 = MakeLineLabel(text1);
        gbc.gridy = 1;
        textBackground.add(line2, gbc);

        JLabel line3 = MakeLineLabel(text2);
        gbc.gridy = 2;
        textBackground.add(line3, gbc);

        JLabel line4 = MakeLineLabel(text3);
        gbc.gridy = 3;
        textBackground.add(line4, gbc);

        JLabel line5 = MakeLineLabel(text4);
        gbc.gridy = 4;
        textBackground.add(line5, gbc);

        JLabel line6 = MakeLineLabel(text5);
        gbc.gridy = 5;
        textBackground.add(line6, gbc);

        // back panel
        backPanel = new JPanel();
        backPanel.setLayout(new BoxLayout(backPanel, BoxLayout.Y_AXIS));
        backPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        backPanel.setBounds((int)(WindowFrame.WINDOW_WIDTH / 2 - 50), 375, 100, 50);

        // back button
        ImageIcon image = new ImageIcon(new ImageIcon("assets/back_button.png").getImage().
                                        getScaledInstance(100, 50, Image.SCALE_DEFAULT));
        back = new JButton();
        back.setIcon(image);
        back.addActionListener(new DetailsHandler(window, back));
        back.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
        back.setFocusable(false);
        backPanel.add(back);
    }

    public void DrawScreen() {
        window.getContentPane().removeAll();
        window.add(textBackground);
        window.add(backPanel);
        window.revalidate();
        window.repaint();
    }

    private JLabel MakeLineLabel(String text) {
        JLabel line = new JLabel(text);
        line.setFont(new Font(null, Font.PLAIN, 19));
        line.setForeground(Color.white);
        return line;
    }
}
