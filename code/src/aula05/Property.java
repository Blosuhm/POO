package aula05;

public class Property {
    private String location;
    private int rooms;
    private int price;
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

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    public boolean getAvailability() {
        return availability;
    }

    @Override
    public String toString() {
        return String.format("location: %s; rooms: %d; price: %d€", location, rooms, price);
    }

}
