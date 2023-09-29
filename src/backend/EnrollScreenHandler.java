package backend;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import frontend.ConfirmScreen;
import frontend.EnrollScreen;
import frontend.HomeScreen;

public class EnrollScreenHandler implements ActionListener, FocusListener {

    private boolean isFirstname;
    private JTextField textField;

    private JButton button;
    private JFrame window;

    private JPanel panel;
    private Course course;

    private boolean isTextfield = false;
    private boolean isButton = false;
    private boolean isCourse = false;

    // handles textfield
    public EnrollScreenHandler(JTextField textField) { 
        this.textField = textField; 
        this.isTextfield = true;
        if (textField.getText().equals("Firstname"))
            this.isFirstname = true;
        else    
            this.isFirstname = false;
    }

    // handles buttons
    public EnrollScreenHandler(JFrame window, JButton button) { 
        this.window = window;
        this.button = button; 
        this.isButton = true;
    }

    // handles course checkboxes
    public EnrollScreenHandler(JPanel panel, Course course) {
        this.panel = panel;
        this.course = course;
        this.isCourse = true;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (isButton && e.getSource() == button) {
            if (button.getText().equals("Cancel")) {
                window.getContentPane().removeAll();
                HomeScreen home = new HomeScreen(window);
                home.DrawScreen();
            }
            if (button.getText().equals("Confirm")) {
                ConfirmScreen confirmScreen = new ConfirmScreen(window);
                confirmScreen.DrawScreen();
            }
        }

        if (isCourse) {
            if (course.GetCheckBox().isSelected()) 
                Course.attendanceCost += course.GetCost();
            else
                Course.attendanceCost -= course.GetCost();
            UpdateCost();
        }
    }

    @Override
    public void focusGained(FocusEvent e) {
        // clear placeholder text when clicked on
        if (isTextfield && e.getSource() == textField) { 
            if (textField.getText().equals("Firstname") || textField.getText().equals("Lastname"))
                textField.setText(""); 
        }
    }

    @Override
    public void focusLost(FocusEvent e) {
        // refill textfield placeholder if empty
        if (isTextfield && e.getSource() == textField && textField.getText().equals("")) {
            if (isFirstname) 
                textField.setText("Firstname");
            else 
                textField.setText("Lastname");
        }
    }

    private void UpdateCost() {
        panel.remove(EnrollScreen.totalCost);
        panel.revalidate();

        GridBagConstraints gbc = new GridBagConstraints();
        EnrollScreen.totalCost.setText("Total Balance: %" + String.valueOf(Course.attendanceCost));
        gbc.gridx = 2;
        gbc.gridy = 7;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 193, 10, 0);
        panel.add(EnrollScreen.totalCost, gbc);

        panel.revalidate();
        panel.repaint();
    }
}
