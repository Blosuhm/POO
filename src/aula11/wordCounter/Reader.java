package aula11.wordCounter;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Reader {

    private static final List<String> words = new ArrayList<>();
    private static final Map<String, Map<String, Integer>> wordCount = new TreeMap<>();

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("src/aula11/wordCounter/major.txt"));
        while (sc.hasNext()) {
            String word = sc.next();

            String[] processedWord = word.split("[\\t\\n.,:'‘’;?!\\-*{}=+&/()\\[\\]”“\"]");

            for (String w : processedWord) {
                if (w.length() > 2) {
                    words.add(w.toLowerCase());
                }
            }
        }
        words.forEach(System.out::println);

        for (int i = 0; i < words.size() - 1; i++) {
            String word = words.get(i);
            String pair = words.get(i + 1);

            addWord(word, pair);
        }

        for (String word : wordCount.keySet()) {
            System.out.println(word + "=" + wordCount.get(word));
        }
    }

    private static void addWord(String word, String pair) {
        final Map<String, Integer> pairs;
        if (wordCount.containsKey(word)) {
            pairs = wordCount.get(word);
        } else {
            pairs = new TreeMap<>();
        }

        if (pairs.containsKey(pair)) {
            pairs.put(pair, pairs.get(pair) + 1);
        } else {
            pairs.put(pair, 1);
        }

        wordCount.put(word, pairs);

    }

}
