package aula11.grades;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Gradebook implements IGradebook {

    private final Set<Student> gradebook;

    public Gradebook() {
        this.gradebook = new HashSet<>();
    }

    @Override
    public void load(String filename) throws FileNotFoundException {
        Scanner sc = new Scanner(new File(filename));
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            String[] parts = line.split("\\|");
            String name = parts[0];
            List<Double> grades = new ArrayList<>();
            for (int i = 1; i < parts.length; i++) {
                grades.add(Double.parseDouble(parts[i]));
            }
            Student student = new Student(name, grades);
            gradebook.add(student);
        }
    }

    @Override
    public void removeStudent(String studentName) {
        for (Student student : gradebook) {

            if (student.getName().equals(studentName)) {
                gradebook.remove(student);
                break;
            }
        }

    }

    @Override
    public void addStudent(Student student) {
        gradebook.add(student);
    }

    @Override
    public Student getStudent(String name) {
        for (Student student : gradebook) {
            if (student.getName().equals(name)) {
                return student;
            }
        }
        return null;
    }

    @Override
    public double calculateAverageGrade(String studentName) {
        SimpleGradeCalculator calculator = new SimpleGradeCalculator();
        for (Student student : gradebook) {
            if (student.getName().equals(studentName)) {
                return calculator.calculate(student.getGrades());
            }
        }
        return -1;
    }

    @Override
    public void printAllStudents() {
        for (Student student : gradebook) {
            System.out.println(student);
        }
    }
}
