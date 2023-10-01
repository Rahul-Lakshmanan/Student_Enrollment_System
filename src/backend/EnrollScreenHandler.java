package backend;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import frontend.ConfirmScreen;
import frontend.EnrollScreen;
import frontend.HomeScreen;

public class EnrollScreenHandler implements ActionListener, FocusListener {

    private Student student;

    private static JTextField firstname;
    private static JTextField lastname;
    private static JComboBox grade;

    private JButton button;
    private JFrame window;

    private JPanel panel;
    private Course course;

    private boolean isFirstname;
    private boolean isTextfield = false;
    private boolean isButton = false;
    private boolean isCourse = false;
    private boolean isGrade = false;

    // handles textfield
    public EnrollScreenHandler(JTextField textField, Student student) {  
        this.isTextfield = true;
        this.student = student;
        if (textField.getText().equals("Firstname")) {
            this.isFirstname = true;
            EnrollScreenHandler.firstname = textField;
        }
        else {
            this.isFirstname = false;
            EnrollScreenHandler.lastname = textField;
        }
    }

    // handles grade combobox
    public EnrollScreenHandler(JComboBox grade, Student student) {
        this.grade = grade;
        this.student = student;
        this.isGrade = true;
    }

    // handles buttons
    public EnrollScreenHandler(JButton button, JFrame window, Student student) { 
        this.window = window;
        this.button = button; 
        this.student = student;
        this.isButton = true;
    }

    // handles course checkboxes
    public EnrollScreenHandler(Course course, JPanel panel, Student student) {
        this.panel = panel;
        this.course = course;
        this.student = student;
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
                student.Set_Name(EnrollScreenHandler.firstname.getText() + EnrollScreenHandler.lastname.getText());
                student.Set_Balance(Course.attendanceCost);
                
                ConfirmScreen confirmScreen = new ConfirmScreen(window);
                confirmScreen.DrawScreen();
            }
        }

        if (isCourse) {
            if (course.GetCheckBox().isSelected()) {
                Course.attendanceCost += course.GetCost();
                student.Add_Class(course);
            }
            else {
                Course.attendanceCost -= course.GetCost();
                student.Add_Class(course);
            }
            UpdateCost();
        }

        if (isGrade && e.getSource() == grade) 
            student.Set_Grade((byte) grade.getSelectedItem());
    }

    @Override
    public void focusGained(FocusEvent e) {
        // clear placeholder text when clicked on
        if (isTextfield && e.getSource() == firstname) { 
            if (firstname.getText().equals("Firstname"))
                firstname.setText(""); 
        }
        else if (isTextfield) {
            if (lastname.getText().equals("Lastname")) 
                lastname.setText("");
        }
    }

    @Override
    public void focusLost(FocusEvent e) {
        // refill textfield placeholder if empty
        if (isTextfield && e.getSource() == firstname) { 
            if (firstname.getText().equals(""))
                firstname.setText("Firstname"); 
        }
        else if (isTextfield) {
            if (lastname.getText().equals("")) 
                lastname.setText("Lastname");
        }
    }

    private void UpdateCost() {
        panel.remove(EnrollScreen.totalCost);
        panel.revalidate();

        GridBagConstraints gbc = new GridBagConstraints();
        EnrollScreen.totalCost.setText("Total Balance: $" + String.valueOf(Course.attendanceCost));
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
