package aula12.movies;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Stream;

public class MovieShelf {

    private static final Set<Movie> movieShelf = new TreeSet<>();
    private static final Map<String, Integer> genreMap = new HashMap<>();


    public void loadMovies(String pathtofile) throws FileNotFoundException {
        Scanner sc = new Scanner(new File(pathtofile));

        sc.nextLine();

        while (sc.hasNextLine()) {
            String[] line = sc.nextLine().split("\t");

            String name = line[0];
            double score = Double.parseDouble(line[1]);
            String rating = line[2];
            String genre = line[3];
            int runningTime = Integer.parseInt(line[4]);

            Movie movie = new Movie(name, score, rating, genre, runningTime);

            movieShelf.add(movie);
        }

        sc.close();
    }

    public void printSortedByScore() {
        movieShelf.stream().sorted(Comparator.comparing(Movie::getScore).reversed())
            .forEach(System.out::println);
    }

    public void printSortedByRunningTime() {
        movieShelf.stream().sorted(Comparator.comparing(Movie::getRunningTime))
            .forEach(System.out::println);
    }

    public Map<String, Integer> getGenreMap() {
        for (Movie movie : movieShelf) {
            String genre = movie.getGenre();
            int count = genreMap.getOrDefault(genre, 0);
            genreMap.put(genre, ++count);
        }
        return genreMap;
    }

    public void storeMovieShelf(String pathtofile, String genre) throws FileNotFoundException {
        PrintWriter pw = new PrintWriter(pathtofile);

        pw.println("name\tscore\trating\tgenre\trunning time");
        Stream<Movie> movies = movieShelf.stream()
            .filter(movie -> movie.getGenre().equals(genre) && movie.getScore() >= 60);
        movies.forEach(pw::println);

        pw.close();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("name\tscore\trating\tgenre\trunning time");
        for (Movie movie : movieShelf) {
            sb.append("\n").append(movie);
        }
        return sb.toString();
    }

}
