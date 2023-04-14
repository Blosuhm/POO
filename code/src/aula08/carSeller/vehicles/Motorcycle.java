package aula08.carSeller.vehicles;

enum Type {
    Sport,
    Road
}

public class Motorcicle extends Vehicle {
    private Type type;

    public Motorcicle(String licensePlate, String make, String model, int power, Type type) {
        super(licensePlate, make, model, power);
        this.type = type;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}
