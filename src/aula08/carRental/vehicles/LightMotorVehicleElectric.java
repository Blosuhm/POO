package aula08.carRental.vehicles;

public class LightMotorVehicleElectric extends LightMotorVehicle implements ElectricVehicle {

    private int batteryCapacity = 0;
    private int batteryPercentage = 0;

    public LightMotorVehicleElectric(
        String licensePlate,
        String make,
        String model,
        int power,
        int batteryCapacity,
        int batteryPercentage,
        String vehicleIdentificationNumber,
        int storageCapacity
    ) {
        super(licensePlate, make, model, power, vehicleIdentificationNumber, storageCapacity);
        validateBatteryCapacity(batteryCapacity);
        validateBatteryPercentage(batteryPercentage);
        this.batteryCapacity = batteryCapacity;
        this.batteryPercentage = batteryPercentage;
    }

    public void validateBatteryCapacity(int batteryCapacity) {
        if (batteryCapacity < 0) {
            throw new IllegalArgumentException("Battery capacity must be positive");
        }
    }

    public void validateBatteryPercentage(int batteryPercentage) {
        if (batteryPercentage < 0 || batteryPercentage > 100) {
            throw new IllegalArgumentException("Battery percentage must be between 0 and 100");
        }
    }

    public int getBatteryCapacity() {
        return batteryCapacity;
    }

    public void setBatteryCapacity(int batteryCapacity) {
        validateBatteryCapacity(batteryCapacity);
        this.batteryCapacity = batteryCapacity;
    }

    public int getBatteryPercentage() {
        return batteryPercentage;
    }

    public void setBatteryPercentage(int batteryPercentage) {
        validateBatteryPercentage(batteryPercentage);
        this.batteryPercentage = batteryPercentage;
    }

    @Override
    public int range() {
        return batteryCapacity * batteryPercentage / 100;
    }

    @Override
    public void recharge(int percentage) {
        validateBatteryPercentage(percentage);
        this.batteryPercentage = percentage;
    }

    @Override
    public void trajectory(int distance) {
        validateDistance(distance);
        if (distance > range()) {
            throw new IllegalArgumentException("Not enough battery to complete the trajectory");
        }
        this.traveledDistances.add(distance);
    }
}
