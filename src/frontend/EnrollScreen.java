package frontend;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;

import backend.Course;
import backend.EnrollScreenHandler;
import backend.Student;


public class EnrollScreen {

    public static JLabel totalCost = new JLabel();

    Student student = new Student();
    JFrame window;

    JPanel studentInfo = new JPanel();
    JPanel classes = new JPanel();
    JPanel buttons = new JPanel();

    JTextField firstName = new JTextField("Firstname");
    JTextField lastName = new JTextField("Lastname");

    Byte[] gradeNumbers = {9, 10, 11, 12};
    JComboBox grade =  new JComboBox(gradeNumbers);

    JButton confirm = new JButton("Confirm");
    JButton cancel = new JButton("Cancel");


    public EnrollScreen(JFrame window) {
        this.window = window;
        GridBagConstraints gbc = new GridBagConstraints();

        // student information panel
        gbc.gridy = 0;
        gbc.insets = new Insets(0, 10, 0, 10);

        studentInfo.setLayout(new GridBagLayout());
        studentInfo.setOpaque(false);
        studentInfo.setBounds(100, 105, 580, 54);

        gbc.gridx = 0;
        firstName.setPreferredSize(new Dimension(150, 35));
        firstName.setFont(new Font("times new roman", Font.PLAIN, 18));
        firstName.setForeground(Color.gray);
        studentInfo.add(firstName, gbc);

        gbc.gridx = 1;
        lastName.setPreferredSize(new Dimension(150, 35));
        lastName.setFont(new Font("times new roman", Font.PLAIN, 18));
        lastName.setForeground(Color.gray);
        studentInfo.add(lastName, gbc);

        gbc.gridx = 2;
        gbc.insets = new Insets(0, 30, 0, 10);
        grade.setSelectedIndex(0);
        grade.setPreferredSize(new Dimension(45, 30));
        studentInfo.add(grade, gbc);

        firstName.addFocusListener(new EnrollScreenHandler(firstName, student));
        lastName.addFocusListener(new EnrollScreenHandler(lastName, student));
        grade.addActionListener(new EnrollScreenHandler(grade, student));

        // classes panel
        classes.setLayout(new GridBagLayout());
        classes.setBackground(Color.lightGray);
        classes.setBounds(100, 155, 580, 275);
        classes.setBorder(BorderFactory.createLineBorder(Color.black, 4));

        // headers
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.insets = new Insets(20, -5, 5, 5);
        JLabel classCode = NewLabel("Class Code", Font.BOLD);
        classes.add(classCode, gbc);

        gbc.gridx = 2;
        JLabel className = NewLabel("Class Title", Font.BOLD);
        classes.add(className, gbc);

        gbc.gridx = 3;
        gbc.ipadx = 20;
        gbc.insets = new Insets(20, 0, 5, 5);
        JLabel cost = NewLabel("Cost", Font.BOLD);
        classes.add(cost, gbc);

        // add classes
        Course history = new Course("HIS 101", "American History 1700 - 1900", 
                                    (short) 100, classes, student);
        AddCourseLabels(history, gbc, (byte) 1);
    
        Course math = new Course("MAT 108", "Discrete Mathematics", 
                                (short) 110, classes, student);
        AddCourseLabels(math, gbc, (byte) 2);

        Course writing = new Course("UWP 101", "Advanced Composition Writing", 
                                    (short) 120, classes, student);
        AddCourseLabels(writing, gbc, (byte) 3);
        
        Course cs = new Course("ECS 152A", "Computer Networks", 
                                (short) 150, classes, student);
        AddCourseLabels(cs, gbc, (byte) 4);

        Course programming = new Course("ECS 140A", "Programming Languages", 
                                        (short) 150, classes, student);
        AddCourseLabels(programming, gbc, (byte) 5);

        Course research = new Course("ECS 199", "HPC Research Lab", 
                                    (short) 200, classes, student);
        AddCourseLabels(research, gbc, (byte) 6);

        // total cost
        totalCost.setText("Total Balance: $" + String.valueOf(Course.attendanceCost));
        totalCost.setFont(new Font("times new roman", Font.ITALIC, 17));
        gbc.gridx = 2;
        gbc.gridy = 7;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 193, 10, 0);
        classes.add(totalCost, gbc);
        
        // buttons panel
        buttons.setLayout(new GridBagLayout());
        buttons.setBounds(100, 430, 580, 75);
        buttons.setOpaque(false);

        GridBagConstraints buttonConstraints = new GridBagConstraints();
        buttonConstraints.gridy = 0;
        buttonConstraints.gridx = 0;
        buttonConstraints.insets = new Insets(0, 0, 0, 30);
        cancel.setPreferredSize(new Dimension(150, 50));
        cancel.setFont(new Font("Arial", Font.BOLD, 20));
        cancel.setForeground(Color.red);
        cancel.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
        cancel.setFocusable(false);
        cancel.addActionListener(new EnrollScreenHandler(cancel, window, student));
        buttons.add(cancel, buttonConstraints);

        buttonConstraints.gridx = 1;
        buttonConstraints.insets = new Insets(0, 30, 0, 0);
        confirm.setPreferredSize(new Dimension(150, 50));
        confirm.setFont(new Font("Arial", Font.BOLD, 20));
        confirm.setForeground(Color.green);
        confirm.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
        confirm.setFocusable(false);
        confirm.addActionListener(new EnrollScreenHandler(confirm, window, student));
        buttons.add(confirm, buttonConstraints);
    }

    private JLabel NewLabel(String text, int fontType) {
        JLabel label = new JLabel(text);

        label.setFont(new Font("arial", fontType, 25));;
        label.setBackground(Color.lightGray);
        label.setOpaque(true);

        return label;
    }

    private void AddCourseLabels(Course course, GridBagConstraints gbc, byte y) {
        // add checkbox
        gbc.insets = new Insets(0, 0, 0, 0);
        gbc.gridx = 0;
        gbc.gridy = y;
        classes.add(course.GetCheckBox(), gbc);

        // add class code
        gbc.insets = new Insets(2, 0, 2, 5);
        gbc.gridx = 1;
        classes.add(course.GetCode(), gbc);

        // add class title
        gbc.gridx = 2;
        classes.add(course.GetName(), gbc);

        // add class cost
        gbc.gridx = 3;
        gbc.ipadx = 20;
        classes.add(course.GetCostLabel(), gbc);

    }

    public void DrawScreen() {
        window.getContentPane().removeAll();

        window.add(studentInfo);
        window.add(classes);
        window.add(buttons);

        window.revalidate();
        window.repaint();
    }
}
