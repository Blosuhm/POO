package aula04;

import java.util.Scanner;
import Utils.UserInputDouble;
import java.util.ArrayList;

public class figureMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int escolha;
        ArrayList<Object> figures = new ArrayList<Object>();
        do {
            System.out.println("1 - Add Circle");
            System.out.println("2 - Add Triangle");
            System.out.println("3 - Add Rectangle");
            System.out.println("0 - Sair");
            System.out.print("Selecione uma opção: ");

            escolha = sc.nextInt();
            System.out.println("");
            switch (escolha) {
            case 1:
                System.out.print("Insert the radius of your circle- ");

                double radius = UserInputDouble.superior(0);
                figureCircle figura1 = new figureCircle(radius);
                figures.add(figura1);
                break;
            case 2:
                System.out.print("Insert side A of your triangle- ");
                double ladoA = UserInputDouble.superior(0);

                System.out.print("Insert side B of your triangle- ");
                double ladoB = UserInputDouble.superior(0);

                System.out.print("Insert side C of your triangle- ");
                double ladoC = UserInputDouble.superior(0);

                figureTriangle figura2 = new figureTriangle(ladoA, ladoB, ladoC);
                figures.add(figura2);
                break;
            case 3:
                System.out.print("Insert the length of your rectangle- ");
                double length = UserInputDouble.superior(0);

                System.out.print("Insert the height of your rectangle- ");
                double height = UserInputDouble.superior(0);

                if (length == height) {
                    System.out.println("Did you know that squares are also rectangles?");
                }

                figureRectangle figura3 = new figureRectangle(length, height);
                figures.add(figura3);
                break;
            case 0:
                System.out.println("Até mais!\n");
                break;
            default:
                System.out.println("Opção inválida!\n");
            }
        } while (escolha != 0);

        System.out.println(figures + "\n");

        for (int i = 0; i <= (figures.size()) - 1; i++) {
            System.out.println(figures.get(i));
        }

        System.out.print("Indica o indice da lista que queres comparar- ");
        int escolha1 = sc.nextInt();

        System.out.print("Indica o indice da lista que queres comparar- ");
        int escolha2 = sc.nextInt();

        if ((figures.get(escolha1)).getClass() == (figures.get(escolha2)).getClass()
                && figures.get(escolha1).equals(figures.get(escolha2))) {
            System.out.println("As figuras são iguais!");
        } else {
            System.out.println("As figuras têm dimensões diferentes ou não são do mesmo tipo");
        }
        sc.close();
    }
}