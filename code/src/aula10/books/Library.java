package aula10.books;

import java.util.HashMap;
import java.util.Map;

public class Library {

    private final Map<Genre, Book> library;

    public Library() {
        this.library = new HashMap<>();
    }


    public void addSection(Genre genre, Book book) {
        if (library.containsKey(genre)) {
            throw new RuntimeException("Section already exists");
        }
        library.put(genre, book);
    }

    public void changeSection(Genre genre, Book book) {
        if (!library.containsKey(genre)) {
            throw new RuntimeException("Section does not exist");
        }
        library.put(genre, book);
    }

    public void removeSection(Genre genre) {
        if (!library.containsKey(genre)) {
            throw new RuntimeException("Section does not exist");
        }
        library.remove(genre);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Genre genre : library.keySet()) {
            sb.append(genre).append(":\n").append("    ").append(library.get(genre)).append("\n");
        }
        return sb.toString();
    }
}
