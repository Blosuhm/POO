package aula09.plane;

public class Plane {

    private final String id;
    private final String manufacturer;
    private final String model;
    private final int year;
    private int maxNumOfPassengers;
    private int maxSpeed;

    public Plane(String id, String manufacturer, String model, int year, int maxNumOfPassengers,
        int maxSpeed) {
        validateId(id);
        validateManufacturer(manufacturer);
        validateModel(model);
        validateYear(year);
        validateMaxNumOfPassengers(maxNumOfPassengers);
        validateMaxSpeed(maxSpeed);
        this.id = id;
        this.manufacturer = manufacturer;
        this.model = model;
        this.year = year;
        this.maxNumOfPassengers = maxNumOfPassengers;
        this.maxSpeed = maxSpeed;
    }


    protected static void validateId(String id) {
        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("Id is required");
        }
    }

    protected static void validateManufacturer(String manufacturer) {
        if (manufacturer == null || manufacturer.isBlank()) {
            throw new IllegalArgumentException("Manufacturer is required");
        }
    }

    protected static void validateModel(String model) {
        if (model == null || model.isBlank()) {
            throw new IllegalArgumentException("Model is required");
        }
    }

    protected static void validateYear(int year) {
        if (year < 1900) {
            throw new IllegalArgumentException("Year must be greater than 1900");
        }
    }

    protected static void validateMaxNumOfPassengers(int maxNumOfPassengers) {
        if (maxNumOfPassengers < 1) {
            throw new IllegalArgumentException("Max number of passengers must be greater than 0");
        }
    }

    protected static void validateMaxSpeed(int maxSpeed) {
        if (maxSpeed < 0) {
            throw new IllegalArgumentException("Max speed must be greater than 0");
        }
    }

    public String getId() {
        return this.id;
    }

    public String getManufacturer() {
        return this.manufacturer;
    }


    public String getModel() {
        return this.model;
    }


    public int getYear() {
        return this.year;
    }

    public int getMaxNumOfPassengers() {
        return this.maxNumOfPassengers;
    }

    public void setMaxNumOfPassengers(int maxNumOfPassengers) {
        validateMaxNumOfPassengers(maxNumOfPassengers);
        this.maxNumOfPassengers = maxNumOfPassengers;
    }

    public int getMaxSpeed() {
        return this.maxSpeed;
    }


    public void setMaxSpeed(int maxSpeed) {
        validateMaxSpeed(maxSpeed);
        this.maxSpeed = maxSpeed;
    }

    public String getPlaneType() {
        return "Plane";
    }

    @Override
    public String toString() {
        return String.format("Plane(%s) - %s %s (%d) - %d passengers - %d km/h",
            this.id, this.manufacturer, this.model, this.year, this.maxNumOfPassengers,
            this.maxSpeed);
    }
}
