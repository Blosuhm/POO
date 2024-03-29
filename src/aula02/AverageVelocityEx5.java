package aula02;

import aula02.utils.Utils;

public class AverageVelocityEx5 {

    public static void main(String[] args) {
        double distance1 = 0;
        double distance2 = 0;
        double velocity1 = 0;
        double velocity2 = 0;
        double averageVelocity = 0;

        while (distance1 <= 0) {
            distance1 = Double.parseDouble(
                Utils.input("Insira a distância percorrida em km no primeiro trajeto: "));
            if (distance1 <= 0) {
                Utils.print("A distância tem de ser positiva");
            }
        }

        while (velocity1 <= 0) {
            velocity1 = Double.parseDouble(
                Utils.input("Insira a velocidade média em km/h no primeiro trajeto: "));
            if (velocity1 <= 0) {
                Utils.print("A velocidade tem de ser positiva");
            }
        }

        while (distance2 <= 0) {
            distance2 = Double.parseDouble(
                Utils.input("Insira a distância percorrida em km no segundo trajeto: "));
            if (distance2 <= 0) {
                Utils.print("A distância tem de ser positiva");
            }
        }

        while (velocity2 <= 0) {
            velocity2 = Double.parseDouble(
                Utils.input("Insira a velocidade média em km/h no segundo trajeto: "));
            if (velocity2 <= 0) {
                Utils.print("A velocidade tem de ser positiva");
            }
        }

        averageVelocity = velocity1 * velocity2 * (distance1 + distance2)
            / (distance1 * velocity2 + distance2 * velocity1);

        Utils.print("A velocidade média é " + averageVelocity);

    }
}
