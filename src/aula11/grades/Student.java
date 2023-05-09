package aula11.grades;

import java.util.List;

public class Student {

    private String name;
    private List<Double> grades;

    public Student(String name, List<Double> grades) {
        this.name = name;
        this.grades = grades;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Double> getGrades() {
        return grades;
    }

    public void setGrades(List<Double> grades) {
        this.grades = grades;
    }

    @Override
    public String toString() {
        return "Student [name=" + name + ", grades=" + grades + "]";
    }
}
