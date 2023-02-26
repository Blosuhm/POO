package src.aula02;

import src.aula02.utils.Utils;

public class CountDownEx9 {
    
    public static void main(String[] args) {
        StringBuilder builder = new StringBuilder();
        int number = 0;
        
        while (number <= 0) {
            number = Integer.parseInt(Utils.input("Insira um número inteiro positivo: "));
            if (number <= 0) {
                Utils.print("O número tem de ser positivo");
            }
        }
        
        for (int counter = number; counter >= 0; counter--) {
            if (counter == 0) {
                builder.append(counter);
                continue;
            }
            if (counter % 10 == 0 && counter != number) {
                builder.append("\n" +counter + ", ");
                continue;
            }
            builder.append(counter + ", ");
        }

        Utils.print(builder.toString());
    }
}
