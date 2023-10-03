package backend;

import java.util.ArrayList;

public class Student {

    public static int studentIdNumber = 9183810;

    private String id;
    private String name;
    private String balance;
    private String grade;
    private ArrayList<Course> classes;

    
    public Student() {
        this.id = String.valueOf(studentIdNumber);
        ++ studentIdNumber;
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
