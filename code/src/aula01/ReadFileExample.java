package aula01;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ReadFileExample {

	public static void main(String[] args) {
		Path fich = Paths.get("src/aula01/major.txt");
		try {
			Files.readAllLines(fich).forEach(System.out::println);
		} catch (IOException e) {
			System.out.println(e.getClass());
			System.out.println("Certifique-se que o ficheiro \"major.txt\" está na raiz da pasta do projeto");
		}
	}

}
