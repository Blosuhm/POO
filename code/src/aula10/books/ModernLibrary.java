package aula10.books;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class ModernLibrary {

    private final Map<Genre, List<Book>> library;


    public ModernLibrary() {
        this.library = new TreeMap<>();
    }

    public ModernLibrary addGenre(Genre genre) {
        library.put(genre, new ArrayList<>());

        return this;
    }

    public ModernLibrary addBook(Genre genre, Book book) {
        if (!library.containsKey(genre)) {
            throw new IllegalArgumentException("Genre not found");
        }

        library.get(genre).add(book);

        return this;
    }

    public ModernLibrary removeBook(Genre genre, Book book) {
        if (!library.containsKey(genre)) {
            throw new IllegalArgumentException("Genre not found");
        }

        library.get(genre).remove(book);

        return this;
    }

    public ModernLibrary removeGenre(Genre genre) {
        if (!library.containsKey(genre)) {
            throw new IllegalArgumentException("Genre not found");
        }

        library.remove(genre);

        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Genre genre : library.keySet()) {
            sb.append(genre).append(":\n");
            for (Book book : library.get(genre)) {
                sb.append("    ").append(book).append("\n");
            }
        }
        return sb.toString();
    }

}
