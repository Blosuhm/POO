package aula11.grades;

import java.util.List;

public class SimpleGradeCalculator implements GradeCalculator {

    @Override
    public double calculate(List<Double> grades) {
        double sum = 0;
        for (Double grade : grades) {
            sum += grade;
        }
        return sum / grades.size();
    }
}
