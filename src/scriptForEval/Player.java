package scriptForEval;

public abstract class Player {

    private static int nextId = 0;
    private String name;
    private String club;
    private int id = 0;
    private double score = 0;

    public Player(String name, String club) {
        this.name = name;
        this.club = club;
        this.id = nextId++;
    }

    public abstract int getElo();

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClub() {
        return this.club;
    }

    public void setClub(String club) {
        this.club = club;
    }

    public int getId() {
        return this.id;
    }

    public double getScore() {
        return this.score;
    }

    public void setScore(double score) {
        this.score = score;
    }

}
