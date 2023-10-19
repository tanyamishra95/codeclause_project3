import java.io.*;
import java.util.ArrayList;

class Student {
    String name;
    int id;
    double feePaid;

    public Student(String name, int id, double feePaid) {
        this.name = name;
        this.id = id;
        this.feePaid = feePaid;
    }
}

public class FeeReport {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();

        // Sample data (you can replace this with your own data)
        students.add(new Student("John", 101, 5000.0));
        students.add(new Student("Jane", 102, 6000.0));
        students.add(new Student("Bob", 103, 5500.0));

        generateReport(students);
    }

    public static void generateReport(ArrayList<Student> students) {
        try {
            FileWriter writer = new FileWriter("fee_report.txt");
            writer.write("Student ID\tStudent Name\tFee Paid\n");

            for (Student student : students) {
                writer.write(student.id + "\t" + student.name + "\t" + student.feePaid + "\n");
            }

            writer.close();
            System.out.println("Fee report generated successfully.");
        } catch (IOException e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
    }
}