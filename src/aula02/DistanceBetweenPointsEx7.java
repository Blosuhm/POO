package aula02;

import aula02.utils.Utils;

public class DistanceBetweenPointsEx7 {
    public static void main(String[] args) {
        double x1;
        double x2;
        double y1;
        double y2;
        double distance;

        x1 = Double.parseDouble(Utils.input("Insira o valor de x1: "));
        y1 = Double.parseDouble(Utils.input("Insira o valor de y1: "));
        x2 = Double.parseDouble(Utils.input("Insira o valor de x2: "));
        y2 = Double.parseDouble(Utils.input("Insira o valor de y2: "));

        distance = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));

        Utils.print("A distância entre os pontos é " + distance);
    }
}
