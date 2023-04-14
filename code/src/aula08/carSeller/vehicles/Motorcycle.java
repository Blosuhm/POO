package aula08.carSeller.vehicles;

public class Motorcycle extends Vehicle {
    private MotorcycleType type;

    public Motorcycle(String licensePlate, String make, String model, int power, MotorcycleType type) {
        super(licensePlate, make, model, power);
        this.type = type;
    }

    public MotorcycleType getType() {
        return type;
    }

    public void setType(MotorcycleType type) {
        this.type = type;
    }
}
