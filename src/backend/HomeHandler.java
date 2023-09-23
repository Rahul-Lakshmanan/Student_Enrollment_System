package backend;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import frontend.DetailsScreen;

public class HomeHandler implements ActionListener{

    JFrame window;
    JButton details;
    JButton enroll;
    JButton viewStudents;

    public HomeHandler(JFrame window, JButton[] buttons) {
        this.window = window;
        this.details = buttons[0];
        this.enroll = buttons[1];
        this.viewStudents = buttons[2];
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == details) {
            window.getContentPane().removeAll();
            DetailsScreen detailsScreen = new DetailsScreen(window);
            detailsScreen.DrawScreen();
        }
    }
    
}
