package aula02;

import aula02.utils.Utils;
import java.text.MessageFormat;

public class EnergyToWarmWaterEx3 {

    public static void main(String[] args) {
        int waterThermalCapacity = 4184;
        double initialTemperature;
        double finalTemperature;
        double mass;
        double energy;

        mass = Double.parseDouble(Utils.input("Massa em kg: "));
        initialTemperature = Double.parseDouble(
            Utils.input("Insira a temperatura inicial em ºC: "));
        finalTemperature = Double.parseDouble(Utils.input("Insira a temperatura final em ºC: "));

        energy = mass * (finalTemperature - initialTemperature) * waterThermalCapacity;

        Utils.print(MessageFormat.format("A energia necessária para aquecer a água é {0,number} J",
            energy));
    }
}
