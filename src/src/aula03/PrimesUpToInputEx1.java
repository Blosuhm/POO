package src.aula03;

import src.aula03.utils.Utils;

class PrimesUpToInputEx1 {
    public static void main(String[] args) {
        int number = 0;
        int sum = 0;

        number = Integer.parseInt(Utils.input("Input a number."));

        for (int i = 2; i <= number; i++) {
            if (isPrime(i)) {
                sum += i;
            }
        }

        Utils.print(sum);

    }

    private static boolean isPrime(int num) {
        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                return false;
            }

        }
        return true;
    }
}