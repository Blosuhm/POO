package scriptForEval;

import java.util.Scanner;

public class TournamentManagerMain {

    static TournamentManager chessTournament = new TournamentManager();
    static TournamentManager checkersTournament = new TournamentManager();
    static boolean tournamentStarted = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String choice = "";

        while (!choice.equals("7")) {
            System.out.println("TournamentManager Menu:");
            System.out.println("1. Add player");
            System.out.println("2. Remove player");
            System.out.println("3. Start game");
            System.out.println("4. New round");
            System.out.println("5. Search player");
            System.out.println("6. Print tournament(s) info");
            System.out.println("7. Exit");

            System.out.print("Enter choice: ");
            choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    addPlayer();
                    break;
                case "2":
                    removePlayer();
                    break;
                case "3":
                    startTournament();
                    break;
                case "4":
                    newRound();
                    break;
                case "5":
                    searchPlayer();
                    break;
                case "6":
                    printPlayers();
                    break;
                case "7":
                    System.out.println("Exiting program.");
                    break;
                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        }
        scanner.close();
    }

    private static void searchPlayer() {
        Scanner scanner = new Scanner(System.in);
        String game;
        String name;
        int id;

        System.out.println("1 - Chess");
        System.out.println("2 - Checkers");
        game = scanner.nextLine();

        if (game.equals("1")) {
            System.out.println("Enter player name: ");
            name = scanner.nextLine();
            System.out.println(chessTournament.searchForPlayer(name));
        } else if (game.equals("2")) {
            System.out.println("Enter player id: ");
            id = scanner.nextInt();
            System.out.println(checkersTournament.searchForPlayer(id));
        } else {
            System.out.println("Invalid choice.");
        }
    }

    private static void printPlayers() {
        System.out.println("Chess tournament:");
        for (Player player : chessTournament.getPlayers()) {
            System.out.println(player);
        }
        System.out.println("Checkers tournament:");
        for (Player player : checkersTournament.getPlayers()) {
            System.out.println(player);
        }
    }

    private static void newRound() {
        Scanner scanner = new Scanner(System.in);
        String game;

        System.out.println("1 - Chess");
        System.out.println("2 - Checkers");
        game = scanner.nextLine();

        if (game.equals("1")) {
            chessTournament.nextRound();
        } else if (game.equals("2")) {
            checkersTournament.nextRound();
        } else {
            System.out.println("Invalid choice.");
        }
    }

    private static void startTournament() {
        tournamentStarted = true;
        chessTournament.start();
        checkersTournament.start();
        chessTournament.nextRound();
        checkersTournament.nextRound();

    }

    private static void removePlayer() {
        Scanner scanner = new Scanner(System.in);
        String name;
        String id;
        String game;
        String choice;
        TournamentManager tournament;

        System.out.println("1 - Chess");
        System.out.println("2 - Checkers");
        game = scanner.nextLine();

        if (game.equals("1")) {
            tournament = chessTournament;
        } else if (game.equals("2")) {
            tournament = checkersTournament;
        } else {
            System.out.println("Invalid choice.");
            return;
        }

        System.out.println("1 - By name");
        System.out.println("2 - By ID");
        choice = scanner.nextLine();

        if (choice.equals("1")) {
            System.out.print("Enter player name: ");
            name = scanner.nextLine();

            tournament.removePlayer(tournament.searchForPlayer(name));

        } else if (choice.equals("2")) {
            System.out.print("Enter player ID: ");
            id = scanner.nextLine();

            if (!id.matches("[0-9]+")) {
                System.out.println("Invalid ID.");
                return;
            }

            tournament.removePlayer(tournament.searchForPlayer(Integer.parseInt(id)));
        } else {
            System.out.println("Invalid choice.");
        }

    }

    private static void addPlayer() {
        Scanner scanner = new Scanner(System.in);
        String name;
        String club;
        String game;
        if (tournamentStarted) {
            System.out.println("Tournament already started.");
            return;
        }

        System.out.println("1 - Chess");
        System.out.println("2 - Checkers");

        System.out.print("Enter game: ");
        game = scanner.nextLine();

        System.out.print("Enter player name: ");
        name = scanner.nextLine();
        System.out.print("Enter player club: ");
        club = scanner.nextLine();

        if (game.equals("1")) {
            ChessPlayer player = new ChessPlayer(name, club);
            chessTournament.addPlayer(player);
        } else if (game.equals("2")) {
            CheckersPlayer player = new CheckersPlayer(name, club);
            checkersTournament.addPlayer(player);
        } else {
            System.out.println("Invalid choice.");
        }

    }
}