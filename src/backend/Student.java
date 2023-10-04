package backend;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Student {

    private String id;
    private String name;
    private String balance;
    private String grade = "9";
    private ArrayList<Course> classes;

    
    public Student() {
        String currentLine;
        File file = new File("studentDatabase.txt");
        int studentIdNumber = 9183810;

        // get student id
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("studentDatabase.txt"))){
            if (file.length() != 0) {
                while ((currentLine = bufferedReader.readLine()) != null) {
                    int firstSpace = currentLine.indexOf(" ");
                    String lastId = currentLine.substring(0, firstSpace);
                    studentIdNumber = Integer.parseInt(lastId);
                }
                ++studentIdNumber;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        this.id = String.valueOf(studentIdNumber);
        classes = new ArrayList<Course>();
    }

    public String Get_ID() { return id; }
    public String Get_Name() { return name; }
    public String Get_Grade() { return grade; }
    public String Get_Balance() { return balance; }
    public ArrayList<Course> Get_Classes() { return classes; }

    public void Set_Name(String name) { this.name = name; }
    public void Set_Grade(byte grade) {this.grade = String.valueOf(grade); }
    public void Set_Balance(int cost) { this.balance = String.valueOf(cost); }
    public void Add_Class(Course course) { classes.add(course); }
    public void Remove_Course(Course course) { classes.remove(course); }
}
