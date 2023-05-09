package aula07.date;

import java.util.Scanner;

public class DateYMDMenu {

    private static Date date = null;

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
        System.out.println("1 - Create new date");
        System.out.println("2 - Show current date");
        System.out.println("3 - Increment date");
        System.out.println("4 - Decrement date");
        System.out.println("0 - Exit");
        System.out.print("Your choice: ");
    }

    private static int inputChoice() {
        String validInput = "^[0-4]$";
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
                createNewDate();
                break;
            case 2:
                showCurrentDate();
                break;
            case 3:
                incrementDate();
                break;
            case 4:
                decrementDate();
                break;
            case 0:
                System.out.println("Goodbye!");
                break;
            default:
                System.out.println("Invalid Choice");
        }
    }

    private static void createNewDate() {
        String validInput = "^\\d{1,4} \\d{1,2} \\d{1,2}$";
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter date (year month day): ");
        String input = sc.nextLine().trim();
        if (!input.matches(validInput)) {
            System.out.println("Invalid input. Try again.");
            return;
        }
        String[] inputArray = input.split(" ");
        int year = Integer.parseInt(inputArray[0]);
        int month = Integer.parseInt(inputArray[1]);
        int day = Integer.parseInt(inputArray[2]);
        date = new DateND(day, month, year);
        System.out.println("Date created: " + date);
        System.out.println();
    }

    private static boolean dateExists() {
        if (date == null) {
            System.out.println("No date created yet.");
            return false;
        }
        return true;
    }

    private static void showCurrentDate() {
        if (!dateExists()) {
            return;
        }
        System.out.println("Current date: " + date);
        System.out.println();
    }

    private static void incrementDate() {
        if (!dateExists()) {
            return;
        }
        date.incrementDay();
    }

    private static void decrementDate() {
        if (!dateExists()) {
            return;
        }
        date.decrementDay();
    }

}
