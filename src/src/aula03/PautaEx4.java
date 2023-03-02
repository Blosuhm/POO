package src.aula03;

import src.aula03.utils.Utils;

public class PautaEx4 {
    public static void main(String[] args) {
        int students = 0;
        students = Integer.parseInt(Utils.input("Insira o número de alunos da turma: "));

        double[][] grades = new double[students][2];
        for (int i = 0; i < grades.length; i++) {
            grades[i][0] = decimalRound(randomizer(0, 20), 1);
            grades[i][1] = decimalRound(randomizer(0, 20), 1);
        }

        printResults(grades);
    }

    private static double randomizer(double start, double end) {
        return Math.random() * (end - start) + start;
    }

    private static double decimalRound(double number, int decimalPlaces) {
        return Math.round(number * Math.pow(10, decimalPlaces)) / Math.pow(10, decimalPlaces);
    }

    private static int[] calculateFinalGrades(double[][] grades) {
        int[] finalGrades = new int[grades.length];
        for (int i = 0; i < grades.length; i++) {
            if (grades[i][0] < 7 || grades[i][1] < 7) {
                finalGrades[i] = 66;
                continue;
            }
            finalGrades[i] = (int) Math.round(grades[i][0] * 0.4 + grades[i][1] * 0.6);
        }
        return finalGrades;
    }

    private static void printResults(double[][] grades) {
        int[] finalGrades = calculateFinalGrades(grades);
        Utils.print("NotaT NotaP Pauta");
        for (int i = 0; i < grades.length; i++) {
            Utils.print(String.format("%5s %5s %5s", grades[i][0], grades[i][1], finalGrades[i]));
        }

    }
}
