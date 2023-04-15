package aula08.carSeller;

import aula08.carSeller.vehicles.*;


public class Main {
    public static void main(String[] args) {
        // Test Renting shop

        // Test Vehicles
        // Test Motorcycle
        Motorcycle motorcycle = new Motorcycle("11-11-AA", "Honda", "CBR1000RR", 1000, MotorcycleType.Sport);
        System.out.println(motorcycle);
        // Test Taxi
        Taxi taxi = new Taxi("22-22-BB", "Toyota", "Corolla", 100, "123456789ABCDEFGH", 5, 123456);
        System.out.println(taxi);
        // Test HeavyPassengerVehicle
        HeavyPassengerVehicle heavyPassengerVehicle = new HeavyPassengerVehicle("33-33-CC", "Mercedes", "Sprinter", 200, "123456789ABCDEFGH", 2000, 20);
        System.out.println(heavyPassengerVehicle);
        // Test HeavyGoodsVehicle
        HeavyGoodsVehicle heavyGoodsVehicle = new HeavyGoodsVehicle("44-44-DD", "Mercedes", "Sprinter", 200, "123456789ABCDEFGH", 2000, 2000);
        System.out.println(heavyGoodsVehicle);
        // Test Renting shop
        RentingShop rentingShop = new RentingShop("Ferrari", "1234-123", "ferrari@cars.it");
        rentingShop.addVehicle(motorcycle);
        rentingShop.addVehicle(taxi);
        rentingShop.addVehicle(heavyPassengerVehicle);
        rentingShop.addVehicle(heavyGoodsVehicle);
        System.out.println(rentingShop);
    }
}
