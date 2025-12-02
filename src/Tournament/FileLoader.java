package Tournament;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.PrintWriter;


public class FileLoader {

    public static final String defaultFile = "src/Tournament/data.csv";

    public static void saveTeams(String filename, ArrayList<Team> teams) throws FileNotFoundException {
        PrintWriter writer = new PrintWriter(filename);
        for(int i = 0; i < teams.size(); i++) {
            writer.print(teams.get(i).getName());
            if(i < teams.size() - 1)
                writer.print(", ");
        }

        System.out.println("Data saved to " + filename);
        writer.close();
    }

    public static ArrayList<Team> loadTeams(String filename) throws FileNotFoundException {
        ArrayList<Team> teams = new ArrayList<>();

        File file = new File(filename);
        if(!file.exists()) throw new FileNotFoundException("File doesn't exist!");
        if(file.length() == 0) throw new FileNotFoundException("File is empty!");
        Scanner reader = new Scanner(file);

        while(reader.hasNextLine()) {
            String line = reader.nextLine().trim();
            if(line.isEmpty()) continue;
            String[] names = line.split(",");
            for (String name : names) {
                name = name.trim();
                if(name.isEmpty()) continue;
                Team team = new Team(name);
                teams.add(team);
            }
        }

        reader.close();
        return teams;
    }

    public static void writeTeams(Scanner sc, ArrayList<Team> teams) {
        String line = sc.nextLine().trim();
        if(line.isEmpty()) return;
        String[] names = line.split(",");
        for(String name : names) {
            name = name.trim();
            if(name.isEmpty()) continue;
            Team team = new Team(name);
            teams.add(team);
        }
    }

    public static void printTeams() {
        try {
            ArrayList<Team> teams = loadTeams(defaultFile);

            for (Team team : teams) {
                System.out.println(team);
            }
        }
        catch(FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}

