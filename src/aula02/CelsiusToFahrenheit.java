package src.aula02;

import java.text.MessageFormat;
import java.util.Scanner;

public class CelsiusToFahrenheit {
    public static void main(String[] args) {
        double celsius, fahrenheit;

        Scanner sc = new Scanner(System.in);
        System.out.print("Insira a temperatura em ºC: ");
        celsius = sc.nextDouble();

        fahrenheit = 1.8*celsius + 32;
        String myString = MessageFormat.format("A temperatura em fahrenheit é {0,number}ºF", fahrenheit);
        System.out.println(myString);
    }
}
