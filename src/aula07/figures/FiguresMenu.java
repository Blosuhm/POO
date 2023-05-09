package aula07.figures;

import aula04.geometric_figures.Circle;
import aula04.geometric_figures.Rectangle;
import aula04.geometric_figures.Triangle;
import java.util.ArrayList;
import java.util.Scanner;

public class FiguresMenu {

    static final String VALID_NUMBER_STRING = "^\\d+([.]\\d+)?$";
    static ArrayList<Circle> listOfCircles = new ArrayList<>();
    static ArrayList<Rectangle> listOfRectangle = new ArrayList<>();
    static ArrayList<Triangle> listOfTriangles = new ArrayList<>();

    public static void main(String[] args) {
        int choice = 0;
        do {
            listOptions();
            choice = inputChoice();
            selector(choice);

        } while (choice != 7);
    }

    private static int inputChoice() {
        String validInput = "^[1-7]$";
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        if (!input.matches(validInput)) {
            System.out.println("Invalid input. Try again.");
            return inputChoice();
        }
        System.out.println();
        return Integer.parseInt(input);
    }

    private static void listOptions() {
        System.out.println("Select an option:");
        System.out.println("1 - Add circle");
        System.out.println("2 - Add rectangle");
        System.out.println("3 - Add triangle");
        System.out.println("4 - List perimeters");
        System.out.println("5 - List areas");
        System.out.println("6 - Compare figures");
        System.out.println("7 - Exit");
        System.out.print("Your choice: ");
    }

    private static void selector(int choice) {
        switch (choice) {
            case 1:
                addCircle();
                break;
            case 2:
                addRectangle();
                break;
            case 3:
                addTriangle();
                break;
            case 4:
                listPerimeters();
                break;
            case 5:
                listAreas();
                break;
            case 6:
                compareFigures();
                break;
            case 7:
                System.out.println("Goodbye!");
                break;
            default:
                System.out.println("Invalid Choice");
        }
    }

    private static void addCircle() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the radius: ");
        String input = sc.nextLine();
        if (!input.matches(VALID_NUMBER_STRING)) {
            System.out.println("Invalid input. Try again.");
            return;
        }
        double radius = Double.parseDouble(input);
        Circle circle = new Circle(radius);
        System.out.println();
        listOfCircles.add(circle);
    }

    private static void addRectangle() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the width: ");
        String input = sc.nextLine();
        if (!input.matches(VALID_NUMBER_STRING)) {
            System.out.println("Invalid input. Try again.");
            return;
        }
        double width = Double.parseDouble(input);
        System.out.print("Enter the height: ");
        input = sc.nextLine();
        if (!input.matches(VALID_NUMBER_STRING)) {
            return;
        }
        double height = Double.parseDouble(input);
        Rectangle rectangle = new Rectangle(width, height);
        System.out.println();
        listOfRectangle.add(rectangle);
    }

    private static void addTriangle() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the side A: ");
        String input = sc.nextLine();
        if (!input.matches(VALID_NUMBER_STRING)) {
            System.out.println("Invalid input. Try again.");
            return;
        }
        double sideA = Double.parseDouble(input);
        System.out.print("Enter the side B: ");
        input = sc.nextLine();
        if (!input.matches(VALID_NUMBER_STRING)) {
            return;
        }
        double sideB = Double.parseDouble(input);
        System.out.print("Enter the side C: ");
        input = sc.nextLine();
        if (!input.matches(VALID_NUMBER_STRING)) {
            return;
        }
        double sideC = Double.parseDouble(input);
        Triangle triangle = new Triangle(sideA, sideB, sideC);
        System.out.println();
        listOfTriangles.add(triangle);
    }

    private static void listPerimeters() {
        for (int i = 0; i < listOfCircles.size(); i++) {
            System.out.println("Circle " + i + " -> " + listOfCircles.get(i).getPerimeter());
        }

        for (int i = 0; i < listOfRectangle.size(); i++) {
            System.out.println("Rectangle " + i + " -> " + listOfRectangle.get(i).getPerimeter());
        }

        for (int i = 0; i < listOfTriangles.size(); i++) {
            System.out.println("Triangle " + i + " -> " + listOfTriangles.get(i).getPerimeter());
        }
    }

    private static void listAreas() {
        for (int i = 0; i < listOfCircles.size(); i++) {
            System.out.println("Circle " + i + " -> " + listOfCircles.get(i).getArea());
        }

        for (int i = 0; i < listOfRectangle.size(); i++) {
            System.out.println("Rectangle " + i + " -> " + listOfRectangle.get(i).getArea());
        }

        for (int i = 0; i < listOfTriangles.size(); i++) {
            System.out.println("Triangle " + i + " -> " + listOfTriangles.get(i).getArea());
        }
    }

    private static void compareFigures() {
        // i want to compare only figures that are equal

        for (int i = 0; i < listOfCircles.size(); i++) {
            for (int j = i + 1; j < listOfCircles.size(); j++) {
                System.out.println("Circle " + i + " == " + "Circle " + j + " => "
                    + listOfCircles.get(i).equals(listOfCircles.get(j)));
            }
        }

        for (int i = 0; i < listOfRectangle.size(); i++) {
            for (int j = i + 1; j < listOfRectangle.size(); j++) {
                System.out.println("Rectangle " + i + " == " + "Rectangle " + j + " => "
                    + listOfRectangle.get(i).equals(listOfRectangle.get(j)));
            }
        }

        for (int i = 0; i < listOfTriangles.size(); i++) {
            for (int j = i + 1; j < listOfTriangles.size(); j++) {
                System.out.println("Triangle " + i + " == " + "Triangle " + j + " => "
                    + listOfTriangles.get(i).equals(listOfTriangles.get(j)));
            }
        }
    }

}