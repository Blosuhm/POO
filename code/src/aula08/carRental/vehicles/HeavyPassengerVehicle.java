package aula08.carRental.vehicles;

public class HeavyPassengerVehicle extends HeavyVehicle {
    private int passengerCapacity = 0;

    public HeavyPassengerVehicle(
            String licensePlate,
            String make,
            String model,
            int power,
            String vehicleIdentificationNumber,
            int weight,
            int passengerCapacity
    ) {
        super(licensePlate, make, model, power, vehicleIdentificationNumber, weight);
        validateLoadCapacity(passengerCapacity);
        this.passengerCapacity = passengerCapacity;
    }

    public void validateLoadCapacity(int passengerCapacity) {
        if (passengerCapacity < 0) {
            throw new IllegalArgumentException("Load capacity must be positive");
        }
    }

    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    public void setPassengerCapacity(int passengerCapacity) {
        this.passengerCapacity = passengerCapacity;
    }
}
