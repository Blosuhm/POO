package aula08.carRental.vehicles;

public class HeavyVehicle extends Vehicle {

    String vehicleIdentificationNumber;
    int weight = 0;

    public HeavyVehicle(String licensePlate, String make, String model, int power,
        String vehicleIdentificationNumber, int weight) {
        super(licensePlate, make, model, power);
        validate(vehicleIdentificationNumber, weight);
        this.vehicleIdentificationNumber = vehicleIdentificationNumber;
    }

    public void validate(String vehicleIdentificationNumber, int weight) {
        validateVehicleIdentificationNumber(vehicleIdentificationNumber);
        validateWeight(weight);
    }

    private void validateVehicleIdentificationNumber(String vehicleIdentificationNumber) {
        if (vehicleIdentificationNumber.length() != 17) {
            throw new IllegalArgumentException("VIN must have 17 characters");
        }
    }

    public void validateWeight(int weight) {
        if (weight < 0) {
            throw new IllegalArgumentException("Weight must be positive");
        }
    }

    public String getVehicleIdentificationNumber() {
        return vehicleIdentificationNumber;
    }

    public void setVehicleIdentificationNumber(String vehicleIdentificationNumber) {
        validateVehicleIdentificationNumber(vehicleIdentificationNumber);
        this.vehicleIdentificationNumber = vehicleIdentificationNumber;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        validateWeight(weight);
        this.weight = weight;
    }
}
