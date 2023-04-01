package scriptForEval;

import java.util.ArrayList;
import java.util.List;

import scriptForEval.ChessPlayer;

public class TournamentManager {
    private ArrayList<Player> players = new ArrayList<>();
    private String state; // states are: "Not started", "Started", "Finished"

    public TournamentManager() {
        state = "Not started";
    }

    public void addPlayer(Player player) {
        if (state.equals("Started")) {
            throw new IllegalStateException("Tournament already started");
        }
        players.add(player);
    }

    public void removePlayer(Player player) {
        players.remove(player);
    }

    public Player searchForPlayer(String name) {
        for (Player player : players) {
            if (player.getName().equals(name)) {
                return player;
            }
        }
        return null;
    }

    public Player searchForPlayer(int id) {
        for (Player player : players) {
            if (player.getId() == id) {
                return player;
            }
        }
        return null;
    }

    public List<Player> getPlayers() {
        return this.players;
    }

    public void start() {
        state = "Started";
    }

    public void finish() {
        state = "Finished";
    }

    public void nextRound() {
        // Todos os jogos entre todos os jogadores sem repetidos
        for (int i = 0; i < players.size(); i++) {
            for (int j = i + 1; j < players.size(); j++) {
                // Jogo entre os jogadores i e j
                Player player1 = players.get(i);
                Player player2 = players.get(j);
                int elo1 = player1.getElo();
                int elo2 = player2.getElo();
                int gameElo = (elo1 + elo2);
                double random = (Math.random() * (gameElo + 1));

                if (random < (0.8 * elo1)) {
                    player1.setScore(player1.getScore() + 1);
                } else if (random > (elo1 + 0.2 * elo2)) {
                    player1.setScore(player1.getScore() + 0.5);
                    player2.setScore(player2.getScore() + 0.5);
                } else {
                    player2.setScore(player2.getScore() + 1);
                }
            }
        }
    }

}
