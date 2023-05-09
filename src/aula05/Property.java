package aula05;

public class Property {

    private final String location;
    private final int rooms;
    private final int price;
    private boolean availability = true;

    public Property(String location, int rooms, int price) {
        if (rooms < 0) {
            throw new IllegalArgumentException("Invalid number of rooms");
        }
        if (price < 0) {
            throw new IllegalArgumentException("Invalid price");
        }
        if (location == null || location.isEmpty()) {
            throw new IllegalArgumentException("Invalid location");
        }
        this.location = location;
        this.rooms = rooms;
        this.price = price;
    }

    public boolean getAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    @Override
    public String toString() {
        return String.format("location: %s; rooms: %d; price: %d€", location, rooms, price);
    }

}
