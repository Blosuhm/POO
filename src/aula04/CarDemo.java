package aula04;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CarDemo {

    static Scanner sc = new Scanner(System.in);

    static int registerCars(Car[] cars) {
        String regex = "^(\\w+) ((\\w+ ?)+) (\\d{4}) (\\d+)$";
        String line = "";
        boolean match = true;
        Pattern pattern = Pattern.compile(regex);
        int numCars = 0;

        for (int i = 0; i < cars.length; i++) {
            Matcher matcher;
            do {
                System.out.print("Insira dados do carro (marca modelo ano quilómetros): ");
                line = sc.nextLine();
                match = Pattern.matches(regex, line);
                if (line.isEmpty()) {
                    return numCars;
                }
                if (!match) {
                    System.out.println("Dados mal formatados. Tente novamente.");
                }
                matcher = pattern.matcher(line);
            } while (!match);

            numCars++;

            matcher.find();
            String make = matcher.group(1);
            String model = matcher.group(2);
            int year = Integer.parseInt(matcher.group(4));
            int kms = Integer.parseInt(matcher.group(5));
            cars[i] = new Car(make, model, year, kms);
        }
        return cars.length;
    }

    static void registerTrips(Car[] cars, int numCars) {
        String regex = "^(\\d+):(\\d+)$";
        String line = "";
        boolean match = true;

        while (true) {
            do {
                System.out.print("Registe uma viagem no formato \"carro:distância\": ");
                line = sc.nextLine();
                match = Pattern.matches(regex, line);
                if (line.isEmpty()) {
                    return;
                }
                if (!match) {
                    System.out.println("Dados mal formatados. Tente novamente.");
                }
            } while (!match);

            String[] parts = line.split(":");
            int car = Integer.parseInt(parts[0]);
            int distance = Integer.parseInt(parts[1]);

            if (car < 0 || car >= numCars) {
                System.out.println("Carro inválido. Tente novamente.");
                continue;
            }
            if (distance < 0) {
                System.out.println("Distância inválida. Tente novamente.");
                continue;
            }

            cars[car].drive(distance);
        }
    }

    static void listCars(Car[] cars) {
        System.out.println("\nCarros registados: ");
        for (int i = 0; i < cars.length; i++) {
            if (cars[i] == null) {
                break;
            }
            System.out.println(cars[i]);
        }

        System.out.println("\n");
    }

    public static void main(String[] args) {

        Car[] cars = new Car[10];

        int numCars = registerCars(cars);

        if (numCars > 0) {
            listCars(cars);
            registerTrips(cars, numCars);
            listCars(cars);
        }

        sc.close();

    }
}