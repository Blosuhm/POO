package src.aula03.utils;

import java.util.Scanner;

public class Utils {
    public static void print(String s) {
        System.out.println(s);
    }

    public static void print(int i) {
        System.out.println(i);
    }

    public static void print(double d) {
        System.out.println(d);
    }

    public static void print(boolean b) {
        System.out.println(b);
    }

    public static void print(char c) {
        System.out.println(c);
    }

    public static void print(Object o) {
        System.out.println(o);
    }

    public static void print(String[] s) {
        for (String str : s) {
            System.out.println(str);
        }
    }

    public static void print(int[] i) {
        for (int in : i) {
            System.out.println(in);
        }
    }

    public static void print(double[] d) {
        for (double db : d) {
            System.out.println(db);
        }
    }

    public static void print(boolean[] b) {
        for (boolean bo : b) {
            System.out.println(bo);
        }
    }

    public static void print(char[] c) {
        for (char ch : c) {
            System.out.println(ch);
        }
    }

    public static void print(Object[] o) {
        for (Object obj : o) {
            System.out.println(obj);
        }
    }

    public static String input(String s) {
        System.out.print(s);
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();

    }
}