package utils;

import java.util.Scanner;

class Test {

    public static void main(String[] args) {
        Utils.print("Hello World");
        Utils.print(2);
    }
}

class Utils {

    public static <T> void print(T toPrint) {
        System.out.println(toPrint);
    }

    public static String input(String s) {
        System.out.print(s);
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();

    }
}