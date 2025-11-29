import java.util.ArrayList;

public class Round {
    private ArrayList<Team> teams = new ArrayList<>();
    private ArrayList<Match> matches = new ArrayList<>();
    private ArrayList<Team>  winners = new ArrayList<>();
    private Team byeGiven = null;

    public Round(ArrayList<Team> teams) {
        for (Team team : teams) {
            if(team == null) throw new NullPointerException("Team is null");
            this.teams.add(team);
        }

        int size = teams.size();

        // Deals with byes
        if(size % 2 == 1)
        {
            this.winners.add(teams.get(size - 1));
            size--;
            byeGiven = teams.get(size - 1);
        }

        for(int i = 0; i < size; i+=2)
        {
            matches.add(new Match(teams.get(i), teams.get(i+1)));
        }

    }

    @Override
    public String toString() {
        StringBuilder message = new StringBuilder();
        for (Match match : matches) {
            message.append(match.toString());
        }

        if(byeGiven != null) {
            message.append("A bye has been given to ").append(byeGiven.toString()).append("\n");
        }

        return message.toString();
    }

//        + Round(ArrayList~Team~ teams)
//        %% creates the matches
//        + ArrayList~Match~ getMatches()
//        + ArrayList~Team~ getTeams()
//        + ArrayList~Team~ getWinners()
//        + void setWinners(ArrayList~Team~ winners)
//        %% the match is found by id
}
