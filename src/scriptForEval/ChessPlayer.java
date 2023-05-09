package scriptForEval;

public class ChessPlayer extends Player {

    private int elo = getRandomElo();

    public ChessPlayer(String name, String club) {
        super(name, club);
    }

    private static int getRandomElo() {
        return (int) (Math.random() * 100) + 1;
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

}
