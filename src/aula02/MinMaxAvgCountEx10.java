package src.aula02;

import src.aula02.utils.Utils;

public class MinMaxAvgCountEx10 {
    
    public static void main(String[] args) {
        int number = 0;
        int first = 0;
        int count = 0;
        int min = 0;
        int max = 0;
        int sum = 0;
        double avg = 0;
        
        do {
            number = Integer.parseInt(Utils.input("Insira um número inteiro (volte a insereir o primeiro para terminar): "));
            if (number == first && count > 0) {
                break;
            }
            if (count == 0) {
                first = number;
                min = number;
                max = number;
            }
            min = Math.min(min, number);
            max = Math.max(max, number);
            sum += number;
            count++;
        } while (true);
        
        avg = (double) sum / count;
        
        Utils.print("O maior valor lido é: " + max);
        Utils.print("O menor valor lido é: " + min);
        Utils.print("A média dos valores lidos é: " + avg);
        Utils.print("O número de valores lidos é: " + count);
    }
}
