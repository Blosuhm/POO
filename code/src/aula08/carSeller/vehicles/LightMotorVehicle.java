package aula08.carSeller.vehicles;

public class LightMotorVehicle extends Vehicle {
    String vehicleIdentificationNumber;
    int storageCapacity = 0;

    public LightMotorVehicle(
            String licensePlate,
            String make,
            String model,
            int power,
            String vehicleIdentificationNumber,
            int storageCapacity
    ) {
        super(licensePlate, make, model, power);
        validate(vehicleIdentificationNumber, storageCapacity);
        this.vehicleIdentificationNumber = vehicleIdentificationNumber;
        this.storageCapacity = storageCapacity;
    }

    public void validate(String vehicleIdentificationNumber, int storageCapacity) {
        validateVehicleIdentificationNumber(vehicleIdentificationNumber);
        validateStorageCapacity(storageCapacity);
    }

    public void validateVehicleIdentificationNumber(String vehicleIdentificationNumber) {
        if (vehicleIdentificationNumber.length() != 17) {
            throw new IllegalArgumentException("Vehicle identification number must have 17 characters");
        }
    }

    public void validateStorageCapacity(int storageCapacity) {
        if (storageCapacity < 0) {
            throw new IllegalArgumentException("Storage capacity must be positive");
        }
    }


    public String getVehicleIdentificationNumber() {
        return vehicleIdentificationNumber;
    }

    public void setVehicleIdentificationNumber(String vehicleIdentificationNumber) {
        validateVehicleIdentificationNumber(vehicleIdentificationNumber);
        this.vehicleIdentificationNumber = vehicleIdentificationNumber;
    }

    public int getStorageCapacity() {
        return storageCapacity;
    }

    public void setStorageCapacity(int storageCapacity) {
        validateStorageCapacity(storageCapacity);
        this.storageCapacity = storageCapacity;
    }

}
