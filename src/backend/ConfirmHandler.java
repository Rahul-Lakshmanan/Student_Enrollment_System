package backend;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;

import frontend.DatabaseScreen;

public class ConfirmHandler implements ActionListener{

    Student student;
    JButton enroll;
    JFrame window;

    public ConfirmHandler(JButton button, Student student, JFrame window) {
        this.enroll = button;
        this.student = student;
        this.window = window;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == enroll) {
            try {
                // save student information to student database
                FileWriter file = new FileWriter("studentDatabase.txt", true);
                BufferedWriter bufferedWriter = new BufferedWriter(file);
                bufferedWriter.write(student.Get_ID() + "   ");
                bufferedWriter.write(student.Get_Name() + "   ");
                bufferedWriter.write(student.Get_Grade() + "   ");

                for (Course course : student.Get_Classes()) {
                    if (student.Get_Classes().indexOf(course) == student.Get_Classes().size() - 1)
                        bufferedWriter.write(course.GetCode().getText());
                    else
                        bufferedWriter.write(course.GetCode().getText() + ", ");
                }
                
                bufferedWriter.write("   $" + student.Get_Balance() + "\n");
                bufferedWriter.close();
                file.close();

                // go to database view
                DatabaseScreen dataScreen = new DatabaseScreen(window);
                dataScreen.DrawScreen();
            } 
            catch (IOException e1) {
                System.out.println("ERROR: student save failed");
                e1.printStackTrace();
            }
        }
    }
}
