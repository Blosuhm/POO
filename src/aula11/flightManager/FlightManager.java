package aula11.flightManager;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class FlightManager {

    Set<Flight> flights = new HashSet<>();
    Map<String, String> airlines = new HashMap<>();

    public FlightManager() throws FileNotFoundException {
        Scanner sc = new Scanner(new File("src/aula11/flightManager/companhias.txt"));

        sc.nextLine();

        while (sc.hasNextLine()) {

            String[] line = sc.nextLine().split("\\t");

            airlines.put(line[0], line[1]);
        }

        sc.close();

        sc = new Scanner(new File("src/aula11/flightManager/voos.txt"));
        sc.nextLine();

        while (sc.hasNextLine()) {
            String[] line = sc.nextLine().split("\\t");
            String time = line[0];
            String code = line[1];
            String origin = line[2];
            String delay = line.length == 4 ? line[3] : "00:00";

            LocalTime timeLocal = LocalTime.parse(time, Flight.formatter);
            LocalTime delayLocal = LocalTime.parse(delay, Flight.formatter);

            String airlineCode = code.substring(0, 2);

            String airline = airlines.get(airlineCode);
            if (airline == null) {
                airline = airlineCode;
            }

            Flight flight = new Flight(timeLocal, code, airline, origin, delayLocal);

            flights.add(flight);

        }
    }

    public void storeData(String filepath) throws FileNotFoundException {
        PrintWriter pw = new PrintWriter(filepath);
        pw.println(this);
        pw.close();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        String format =
            "%-5s\t%-7s\t%-" + Flight.longestAirline + "s\t%-" + Flight.longestOrigin + "s\t%-5s\t"
                + "%s\n";
        String header = String.format(format, "Hora", "Voo", "Companhia", "Origem", "Atraso",
            "Obs");

        sb.append(header);
        for (Flight flight : flights) {
            sb.append(flight.toString()).append("\n");
        }

        return sb.toString();
    }
}
