package aula08.carSeller.vehicles;

import java.util.ArrayList;
import java.util.Objects;

public class Vehicle implements TraveledDistance {
    private final ArrayList<Integer> traveledDistances = new ArrayList<>();
    int power;
    private String licensePlate;
    private String make;
    private String model;

    public Vehicle(String licensePlate, String make, String model, int power) {
        validate(licensePlate, make, model, power);
        this.licensePlate = licensePlate;
        this.make = make;
        this.model = model;
        this.power = power;
    }

    public void validate(String licensePlate, String make, String model, int power) {
        validateLicensePlate(licensePlate);
        validateMake(make);
        validateModel(model);
        validatePower(power);
    }

    public void validateLicensePlate(String licensePlate) {
        if (licensePlate.length() != 8) {
            throw new IllegalArgumentException("License plate must have 8 characters");
        }
    }

    public void validateMake(String make) {
        if (make.length() < 2) {
            throw new IllegalArgumentException("Make must have at least 2 characters");
        }
    }

    public void validateModel(String model) {
        if (model.length() < 2) {
            throw new IllegalArgumentException("Model must have at least 2 characters");
        }
    }

    public void validatePower(int power) {
        if (power < 0) {
            throw new IllegalArgumentException("Power must be positive");
        }
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        validateLicensePlate(licensePlate);
        this.licensePlate = licensePlate;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        validateMake(make);
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        validateModel(model);
        this.model = model;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        validatePower(power);
        this.power = power;
    }

    public void trajectory(int kilometers) {
        traveledDistances.add(kilometers);
    }

    public int lastTrajectory() {
        return traveledDistances.get(traveledDistances.size() - 1);
    }

    public int totalDistance() {
        int total = 0;
        for (int distance : traveledDistances) {
            total += distance;
        }
        return total;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                ", make='" + make + '\'' +
                ", licensePlate='" + licensePlate + '\'' +
                ", model='" + model + '\'' +
                "power=" + power +
                "totalDistance=" + totalDistance() +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehicle vehicle = (Vehicle) o;
        return getPower() == vehicle.getPower() && Objects.equals(getMake(), vehicle.getMake()) && Objects.equals(getModel(), vehicle.getModel());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPower(), getMake(), getModel());
    }
}
