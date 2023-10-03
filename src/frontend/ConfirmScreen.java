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

import backend.Course;
import backend.EnrollScreenHandler;
import backend.Student;

public class ConfirmScreen {

    private JFrame window;
    private JPanel information;
    private JPanel buttons;

    private JButton cancel;
    private JButton enroll;

    
    public ConfirmScreen(JFrame window, Student student) {
        this.window = window;

        // information panel
        information = new JPanel();
        information.setLayout(new GridBagLayout());
        information.setBounds(100, 75, 580, 300);
        information.setBackground(Color.LIGHT_GRAY);

        // fill first column
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.gridx = 0;

        gbc.gridy = 0;
        JLabel id = Make_Label("Student ID:", Font.BOLD);
        information.add(id, gbc);

        ++gbc.gridy;
        JLabel name = Make_Label("Name:", Font.BOLD); 
        information.add(name, gbc);

        ++gbc.gridy;
        JLabel grade = Make_Label("Grade:", Font.BOLD);
        information.add(grade, gbc);

        ++gbc.gridy;
        gbc.gridheight = student.Get_Classes().size();
        gbc.fill = GridBagConstraints.VERTICAL;
        JLabel courses = Make_Label("Registered Courses:", Font.BOLD); 
        information.add(courses, gbc);

        gbc.gridy += student.Get_Classes().size();
        gbc.gridheight = 1;
        JLabel balance = Make_Label("Balance:", Font.BOLD); 
        information.add(balance, gbc);

        // fill second column
        gbc.gridx = 1;
        gbc.gridy = 0;
        JLabel studentID = Make_Label(student.Get_ID(), Font.PLAIN);
        information.add(studentID, gbc);

        ++gbc.gridy;
        JLabel studentName = Make_Label(student.Get_Name(), Font.PLAIN);
        information.add(studentName, gbc);

        ++gbc.gridy;
        JLabel studentGrade = Make_Label(student.Get_Grade(), Font.PLAIN);
        information.add(studentGrade, gbc);

        gbc.insets = new Insets(0, 7, 0, 0);
        for (Course course : student.Get_Classes()) {
            ++gbc.gridy;
            String title = course.GetName().getText() + " (" + course.GetCode().getText() + ")";
            JLabel courseName = Make_Label(title, Font.ITALIC);
            information.add(courseName, gbc);
        }

        ++gbc.gridy;
        gbc.insets = new Insets(5, 5, 5, 5);
        JLabel totalCost = Make_Label("$" + student.Get_Balance(), Font.PLAIN);
        information.add(totalCost, gbc);

        // buttons panel
        buttons = new JPanel();
        buttons.setLayout(new GridBagLayout());
        buttons.setBounds(195, 400, 400, 50);
        buttons.setOpaque(false);

        GridBagConstraints buttonConstraints = new GridBagConstraints();
        buttonConstraints.insets = new Insets(0, 20, 0, 20);
        buttonConstraints.gridx = 0;
        buttonConstraints.gridy = 0;
        
        cancel = new JButton("Cancel");
        cancel.setPreferredSize(new Dimension(150, 50));
        cancel.setFont(new Font("Arial", Font.BOLD, 20));
        cancel.setForeground(Color.red);
        cancel.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
        cancel.setFocusable(false);
        cancel.addActionListener(new EnrollScreenHandler(cancel, window, student));
        buttons.add(cancel, buttonConstraints);

        buttonConstraints.gridx++;
        enroll = new JButton("ENROLL");
        enroll.setPreferredSize(new Dimension(150, 50));
        enroll.setFont(new Font("Arial", Font.BOLD, 20));
        enroll.setForeground(Color.green);
        enroll.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
        enroll.setFocusable(false);
        enroll.addActionListener(new EnrollScreenHandler(cancel, window, student));
        buttons.add(enroll, buttonConstraints);
    }

    public void DrawScreen() {
        window.getContentPane().removeAll();
        window.add(information);
        window.add(buttons);
        window.revalidate();
        window.repaint();
    }

    private JLabel Make_Label(String name, int font) {
        JLabel label = new JLabel(name);
        label.setFont(new Font(name, font, 17));
        return label;
    }
}
