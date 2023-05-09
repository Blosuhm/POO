package aula03;

import aula03.utils.Utils;

public class CalendarEx5 {

    public static void main(String[] args) {
        int[] input = getInputMonth();
        printCalendar(input[0], input[1], input[2]);
    }

    private static int[] getInputMonth() {
        int start = 0;
        int month = 0;
        int year = 0;

        do {
            String input = Utils.input("Insira o mês e o ano (MM/YYYY): ");
            String[] inputArray = input.split("/");

            if (inputArray.length != 2) {
                Utils.print("Input inválido!");
                continue;
            }

            month = Integer.parseInt(inputArray[0]);
            year = Integer.parseInt(inputArray[1]);

            if (month < 1 || month > 12) {
                Utils.print("Mês inválido!");
            }
        } while (month < 1 || month > 12);

        do {
            String input = Utils.input("Insira o dia da semana em que o mês começa (1-7): ");
            start = Integer.parseInt(input);
            if (start >= 1 && start <= 7) {
                break;
            }
            Utils.print("Input inválido!");
        } while (true);

        return new int[]{month, year, start};
    }

    private static int getDaysInMonth(int month, int year) {
        int days = 0;
        switch (month) {
            case 4:
            case 6:
            case 9:
            case 11:
                days = 30;
                break;
            case 2:
                if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
                    days = 29;
                    break;
                }
                days = 28;
                break;
            default:
                days = 31;
                break;
        }
        return days;
    }

    private static void printCalendar(int month, int year, int start) {
        String monthString = "";
        switch (month) {
            case 1:
                monthString = "Janeiro";
                break;
            case 2:
                monthString = "Fevereiro";
                break;
            case 3:
                monthString = "Março";
                break;
            case 4:
                monthString = "Abril";
                break;
            case 5:
                monthString = "Maio";
                break;
            case 6:
                monthString = "Junho";
                break;
            case 7:
                monthString = "Julho";
                break;
            case 8:
                monthString = "Agosto";
                break;
            case 9:
                monthString = "Setembro";
                break;
            case 10:
                monthString = "Outubro";
                break;
            case 11:
                monthString = "Novembro";
                break;
            case 12:
                monthString = "Dezembro";
                break;
        }

        String header = String.format("%20s", String.format("%s %d", monthString, year));
        String weekDays = "Su Mo Tu We Th Fr Sa";
        Utils.print(header);
        Utils.print(weekDays);

        for (int i = 0; i < start - 1; i++) {
            System.out.print("   ");
        }

        int days = getDaysInMonth(month, year);
        for (int i = 1; i <= days; i++) {
            System.out.printf("%2d ", i);
            if ((i + start - 1) % 7 == 0) {
                System.out.println();
            }
        }
    }
}
