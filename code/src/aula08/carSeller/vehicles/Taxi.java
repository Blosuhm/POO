package aula08.carSeller.vehicles;

public class Taxi extends LightMotorVehicle {
    int licenseNumber = 0;

    public Taxi(
            String licensePlate,
            String make,
            String model,
            int power,
            String vehicleIdentificationNumber,
            int storageCapacity,
            int licenseNumber
    ) {
        super(licensePlate, make, model, power, vehicleIdentificationNumber, storageCapacity);
        validateLicenseNumber(licenseNumber);
        this.licenseNumber = licenseNumber;
    }

    public void validateLicenseNumber(int licenseNumber) {
        if (licenseNumber < 0) {
            throw new IllegalArgumentException("License number must be positive");
        }
    }

    public int getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(int licenseNumber) {
        validateLicenseNumber(licenseNumber);
        this.licenseNumber = licenseNumber;
    }


}
