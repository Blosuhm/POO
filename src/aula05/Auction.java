package aula05;

public class Auction {
    private int propertyID;
    private DateYMD date;
    private int durationDays;

    public Auction(int propertyID, DateYMD date, int durationDays) {
        if (durationDays <= 0) {
            throw new IllegalArgumentException("Duration must be positive!");
        }
        this.propertyID = propertyID;
        this.date = date;
        this.durationDays = durationDays;
    }

    public int getPropertyID() {
        return propertyID;
    }

    @Override
    public String toString() {
        DateYMD lastDay = new DateYMD(date);
        for (int i = 0; i < durationDays; i++) {
            lastDay.incrementDay();
        }
        return String.format("Auction: from %s to %s", date, lastDay);
    }
}
