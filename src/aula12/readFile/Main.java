package aula12.readFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        countWords();
        fancyCount();
    }

    private static void countWords() throws FileNotFoundException {
        List<String> words = new ArrayList<>();
        Scanner sc = new Scanner(new File("src/aula12/readFile/A_cidade_e_as_serras.txt"));

        while (sc.hasNext()) {
            String word = sc.next();
            words.add(word);
        }

        sc.close();

        System.out.println("Total number of words: " + words.size());
        List<String> uniqueWords = new ArrayList<>();

        for (String word : words) {
            if (uniqueWords.contains(word)) {
                continue;
            }
            uniqueWords.add(word);
        }
        System.out.println("Total number of unique words: " + uniqueWords.size());
    }

    private static void fancyCount() throws FileNotFoundException {
        List<String> words = new ArrayList<>();
        Scanner sc = new Scanner(new File("src/aula12/readFile/A_cidade_e_as_serras.txt"));

        while (sc.hasNext()) {
            String word = sc.next();
            String[] cleanWords = clean(word);
            for (String cleanWord : cleanWords) {
                if (cleanWord.length() > 2) {
                    cleanWord = cleanWord.toLowerCase();
                    words.add(cleanWord);
                }
            }
        }
        Map<Character, Map<String, Integer>> fancyStorage = new TreeMap<>();
        for (String word : words) {
            Map<String, Integer> charStorage;

            char firstChar = word.charAt(0);

            if (fancyStorage.containsKey(firstChar)) {
                charStorage = fancyStorage.get(firstChar);
            } else {
                charStorage = new TreeMap<>();
                fancyStorage.put(firstChar, charStorage);
            }

            if (charStorage.containsKey(word)) {
                int prevCount = charStorage.get(word);
                charStorage.put(word, ++prevCount);
            } else {
                charStorage.put(word, 1);
            }
        }

        System.out.println(fancyStorage);
    }

    private static String[] clean(String word) {
        return word.split("[\\t\\n.,:'‘’;?!\\-*{}_^=#$1234567890+&/()\\[\\]”“\"]");
    }
}
