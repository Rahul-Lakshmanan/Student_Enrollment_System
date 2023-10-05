package frontend;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

import backend.ViewStudentsHandler;

public class DatabaseScreen {
    
    private JFrame window;
    private JPanel information;
    private JPanel buttons;
    private JButton home;
    private JButton enroll;

    private String id;
    private String name;
    private String grade;
    private String classes;
    private String cost;

    public DatabaseScreen(JFrame window) {
        this.window = window;
        File file = new File("studentDatabase.txt");

        // information panel
        information = new JPanel();
        information.setLayout(new GridBagLayout());
        information.setBounds(50, 20, 700, 430);
        information.setBackground(Color.cyan);

        // read database
        String currentLine;
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(0, 5, 0, 5);
        gbc.gridy = 0;

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("studentDatabase.txt"))){
            if (file.length() != 0) {
                while ((currentLine = bufferedReader.readLine()) != null) {
                    gbc.gridx = 0;

                    // read current line
                    int firstSpace = currentLine.indexOf(" ");
                    id = currentLine.substring(0, firstSpace);
                    id.trim();
                    JLabel idLabel = CreateLabel(id);
                    information.add(idLabel, gbc);
                    ++gbc.gridx;
                    
                    int startFirstname = firstSpace + 3;
                    int endLastname = currentLine.indexOf(" ", currentLine.indexOf(" ", startFirstname) + 1);
                    name = currentLine.substring(startFirstname, endLastname);
                    name.trim();
                    JLabel nameLabel = CreateLabel(name);
                    information.add(nameLabel, gbc);
                    ++gbc.gridx;
                    
                    int gradeIndex = endLastname + 2;
                    grade = currentLine.substring(gradeIndex, gradeIndex + 3);
                    grade.trim();
                    JLabel gradeLabel = CreateLabel(grade);
                    information.add(gradeLabel, gbc);
                    ++gbc.gridx;

                    classes = currentLine.substring(gradeIndex + 3, currentLine.indexOf("$"));
                    classes.trim();
                    JLabel classesLabel = CreateLabel(classes);
                    information.add(classesLabel, gbc);
                    ++gbc.gridx;

                    cost = currentLine.substring(currentLine.indexOf("$"));
                    cost.trim();
                    JLabel costLabel = CreateLabel(cost);
                    information.add(costLabel, gbc);

                    ++gbc.gridy;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // buttons panel
        buttons =  new JPanel();
        buttons.setLayout(new GridBagLayout());
        buttons.setBounds(50, 470, 700, 50);
        buttons.setOpaque(false);

        GridBagConstraints buttonConstraints = new GridBagConstraints();
        buttonConstraints.gridx = 0;
        buttonConstraints.gridy = 0;
        buttonConstraints.insets = new Insets(0, 15, 0, 15);     

        enroll = new JButton("Enroll Another");
        enroll.setPreferredSize(new Dimension(150, 50));
        enroll.setFont(new Font("Arial", Font.BOLD, 20));
        enroll.setForeground(Color.yellow);
        enroll.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
        enroll.setFocusable(false);
        enroll.addActionListener(new ViewStudentsHandler(window, enroll));
        buttons.add(enroll, buttonConstraints);
        
        home = new JButton("Return Home");
        home.setPreferredSize(new Dimension(150, 50));
        home.setFont(new Font("Arial", Font.BOLD, 20));
        home.setForeground(Color.blue);
        home.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
        home.setFocusable(false);
        home.addActionListener(new ViewStudentsHandler(window, home));
        ++buttonConstraints.gridx;
        buttons.add(home, buttonConstraints);
    }

    private JLabel CreateLabel(String text) {
        JLabel label = new JLabel(text);
        label.setFont(new Font("arial", Font.PLAIN, 15));
        return label;
    }

    public void DrawScreen() {
        window.getContentPane().removeAll();
        window.add(information);
        window.add(buttons);
        window.revalidate();
        window.repaint();
    }

}
