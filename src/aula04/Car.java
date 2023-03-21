package aula04;

public class Car {
    private String make;
    private String model;
    private int year;
    private int kms;

    public Car(String make, String model, int year, int kms) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.kms = kms;
    }

    public void drive(int distance) {
        this.kms += distance;
    }

    @Override
    public String toString() {
        return make + " " + model + ", " + year + ", kms: " + kms;
    }
}