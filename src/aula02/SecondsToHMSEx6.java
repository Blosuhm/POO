package aula02;

import aula02.utils.Utils;

public class SecondsToHMSEx6 {

    public static void main(String[] args) {
        int seconds = 0;
        int hours = 0;
        int minutes = 0;
        int secs = 0;

        seconds = Integer.parseInt(Utils.input("Insira o número de segundos: "));
        hours = seconds / 3600;
        minutes = (seconds % 3600) / 60;
        secs = (seconds % 3600) % 60;

        Utils.print("O número de segundos introduzido corresponde a " + hours + " horas, " + minutes
            + " minutos e "
            + secs + " segundos.");
    }
}
