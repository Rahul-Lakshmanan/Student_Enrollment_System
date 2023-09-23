package backend;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import frontend.HomeScreen;

public class DetailsHandler implements ActionListener{

    JFrame window;
    JButton back;

    public DetailsHandler(JFrame window, JButton back) {
        this.window = window;
        this.back = back;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == back) {
            window.getContentPane().removeAll();
            HomeScreen home = new HomeScreen(window);
            home.DrawScreen();
        }
    }
    
}
