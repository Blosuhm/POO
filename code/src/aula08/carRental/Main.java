package aula08.carRental;

import aula08.carRental.vehicles.HeavyGoodsVehicle;
import aula08.carRental.vehicles.HeavyPassengerVehicle;
import aula08.carRental.vehicles.HeavyPassengerVehicleElectric;
import aula08.carRental.vehicles.LightMotorVehicle;
import aula08.carRental.vehicles.LightMotorVehicleElectric;
import aula08.carRental.vehicles.Motorcycle;
import aula08.carRental.vehicles.MotorcycleType;
import aula08.carRental.vehicles.Taxi;

public class Main {

    static CarRental carRental = new CarRental("Johnny's Cars", "2345-253", "johnnyscars@car.pt");

    static LightMotorVehicle mercedes = new LightMotorVehicle("AB-46-EH", "Mercedes", "AMG", 300,
        "4HB54JHB45B4J5HJ3", 300);
    static Taxi taxi = new Taxi("UH-87-RG", "Ford", "Blah", 50, "4HB54JHB45B4J5HJ3", 600, 734683);
    static Motorcycle motorcycle = new Motorcycle("CH-47-LA", "Suzuki", "Fast", 80,
        MotorcycleType.Sport);
    static HeavyGoodsVehicle truck = new HeavyGoodsVehicle("JO-34-IU", "Man", "Slow", 250,
        "4HB54JHB45B4J5HJ3", 10000, 10000);
    static HeavyPassengerVehicle bus = new HeavyPassengerVehicle("JH-67-FR", "Mercedes", "Big", 150,
        "4HB54JHB45B4J5HJ3", 6000, 50);
    static LightMotorVehicle mercedes2 = new LightMotorVehicle("PL-16-VH", "Mercedes", "AMG", 300,
        "4HB54JHB45B4J5HJ3", 200);
    static LightMotorVehicleElectric tesla = new LightMotorVehicleElectric("GH-93-TV", "Tesla",
        "Model S", 300, 100, 50, "4HB54JHB45B4J5HJ3", 300);

    static HeavyPassengerVehicleElectric electricBus = new HeavyPassengerVehicleElectric("UL-01"
        + "-VF", "Name", "ModelName", 10, "4HB54JHB45B4J5HJ3", 6000, 50, 300, 78);

    public static void main(String[] args) {
        carRental.addVehicle(mercedes);
        carRental.addVehicle(taxi);
        carRental.addVehicle(motorcycle);
        carRental.addVehicle(truck);
        carRental.addVehicle(bus);
        mercedes.trajectory(100);
        taxi.trajectory(1000);
        motorcycle.trajectory(30);
        truck.trajectory(100000);
        bus.trajectory(5000);
        mercedes.trajectory(500);
        System.out.println(carRental);
        System.out.println(carRental.getVehicles());
        carRental.removeVehicle(mercedes);
        System.out.println(carRental.getVehicles());
        carRental.removeVehicle(0);
        System.out.println(carRental.getVehicles());
        System.out.println(carRental.getVehicleWithHighestTotalDistance());
        System.out.println(carRental.getEmail());
        System.out.println(carRental.getPostalCode());
        System.out.println(carRental.getName());
        carRental.setEmail("hi@hi.hi");
        carRental.setPostalCode("1234-567");
        carRental.setName("Hi");
        System.out.println(carRental.getEmail());
        System.out.println(carRental.getPostalCode());
        System.out.println(carRental.getName());
        System.out.println(mercedes.lastTrajectory());
        System.out.println(mercedes.totalDistance());
        System.out.println(mercedes.equals(mercedes2));
        System.out.println(mercedes.equals(taxi));

        // Test electric
        System.out.println(tesla.range());
        tesla.trajectory(30);
        System.out.println(tesla.range());
        tesla.recharge(100);
        System.out.println(tesla.range());
        tesla.trajectory(100);
        System.out.println(tesla.range());

        // Test electric bus
        System.out.println(electricBus.range());
        electricBus.trajectory(100);
        System.out.println(electricBus.range());
        electricBus.recharge(100);
        System.out.println(electricBus.range());
        electricBus.trajectory(200);
        System.out.println(electricBus.range());


    }
}
