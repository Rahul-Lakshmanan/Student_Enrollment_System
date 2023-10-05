package backend;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import frontend.DatabaseScreen;
import frontend.DetailsScreen;
import frontend.EnrollScreen;

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
            DetailsScreen detailsScreen = new DetailsScreen(window);
            detailsScreen.DrawScreen();
        } 
        else if (e.getSource() == enroll) {
            EnrollScreen enrollScreen = new EnrollScreen(window);
            enrollScreen.DrawScreen();
        }
        else if (e.getSource() == viewStudents) {
            DatabaseScreen databaseScreen = new DatabaseScreen(window);
            databaseScreen.DrawScreen();
        }
    }
    
}