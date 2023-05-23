package aula11.flightManager;

import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        FlightManager flightManager = new FlightManager();

        System.out.println(flightManager);

        flightManager.storeData("src/aula11/flightManager/Infopublico.txt");
    }

}
