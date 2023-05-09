package scriptForEval;

public class CheckersPlayer extends Player {

    private int elo = getRandomElo();

    public CheckersPlayer(String name, String club) {
        super(name, club);
    }

    private static int getRandomElo() {
        return (int) (Math.random() * 50) + 1;
    }

    @Override
    public int getElo() {
        return this.elo;
    }

    public void setElo(int elo) {
        if (elo < 0) {
            throw new IllegalArgumentException("Elo must be positive");
        }
        this.elo = elo;
    }

    @Override
    public String toString() {
        return "Checkers Player" + getName() + "(" + getClub() + ", " + getElo() + "); Score: "
            + getScore();
    }

}
