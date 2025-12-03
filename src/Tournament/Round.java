package Tournament;

import java.util.ArrayList;

public class Round {
    private ArrayList<Team> teams = new ArrayList<>();
    private ArrayList<Match> matches = new ArrayList<>();
    private ArrayList<Team>  winners = new ArrayList<>();
    private Team byeGiven = null;

    public Round(ArrayList<Team> teams) {
        for (Team team : teams) {
            if(team == null) throw new NullPointerException("tournament.Team is null");
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

    // Modifying the returned value will modify the original
    public ArrayList<Match> getMatchesModifiable() {
        return matches;
    }

    // Modifying the returned value will modify the original
    public ArrayList<Team> getWinnersModifiable() {
        return winners;
    }

    // Returns a copy of teams, modifying it will NOT modify the original
    public ArrayList<Team> getTeams() {
        return new ArrayList<>(teams);
    }

        //Returns all losing teams from this round
    public ArrayList<Team> getLosers() {
        ArrayList<Team> losers = new ArrayList<>();

        for (Match m : matches) {
            if (m.getMatchWinner() == null) continue;

            if (m.getMatchWinner() == m.getHomeTeam()) {
                losers.add(m.getAwayTeam());
            } else {
                losers.add(m.getHomeTeam());
            }
        }

        return losers;
    }

    public void updateWinners() {
        winners.clear();


        if (byeGiven != null) {
            winners.add(byeGiven);
        }


        for (Match m : matches) {
            Team w = m.getMatchWinner();
            if (w != null) {
                winners.add(w);
            }
        }
    }

}


