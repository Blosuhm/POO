package aula09.plane;

public class MilitaryPlane extends Plane {

    private int numMissiles;

    public MilitaryPlane(String id, String manufacturer, String model, int year, int maxPassengers,
        int maxSpeed, int numMissiles) {
        super(id, manufacturer, model, year, maxPassengers, maxSpeed);
        validateNumMissiles(numMissiles);
        this.numMissiles = numMissiles;
    }

    private void validateNumMissiles(int numMissiles) {
        if (numMissiles < 0) {
            throw new IllegalArgumentException("Number of missiles must be positive");
        }
    }

    public int getNumMissiles() {
        return numMissiles;
    }

    public void setNumMissiles(int numMissiles) {
        validateNumMissiles(numMissiles);
        this.numMissiles = numMissiles;
    }


    @Override
    public String getPlaneType() {
        return "Military";
    }


    @Override
    public String toString() {
        return super.toString() + " - " + this.numMissiles + " Missiles - Type: "
            + this.getPlaneType();
    }
}