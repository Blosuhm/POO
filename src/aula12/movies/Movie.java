package aula12.movies;

public class Movie implements Comparable<Movie> {

    private final String name;
    private final double score;
    private final String rating;
    private final String genre;
    private final int runningTime;

    public Movie(String name, double score, String rating, String genre, int runningTime) {
        this.name = name;
        this.score = score;
        this.rating = rating;
        this.genre = genre;
        this.runningTime = runningTime;
    }

    public String getName() {
        return name;
    }

    public double getScore() {
        return score;
    }

    public int getRunningTime() {
        return runningTime;
    }

    @Override
    public String toString() {
        return String.format("%s\t%s\t%s\t%s\t%s", name, score, rating, genre, runningTime);
    }

    @Override
    public int compareTo(Movie movie) {
        return this.getName().compareTo(movie.getName());
    }

    public String getGenre() {
        return genre;
    }
}
