package src.aula02;

import java.text.MessageFormat;
import java.util.Scanner;

public class EnergyToWarmWater {
    public static void main(String[] args) {
        int waterThermalCapacity = 4184;
        double initialTemperature, finalTemperature, mass, energy;


        Scanner sc = new Scanner(System.in);
        System.out.print("Insira a massa de água em kg: ");
        mass = sc.nextDouble();
        System.out.print("Insira a temperatura inicial em ºC: ");
        initialTemperature = sc.nextDouble();
        System.out.print("Insira a temperatura final em ºC: ");
        finalTemperature = sc.nextDouble();


        energy = mass * (finalTemperature - initialTemperature) * waterThermalCapacity;
        String myString = MessageFormat.format("A energia necessária para aquecer a água é {0,number} J", energy);
        System.out.println(myString);
    }
}
