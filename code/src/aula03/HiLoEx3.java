package aula03;

import aula03.utils.Utils;

public class HiLoEx3 {
    public static void main(String[] args) {
        boolean continueGame = true;

        do {
            hilo();
            continueGame = Utils.input("Do you want to play again? (y/n)").equals("y");
        } while (continueGame);

    }

    private static int generateNumber() {
        return (int) (Math.random() * 100) + 1;
    }

    private static void hilo() {
        int number = 0;
        int guess = 0;
        int tries = 0;

        number = generateNumber();

        while (true) {
            tries++;
            guess = Integer.parseInt(Utils.input("Input your guess."));
            if (guess == number) {
                Utils.print("You guessed it!");
                break;
            }
            if (guess > number) {
                Utils.print("Too high!");
                continue;
            }
            Utils.print("Too low!");

        }

        Utils.print("It took you " + tries + " tries to guess the number.");
    }
}
