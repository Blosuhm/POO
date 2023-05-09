package aula10.readFile;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) throws IOException {
        List<String> words = listOfWords();
        printWordsEndingWithS(words);
        removeNonLetters(words);
        printWordsEndingWithS(words);
    }

    private static List<String> removeNonLetters(List<String> words) {
        words.removeIf(word -> !word.matches("^[a-zA-Z]+$"));
        return words;
    }

    public static void printWords() throws FileNotFoundException {
        Scanner input = new Scanner(new FileReader("./src/aula10/readFile/words.txt"));
        while (input.hasNext()) {
            String word = input.next();
            System.out.println(word);
        }
        input.close();
    }

    public static List<String> listOfWords() throws FileNotFoundException {
        final List<String> words = new LinkedList<>();

        Scanner input = new Scanner(new FileReader("./src/aula10/readFile/words.txt"));
        while (input.hasNext()) {
            String word = input.next();
            System.out.println(word);

            if (word.length() > 2) {
                words.add(word);
            }
        }
        input.close();
        return words;
    }

    public static void printWordsEndingWithS() throws FileNotFoundException {
        Scanner input = new Scanner(new FileReader("./src/aula10/readFile/words.txt"));
        while (input.hasNext()) {
            String word = input.next();
            if (word.endsWith("s")) {
                System.out.println(word);
            }
        }
        input.close();
    }

    public static void printWordsEndingWithS(List<String> words) throws FileNotFoundException {
        for (String word : words) {
            if (word.endsWith("s")) {
                System.out.println(word);
            }
        }
    }
}
