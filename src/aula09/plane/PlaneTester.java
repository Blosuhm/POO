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
            System.out.print(errorMessage);

            return recursive ? validatedInput(regex, errorMessage, true) : null;
        }
        return rawInput;
    }

    private static void addPlane() {
        System.out.println("\nChoose the plane type: ");
        System.out.println("1 - No Type");
        System.out.println("2 - Commercial");
        System.out.println("3 - Military");
        System.out.println("0 - Cancel");
        System.out.print("Enter your choice: ");
        String rawChoice = validatedInput(Regex.PLANE_TYPE_MENU, "Not a valid option!", false);
        if (rawChoice == null) {
            return;
        }
        int choice = Integer.parseInt(rawChoice);

        if (choice == 0) {
            return;
        }

        planeTypeSelector(choice);


    }

    private static void planeTypeSelector(int choice) {
        System.out.print("Id: ");
        String id = validatedInput(Regex.ID, "Invalid Id!\n", false);
        if (id == null) {
            return;
        }

        System.out.print("Manufacturer: ");
        String rawManufacturer = validatedInput(Regex.NAME, "Invalid Manufacturer!\n", false);
        if (rawManufacturer == null) {
            return;
        }
        String manufacturer = removeDupSpace(rawManufacturer);

        System.out.print("Model: ");
        String rawModel = validatedInput(Regex.NAME, "Invalid Model!\n", false);
        if (rawModel == null) {
            return;
        }
        String model = removeDupSpace(rawModel);

        System.out.print("Year: ");
        String rawYear = validatedInput(Regex.YEAR, "Invalid Year (Must be greater than 1900)!\n",
            false);
        if (rawYear == null) {
            return;
        }
        int year = Integer.parseInt(rawYear);

        System.out.print("Max number of passengers: ");
        String rawMaxPassengers = validatedInput(Regex.POS_INT, "Invalid Passengers!\n", false);
        if (rawMaxPassengers == null) {
            return;
        }
        int maxPassengers = Integer.parseInt(rawMaxPassengers);

        System.out.print("Max Speed: ");
        String rawMaxSpeed = validatedInput(Regex.POS_INT, "Invalid Speed!\n", false);
        if (rawMaxSpeed == null) {
            return;
        }
        int maxSpeed = Integer.parseInt(rawMaxSpeed);

        switch (choice) {
            case 1:
                planeManager.addPlane(
                    new Plane(id, manufacturer, model, year, maxPassengers, maxSpeed));
                break;
            case 2:
                System.out.print("Number of crew members: ");
                String rawNumOfCrewMembers = validatedInput(Regex.POS_INT, "Invalid Crew "
                    + "Members!\n", false);
                if (rawNumOfCrewMembers == null) {
                    return;
                }
                int numOfCrewMembers = Integer.parseInt(rawNumOfCrewMembers);
                planeManager.addPlane(new CommercialPlane(id, manufacturer, model, year,
                    maxPassengers, maxSpeed, numOfCrewMembers));
                break;
            case 3:
                System.out.print("Number of Missiles: ");
                String rawNumMissiles = validatedInput(Regex.POS_INT, "Invalid Missiles!\n", false);
                if (rawNumMissiles == null) {
                    return;
                }
                int numMissiles = Integer.parseInt(rawNumMissiles);
                planeManager.addPlane(new MilitaryPlane(id, manufacturer, model, year,
                    maxPassengers, maxSpeed, numMissiles));
                break;
            default:
                System.out.println("Not a valid choice");
        }
    }

    private static String removeDupSpace(String s) {
        return s.replaceAll("\\s+", " ");
    }

    private static void removePlane() {
        System.out.print("Id: ");
        String id = validatedInput(Regex.ID, "Invalid Id!\n", false);
        System.out.println();
        if (id == null) {
            System.out.println("Plane not found!");
            return;
        }
        System.out.println("Removing plane " + id);
        planeManager.removePlane(id);
    }

    private static void searchPlane() {
        System.out.print("Id: ");
        String id = validatedInput(Regex.ID, "Invalid Id!\n", false);
        if (id == null) {
            return;
        }
        System.out.println();
        Plane plane = planeManager.searchPlane(id);
        if (plane == null) {
            System.out.println("Plane not found!");
            return;
        }
        System.out.println(plane);
    }

    private static void printAllPlanes() {
        System.out.println();
        planeManager.printAllPlanes();
    }

    private static void printCommercialPlanes() {
        System.out.println();
        for (Plane plane : planeManager.getCommercialPlanes()) {
            System.out.println(plane);
        }
    }

    private static void printMilitaryPlanes() {
        System.out.println();
        for (Plane plane : planeManager.getMilitaryPlanes()) {
            System.out.println(plane);
        }
    }

    private static void printFastestPlane() {
        System.out.println();
        System.out.println(planeManager.getFastestPlane());
    }
}
