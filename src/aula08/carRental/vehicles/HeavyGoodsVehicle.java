package aula08.carRental.vehicles;

public class HeavyGoodsVehicle extends HeavyVehicle {

    private int loadCapacity = 0;

    public HeavyGoodsVehicle(
        String licensePlate,
        String make,
        String model,
        int power,
        String vehicleIdentificationNumber,
        int weight,
        int loadCapacity
    ) {
        super(licensePlate, make, model, power, vehicleIdentificationNumber, weight);
        validateLoadCapacity(loadCapacity);
        this.loadCapacity = loadCapacity;
    }

    public void validateLoadCapacity(int loadCapacity) {
        if (loadCapacity < 0) {
            throw new IllegalArgumentException("Load capacity must be positive");
        }
    }

    public int getLoadCapacity() {
        return loadCapacity;
    }

    public void setLoadCapacity(int loadCapacity) {
        this.loadCapacity = loadCapacity;
    }
}
