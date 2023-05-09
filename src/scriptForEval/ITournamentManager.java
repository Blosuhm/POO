package scriptForEval;

public interface ITournamentManager {

    void addPlayer(Player player);

    void removePlayer(Player player);

    Player searchForPlayer(String nome);

    Player searchForPlayer(int ID);

    void printTournaments();

    boolean nextRound(); // returns false if tournament ended
}
