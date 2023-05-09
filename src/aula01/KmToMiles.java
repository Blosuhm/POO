package aula01;

import aula02.utils.Utils;

public class KmToMiles {

    public static void main(String[] args) {
        double km, miles;
        km = Double.parseDouble((Utils.input("Insira a distância en kilometros: ")));
        miles = km / 1.609;
        Utils.print("A distância em milhas é: " + miles);
    }
}
