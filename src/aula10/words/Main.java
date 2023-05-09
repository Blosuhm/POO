package aula10.words;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        System.out.println(count("Hi, my name is, who?, my name is"));

    }

    public static Map<Character, List<Integer>> count(String text) {
        Map<Character, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (!map.containsKey(c)) {
                map.put(c, new LinkedList<>());
                map.get(c).add(i);
            } else {
                map.get(c).add(i);
            }
        }
        return map;
    }

}
