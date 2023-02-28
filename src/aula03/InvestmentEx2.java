package src.aula03;

import src.utils.Utils;

class InvestmentEx2 {
    public static void main(String[] args) {
        int investment;
        double interest;

        do {
            investment = Integer.parseInt(Utils.input("Insira o valor do investimento: "));
            if (!isValidInvestment(investment)) {
                Utils.print("O valor do investimento tem de ser positivo e múltiplo de 1000");
            }
        } while (!isValidInvestment(investment));

        do {
            interest = Double.parseDouble(Utils.input("Insira a taxa de juros em percentagem: ") + "e-2");
            if (!isValidInterest(interest)) {
                Utils.print("A taxa de juros tem de ser positiva e inferior a 5%");
            }
        } while (!isValidInterest(interest));

        Utils.print("O valor total do investimento é " + calculateInterest(investment, interest, 12));

    }

    private static boolean isValidInvestment(int investment) {
        return investment > 0 && investment % 1000 == 0;
    }

    private static boolean isValidInterest(double interest) {
        return interest > 0 && interest < 0.05;
    }

    private static double calculateInterest(int investment, double interest, int months) {
        double total = 0;
        total = investment;
        for (int month = 1; month <= months; month++) {
            total *= (1 + interest);
        }
        return total;
    }
}
