package aula10.readFile;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(new FileReader("./src/aula10/readFile/words.txt"));
        while (input.hasNext()) {
            String word = input.next();
            System.out.println(word);
        }
    }

}
