import Tournament.*;
import static Tournament.FileLoader.*;

void main() throws IOException {
    Scanner sc = new Scanner(System.in);
    System.out.print("Select Approach - Read from File (read / r) or Write in Console (write / w): ");

    String choice = sc.nextLine();
    if(choice.equals("read") || choice.equals("r")) {
        printTeams();
    }
    else if(choice.equals("write") || choice.equals("w")) {
        ArrayList<Team> teams = new ArrayList<>();

        System.out.println("Enter the names of the teams, separate them by commas (,):");

        while(true) {
            String line = sc.nextLine().trim();
            if(line.isEmpty()) break;
            String[] names = line.split(",");
            for(String name : names) {
                name = name.trim();
                if(name.isEmpty()) continue;
                Team team = new Team(name);
                teams.add(team);
            }
        }

        for (Team team : teams) {
            System.out.println(team);
        }

        System.out.print("Would you like to save the entered teams? (Y/N) ");
        if(sc.nextLine().trim().equalsIgnoreCase("Y")) {
            try {
                saveTeams("src/Tournament/data.csv", teams);
            } catch (FileNotFoundException e) {
                System.out.println("Error! - " + e.getMessage());
            }
        }
        //else if(sc.nextLine().trim().equalsIgnoreCase("N"))
            //go to the implementation
        else System.out.println("Invalid option!");
    }
    else System.out.println("Invalid option!");
    sc.close();
}