import Tournament.*;
import static Tournament.FileLoader.*;


void main() throws IOException {
    Scanner sc = new Scanner(System.in);
    System.out.print("Select Approach - Read from File (read / r) or Write in Console (write / w): ");

    String choice = sc.nextLine();
    switch(choice) {
        case "read":
        case "r":
            printTeams();
        break;
        case "write":
        case "w":
            ArrayList<Team> teams = new ArrayList<>();

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

    //continues with implementation

    sc.close();
}