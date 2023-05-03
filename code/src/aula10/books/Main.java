package aula10.books;

public class Main {

    public static void main(String[] args) {
        System.out.println("------------- Testing Library -------------\n");

        System.out.println("Creating library...");
        Library library = new Library();

        // Add some sections with books
        System.out.println("Adding sections...");
        library.addSection(Genre.DRAMA, new Book("Hamlet", "William Shakespeare", 1600));
        library.addSection(Genre.COMEDY,
            new Book("The Hitchhiker's Guide to the Galaxy", "Douglas Adams", 1979));
        library.addSection(Genre.ROMANCE, new Book("Pride and Prejudice", "Jane Austen", 1813));
        library.addSection(Genre.FANTASY,
            new Book("The Lord of the Rings", "J.R.R. Tolkien", 1954));
        library.addSection(Genre.HORROR, new Book("Dracula", "Bram Stoker", 1897));

        // Print out the library's contents
        System.out.println(library);

        // Change a section's book
        System.out.println("Changing a section's book...");
        library.changeSection(Genre.COMEDY,
            new Book("Good Omens", "Terry Pratchett and Neil Gaiman", 1990));

        // Remove a section
        System.out.println("Removing a section...");
        library.removeSection(Genre.HORROR);

        // Print out the updated library's contents
        System.out.println(library);

        System.out.println("------------- Testing Modern Library -------------\n");

        // Create a new library
        System.out.println("Creating library...");
        ModernLibrary modernLibrary = new ModernLibrary();

        // Add genres
        System.out.println("Adding genres...");
        modernLibrary.addGenre(Genre.DRAMA)
            .addGenre(Genre.COMEDY)
            .addGenre(Genre.ROMANCE)
            .addGenre(Genre.FANTASY)
            .addGenre(Genre.HORROR);

        // Add books to genres
        System.out.println("Adding books...");
        modernLibrary.addBook(Genre.DRAMA, new Book("Hamlet", "William Shakespeare", 1600))
            .addBook(Genre.DRAMA, new Book("Death of a Salesman", "Arthur Miller", 1949))
            .addBook(Genre.COMEDY, new Book("The Importance of Being Earnest", "Oscar Wilde", 1895))
            .addBook(Genre.ROMANCE, new Book("Pride and Prejudice", "Jane Austen", 1813))
            .addBook(Genre.FANTASY, new Book("The Lord of the Rings", "J.R.R. Tolkien", 1954))
            .addBook(Genre.HORROR, new Book("Dracula", "Bram Stoker", 1897))
            .addBook(Genre.HORROR, new Book("The Shining", "Stephen King", 1977));

        // Print the modernLibrary
        System.out.println(modernLibrary);

        // Remove a book
        System.out.println("Removing a book...");
        modernLibrary.removeBook(Genre.HORROR, new Book("Dracula", "Bram Stoker", 1897));

        System.out.println(modernLibrary);

        // Remove a genre
        System.out.println("Removing a genre...");
        modernLibrary.removeGenre(Genre.HORROR);

        // Print the updated modernLibrary
        System.out.println(modernLibrary);
    }

}
