package aula09.plane;

public class CommercialPlane extends Plane {

    private int numOfCrewMembers;

    public CommercialPlane(String id, String manufacturer, String model, int year,
        int maxNumOfPassengers, int maxSpeed, int numOfCrewMembers) {
        super(id, manufacturer, model, year, maxNumOfPassengers, maxSpeed);
        validateNumOfCrewMembers(numOfCrewMembers);
        this.numOfCrewMembers = numOfCrewMembers;
    }

    private void validateNumOfCrewMembers(int numOfCrewMembers) {
        if (numOfCrewMembers < 1) {
            throw new IllegalArgumentException("Invalid number of crew members");
        }
    }

    public int getNumOfCrewMembers() {
        return this.numOfCrewMembers;
    }

    public void setNumOfCrewMembers(int numOfCrewMembers) {
        validateNumOfCrewMembers(numOfCrewMembers);
        this.numOfCrewMembers = numOfCrewMembers;
    }


    @Override
    public String getPlaneType() {
        return "Commercial";
    }

    @Override
    public String toString() {
        return super.toString() + " - " + this.numOfCrewMembers + " - Type: " + this.getPlaneType();
    }
}
