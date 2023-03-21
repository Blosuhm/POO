package aula02;

import java.text.MessageFormat;
import aula02.utils.Utils;

public class CelsiusToFahrenheitEx2 {
    public static void main(String[] args) {
        double celsius;
        double fahrenheit;

        celsius = Double.parseDouble(Utils.input("Digite a temperatura em celsius: "));

        fahrenheit = 1.8 * celsius + 32;

        Utils.print(MessageFormat.format("A temperatura em fahrenheit é {0,number}ºF", fahrenheit));
    }
}
