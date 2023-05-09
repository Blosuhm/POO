package aula05;

import java.util.ArrayList;

public class RealEstate {

    private static final int FIRST_ID = 1000;
    private final ArrayList<Property> properties = new ArrayList<>();
    private final ArrayList<Auction> auctions = new ArrayList<>();
    private int lastID = FIRST_ID - 1;

    public void newProperty(String location, int rooms, int price) {
        properties.add(new Property(location, rooms, price));
        lastID++;
    }

    public void sell(int propertyID) {
        if (!propertyExists(propertyID)) {
            System.out.printf("Property %d does not exist%n", propertyID);
            return;
        }
        if (!properties.get(propertyID - FIRST_ID).getAvailability()) {
            System.out.printf("Property %d not available%n", propertyID);
            return;
        }
        System.out.printf("Property %d sold%n", propertyID);
        properties.get(propertyID - FIRST_ID).setAvailability(false);
    }

    public void setAuction(int propertyID, DateYMD date, int durationDays) {
        if (!propertyExists(propertyID)) {
            System.out.printf("Property %d does not exist%n", propertyID);
            return;
        }
        if (!properties.get(propertyID - FIRST_ID).getAvailability()) {
            System.out.printf("Property %d not available%n", propertyID);
            return;
        }
        auctions.add(new Auction(propertyID, date, durationDays));
    }

    public boolean propertyExists(int propertyID) {
        return FIRST_ID <= propertyID && propertyID <= lastID;
    }

    @Override
    public String toString() {
        StringBuilder realEstate = new StringBuilder();
        for (Property property : properties) {
            realEstate.append(property);
            for (Auction auction : auctions) {
                if (auction.getPropertyID() == properties.indexOf(property) + FIRST_ID) {
                    realEstate.append("; " + auction);
                }
            }
            realEstate.append("\n");
        }
        return realEstate.toString();
    }

}
