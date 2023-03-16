package aula05;

import java.util.ArrayList;

import javax.management.InvalidAttributeValueException;

public class RealEstate {
    private ArrayList<Property> properties = new ArrayList<>();
    private ArrayList<Auction> auctions = new ArrayList<>();
    private static final int FIRST_ID = 1000;
    private int lastID = FIRST_ID - 1;

    public void newProperty(String location, int rooms, int price) {
        properties.add(new Property(location, rooms, price));
        lastID++;
    }

    public void sell(int propertyID) {
        if (!propertyExists(propertyID)) {
            System.out.println(String.format("Property %d does not exist", propertyID));
            return;
        }
        if (!properties.get(propertyID - FIRST_ID).getAvailability()) {
            System.out.println(String.format("Property %d not available", propertyID));
            return;
        }
        properties.get(propertyID - FIRST_ID).setAvailability(false);
    }

    public void setAuction(int propertyID, DateYMD date, int durationDays) {
        if (!propertyExists(propertyID)) {
            System.out.println(String.format("Property %d does not exist", propertyID));
            return;
        }
        if (durationDays <= 0) {
            throw new IllegalArgumentException("Duration must be positive!");
        }
        auctions.add(new Auction(propertyID, date, durationDays));
    }

    public boolean propertyExists(int propertyID) {
        return FIRST_ID <= propertyID && propertyID <= lastID;
    }

}
