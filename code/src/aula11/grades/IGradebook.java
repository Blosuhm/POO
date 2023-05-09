package aula11.grades;

import java.io.FileNotFoundException;

public interface IGradebook {

    void load(String filename) throws FileNotFoundException;

    void removeStudent(String studentName);

    void addStudent(Student student);

    Student getStudent(String name);

    double calculateAverageGrade(String studentName);

    void printAllStudents();
}
