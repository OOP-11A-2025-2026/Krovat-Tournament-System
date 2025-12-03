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

    Tournament tournament = new Tournament(teams);

    if (!teams.isEmpty()) {
        ArrayList<Match> matches = tournament.getWinnersBracket().getRounds().getLast().getMatchesModifiable();
        int matchCount = teams.size() / 2;

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

            System.out.println("\nEntered Matches:");
            for (Match m : matches) {
                System.out.println(m);
            }
        }

    sc.close();
}
