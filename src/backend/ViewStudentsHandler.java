package backend;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import frontend.EnrollScreen;
import frontend.HomeScreen;

public class ViewStudentsHandler implements ActionListener{
    
    JFrame window;
    JButton button;

    public ViewStudentsHandler(JFrame window, JButton button) {
        this.window = window;
        this.button = button;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button) {
            if (button.getText().equals("Return Home")) {
                HomeScreen buttonScreen = new HomeScreen(window);
                buttonScreen.DrawScreen();
            }
            else {
                EnrollScreen enrollScreen = new EnrollScreen(window);
                enrollScreen.DrawScreen();
            }
        }
    }
}
