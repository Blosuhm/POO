package aula02;

import aula02.utils.Utils;

public class InvestmentEx4 {
  public static void main(String[] args) {
    double investment;
    double interest;

    investment = Double.parseDouble(Utils.input("Insira o valor do investimento: "));
    interest = Double.valueOf(Utils.input("Insira a taxa de juros em percentagem: ") + "e-2");

    for (int month = 1; month <= 3; month++) {
      investment *= (1 + interest);
    }

    Utils.print("O valor total do investimento é " + investment);
  }
}
