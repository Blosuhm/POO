package aula08.carRental;

import aula08.carRental.vehicles.Vehicle;

import java.util.ArrayList;

public class CarRental {
    String name;
    String postalCode;
    String email;
    ArrayList<Vehicle> vehicles = new ArrayList<>();

    public CarRental(String name, String postalCode, String email) {
        validate(name, postalCode, email);
        this.name = name;
        this.postalCode = postalCode;
        this.email = email;
    }

    public CarRental(String name, String postalCode, String email, ArrayList<Vehicle> vehicles) {
        validate(name, postalCode, email);
        this.name = name;
        this.postalCode = postalCode;
        this.email = email;
        this.vehicles = vehicles;
    }

    public void validate(String name, String postalCode, String email) {
        validateName(name);
        validatePostalCode(postalCode);
        validateEmail(email);
    }

    public void validateName(String name) {
        if (name.length() < 2) {
            throw new IllegalArgumentException("Name must have at least 2 characters");
        }
    }

    public void validatePostalCode(String postalCode) {
        if (postalCode.length() != 8) {
            throw new IllegalArgumentException("Postal code must have 8 characters");
        }
    }

    public void validateEmail(String email) {
        if (!email.contains("@")) {
            throw new IllegalArgumentException("Email must contain @");
        }
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        validateName(name);
        this.name = name;
    }

    public String getPostalCode() {
        return this.postalCode;
    }

    public void setPostalCode(String postalCode) {
        validatePostalCode(postalCode);
        this.postalCode = postalCode;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        validateEmail(email);
        this.email = email;
    }

    public void addVehicle(Vehicle vehicle) {
        this.vehicles.add(vehicle);
    }

    public void removeVehicle(Vehicle vehicle) {
        this.vehicles.remove(vehicle);
    }

    public void removeVehicle(int index) {
        this.vehicles.remove(index);
    }

    public String getVehicleWithHighestTotalDistance() {
        int highestTraveledDistance = 0;
        Vehicle vehicleWithHighestTraveledDistance = null;
        for (Vehicle vehicle : this.vehicles) {
            if (vehicle.totalDistance() > highestTraveledDistance) {
                highestTraveledDistance = vehicle.totalDistance();
                vehicleWithHighestTraveledDistance = vehicle;
            }
        }
        return vehicleWithHighestTraveledDistance + " with " + highestTraveledDistance + " km";
    }

    public ArrayList<Vehicle> getVehicles() {
        return this.vehicles;
    }

    public void setVehicles(ArrayList<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    public void printVehicles() {
        for (Vehicle vehicle : this.vehicles) {
            System.out.println(vehicle);
        }
    }

    @Override
    public String toString() {
        return "RentingShop{" +
                "name='" + name + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", email='" + email + '\'' +
                ", vehicles=" + vehicles +
                '}';
    }
}
