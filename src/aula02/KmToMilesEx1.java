package src.aula02;
import src.aula02.utils.Utils;

class KmToMilesEx1 {
    public static void main(String[] args) {
        double km;
        double miles;

        km = Double.parseDouble(Utils.input("Digite a distância em km: "));

        miles = km / 1.609;

        Utils.print("A distância em milhas é " + miles + "mi");
    }
}