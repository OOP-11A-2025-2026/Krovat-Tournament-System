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
            printTeams();
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

    if (!teams.isEmpty()) {
        ArrayList<Match> matches = new ArrayList<>();
        int matchCount;

        while(true) {
            System.out.print("Enter number of matches: ");
            String input = sc.nextLine().trim();

            try {
                matchCount = Integer.parseInt(input);
                if(matchCount <= 0) {
                    System.out.println("Enter a positive number!");
                    continue;
                }
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("Error! - " + e.getMessage());
            }
        }

        for (int i = 0; i < matchCount; i++) {
            System.out.println("\nMatch " + (i + 1) + ":");

            Team homeTeam = null;
            Team awayTeam = null;

            while (true) {
                System.out.print("Enter home team: ");
                String homeName = sc.nextLine().trim();

                System.out.print("Enter away team: ");
                String awayName = sc.nextLine().trim();

                if (homeName.equalsIgnoreCase(awayName)) {
                    System.out.println("A team cannot play against itself! Try again.");
                    continue;
                }

                for(Team t : teams) {
                    if(t.getName().equals(homeName)) homeTeam = t;
                    if(t.getName().equals(awayName)) awayTeam = t;
                }

                if (homeTeam == null || awayTeam == null) {
                    System.out.println("One or both teams do not exist. Available teams:");
                    for (Team t : teams) System.out.println(" - " + t.getName());
                    continue;
                }

                break;
            }

            Match match = new Match(homeTeam, awayTeam);

            System.out.print("Who won? (Enter \"" + homeTeam.getName() + "\" or \"" + awayTeam.getName() + "\"): ");
            String winnerName = sc.nextLine();

            while (!winnerName.equals(homeTeam.getName()) && !winnerName.equals(awayTeam.getName())) {
                System.out.print("Invalid Team. Enter Winner again: ");
                winnerName = sc.nextLine();
            }

            if (winnerName.equals(homeTeam.getName())) {
                match.setMatchWinner(homeTeam);
            } else {
                match.setMatchWinner(awayTeam);
            }

            matches.add(match);
        }

        System.out.println("\nEntered Matches:");
        for (Match m : matches) {
            System.out.println(m);
        }
    }

    sc.close();
}
