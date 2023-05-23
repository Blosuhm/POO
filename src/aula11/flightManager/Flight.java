package aula11.flightManager;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Flight {

    static int longestAirline = 0;
    static int longestOrigin = 0;
    static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
    LocalTime time;
    String code;
    String airline;
    String origin;
    LocalTime delay;

    public Flight(LocalTime time, String code, String airline, String origin, LocalTime delay) {
        this.time = time;
        this.code = code;
        this.airline = airline;
        this.origin = origin;
        this.delay = delay;

        if (airline.length() > longestAirline) {
            longestAirline = airline.length();
        }
        if (origin.length() > longestOrigin) {
            longestOrigin = origin.length();
        }
    }

    public LocalTime getTime() {
        return time;
    }

    public String getCode() {
        return code;
    }

    public String getAirline() {
        return airline;
    }

    public String getOrigin() {
        return origin;
    }

    public LocalTime getDelay() {
        return delay;
    }

    @Override
    public String toString() {
        String format = "%-5s\t%-7s\t%-" + longestAirline + "s\t%-" + longestOrigin + "s";
        if (!delay.equals(LocalTime.parse("00:00", formatter))) {
            format = format + "\t%-5s\t%-5s";
            String predictedTime = time.plusMinutes(delay.getMinute()).toString();
            String predicted = "Previsto: " + predictedTime;
            return String.format(format, time, code, airline, origin, delay, predicted);
        }
        return String.format(format, time, code, airline, origin);
    }
}
