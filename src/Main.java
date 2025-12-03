import Tournament.*;
import static Tournament.FileLoader.*;


void main() throws IOException {

    Scanner sc = new Scanner(System.in);
    System.out.print("Select Approach - Read from File (read / r) or Write in Console (write / w): ");

    ArrayList<Team> teams = new ArrayList<>();
    String choice = sc.nextLine();
    switch(choice) {
        case "read":
        case "r":
            teams = loadTeams(defaultFile);
            printTeams(teams);
        break;
        case "write":
        case "w":

            System.out.println("Enter the names of the teams, separate them by commas (,):");
            writeTeams(sc, teams);

            for (Team team : teams) {
                System.out.println(team);
            }

            System.out.print("Would you like to save the entered teams? (Y/N) ");
            String saveChoice = sc.nextLine().trim();
            if(saveChoice.equalsIgnoreCase("Y")) {
                try {
                    saveTeams(defaultFile, teams);
                } catch (FileNotFoundException e) {
                    System.out.println("Error! - " + e.getMessage());
                }
            }
            else if(saveChoice.equalsIgnoreCase("N")) {
                System.out.println("Teams were not saved");
                break;
            }
            else System.out.println("Invalid option!");
            break;
        default:
            System.out.println("Invalid option!");
    }

    if(teams.isEmpty()) {
        throw new NullPointerException("There are no teams");
    }

    Tournament tournament = new Tournament(teams);
    boolean winnersRound = false;

    ArrayList<Round> rounds;

    while(true) {
        winnersRound = !winnersRound;
        if (winnersRound) {
            if(tournament.getWinnersBracket().getBracketWinner() != null) continue;
            rounds = tournament.getWinnersBracket().getRounds();
        } else {
            if(tournament.getLosersBracket().getBracketWinner() != null) continue;
            rounds = tournament.getLosersBracket().getRounds();
        }

        Round lastRound = rounds.getLast();
        ArrayList<Match> matches = lastRound.getMatchesModifiable();

        for (Match m : matches) {

            System.out.println(m.toString());

            Team home = m.getHomeTeam();
            Team away = m.getAwayTeam();

            System.out.print("Who won? (Enter \"" + home.getName() + "\" or \"" + away.getName() + "\"): ");
            String winnerName = sc.nextLine();

            while (!winnerName.equals(home.getName()) && !winnerName.equals(away.getName())) {
                System.out.print("Invalid Team. Enter Winner again: ");
                winnerName = sc.nextLine();
            }

            if (winnerName.equals(home.getName())) {
                m.setMatchWinner(home);
            } else {
                m.setMatchWinner(away);
            }
        }

        lastRound.updateWinners();

//        System.out.println("Winners last round: ");
//        for(Team winner : lastRound.getWinners())
//            System.out.println(winner);


        tournament.processNextRounds(winnersRound);

//        System.out.println("---------------");
//        System.out.println("Winners Bracket Winner - " + tournament.getWinnersBracket().getBracketWinner());
//        System.out.println("Losers Bracket Winner - " + tournament.getLosersBracket().getBracketWinner());
//        System.out.println("---------------");

        if(tournament.getWinnersBracket().getBracketWinner() != null && tournament.getLosersBracket().getBracketWinner() != null) {
            tournament.initializeFinalMatch();
            break;
        }
    }

    System.out.println("We are down to the FINAL TWO CONTESTANTS: " + tournament.getFinalMatch().toString());
    Team home = tournament.getFinalMatch().getHomeTeam();
    Team away = tournament.getFinalMatch().getAwayTeam();
    System.out.print("Who won? (Enter \"" + home.getName() + "\" or \"" + away.getName() + "\"): ");
    String winnerName = sc.nextLine();

    while (!winnerName.equals(home.getName()) && !winnerName.equals(away.getName())) {
        System.out.print("Invalid Team. Enter Winner again: ");
        winnerName = sc.nextLine();
    }

    if (winnerName.equals(home.getName())) {
        tournament.getFinalMatch().setMatchWinner(home);
        tournament.setFinalTeam(home);
    } else {
        tournament.getFinalMatch().setMatchWinner(away);
        tournament.setFinalTeam(away);
    }

    System.out.println("=============================================");
    System.out.println("We have a winner!               " + tournament.getFinalTeam());
    System.out.println("=============================================");
    System.out.println();

    tournament.printMatchHistory();

    sc.close();
}
