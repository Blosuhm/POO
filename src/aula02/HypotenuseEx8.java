package aula02;

import aula02.utils.Utils;

public class HypotenuseEx8 {

    public static void main(String[] args) {
        double a = 0;
        double b = 0;
        double hypotenuse = 0;
        double degree = 0;

        while (a <= 0) {
            a = Double.parseDouble(Utils.input("Insira o valor do cateto a: "));
            if (a <= 0) {
                Utils.print("O valor do cateto tem de ser positivo");
            }
        }

        while (b <= 0) {
            b = Double.parseDouble(Utils.input("Insira o valor do cateto b: "));
            if (b <= 0) {
                Utils.print("O valor do cateto tem de ser positivo");
            }
        }

        hypotenuse = Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));

        degree = Math.round(Math.toDegrees(Math.asin(a / hypotenuse)) * Math.pow(10, 2)) * Math.pow(10, -2);

        Utils.print("O valor da hipotenusa é: " + hypotenuse + " e o valor do ângulo é: " + degree + "º");
    }
}
