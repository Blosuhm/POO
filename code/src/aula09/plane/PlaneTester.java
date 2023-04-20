package aula09.plane;

import java.util.Scanner;

public class PlaneTester {

    private static final PlaneManager planeManager = new PlaneManager();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String rawChoice;
        int choice;

        do {
            System.out.println("\nPlane Fleet Menu:");
            System.out.println("1. Add a plane to the fleet");
            System.out.println("2. Remove a plane from the fleet");
            System.out.println("3. Search for a plane");
            System.out.println("4. Print summary of all planes in the fleet");
            System.out.println("5. Print list of all commercial planes in the fleet");
            System.out.println("6. Print list of all military planes in the fleet");
            System.out.println("7. Print the fastest plane in the fleet");
            System.out.println("0. Exit");

            System.out.print("Enter your choice: ");
            rawChoice = validatedInput(Regex.MENU_OPTIONS, "Try again: ", true);
            assert rawChoice != null;
            choice = Integer.parseInt(rawChoice);

            switch (choice) {
                case 1:
                    addPlane();
                    break;
                case 2:
                    removePlane();
                    break;
                case 3:
                    searchPlane();
                    break;
                case 4:
                    printAllPlanes();
                    break;
                case 5:
                    printCommercialPlanes();
                    break;
                case 6:
                    printMilitaryPlanes();
                    break;
                case 7:
                    printFastestPlane();
                    break;
                case 0:
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        } while (choice != 0);

        scanner.close();
    }

    private static String validatedInput(String regex, String errorMessage, boolean recursive) {
        String rawInput = scanner.nextLine();
        if (!rawInput.matches(regex)) {
            System.out.println(errorMessage);

            return recursive ? validatedInput(regex, errorMessage, true) : null;
        }
        return rawInput;
    }

    private static void addPlane() {
    }

    private static void removePlane() {
    }

    private static void searchPlane() {
    }

    private static void printAllPlanes() {
    }

    private static void printCommercialPlanes() {
    }

    private static void printMilitaryPlanes() {
    }

    private static void printFastestPlane() {
    }
}
