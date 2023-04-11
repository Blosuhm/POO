package aula05;

import java.util.Scanner;

public class CalendarMenu {
    private static Calendar calendar = null;

    public static void main(String[] args) {
        int choice = 0;

        do {
            listOptions();
            choice = inputChoice();
            selector(choice);

        } while (choice != 0);
    }

    private static void listOptions() {
        System.out.println("Select an option:");
        System.out.println("1 - Create new calendar");
        System.out.println("2 - Print calendar month");
        System.out.println("3 - Print Calendar");
        System.out.println("0 - Exit");
        System.out.print("Your choice: ");
    }

    private static boolean calendarExists() {
        return calendar != null;
    }

    private static int inputChoice() {
        String validInput = "^[0-3]$";
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        if (!input.matches(validInput)) {
            System.out.println("Invalid input. Try again.");
            return inputChoice();
        }
        System.out.println();
        return Integer.parseInt(input);
    }

    private static void selector(int choice) {
        switch (choice) {
        case 1:
            createNewCalendar();
            break;
        case 2:
            printMonth();
            break;
        case 3:
            printCalendar();
            break;
        case 0:
            System.out.println("Goodbye!");
            break;
        default:
            System.out.println("Invalid Choice");
        }
    }

    private static void createNewCalendar() {
        String validInput = "^\\d{1,4} [1-7]$";

        System.out.print("Enter the year and the first day of the year (YYYY, D (1-7)): ");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine().trim();
        if (!input.matches(validInput)) {
            System.out.println("Invalid input. Try again.");
            return;
        }
        String[] inputArray = input.split(" ");
        int year = Integer.parseInt(inputArray[0]);
        int firstWeekDay = Integer.parseInt(inputArray[1]);
        calendar = new Calendar(year, firstWeekDay);
    }

    private static void printMonth() {
        String validInput = "^([1-9]|1[0-2])$";
        System.out.print("Month (1-12): ");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        if (!input.matches(validInput)) {
            System.out.println("Invalid input. Try again.");
            return;
        }
        System.out.println(calendar.printMonth(Integer.parseInt(input)));
        System.out.println();

    }

    private static void printCalendar() {
        System.out.println(calendar);
    }

}
