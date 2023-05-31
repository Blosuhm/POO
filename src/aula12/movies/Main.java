package aula12.movies;

import java.io.FileNotFoundException;

public class Main {

    private final static MovieShelf movieShelf = new MovieShelf();

    public static void main(String[] args) throws FileNotFoundException {
        movieShelf.loadMovies("src/aula12/movies/movies.tsv");
        System.out.println(movieShelf);
        System.out.println();
        movieShelf.printSortedByScore();
        System.out.println();
        movieShelf.printSortedByRunningTime();
        System.out.println(movieShelf.getGenreMap());
        movieShelf.storeMovieShelf("src/aula12/movies/myselection.txt", "comedy");
    }

}
