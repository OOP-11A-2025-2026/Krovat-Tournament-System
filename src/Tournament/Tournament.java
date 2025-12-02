package Tournament;

import java.util.ArrayList;

public class Tournament {
//    private ArrayList<tournament.Team> all_teams = new ArrayList<>(); // Idk if it is needed, uncomment if it is
    private Bracket winnersBracket;
    private Bracket losersBracket = null;
    private Team final_team = null;

    public Tournament(ArrayList<Team> all_teams) {
//        for (tournament.Team team : all_teams) {
//            if(team == null) throw new NullPointerException("tournament.Team is null");
//            this.all_teams.add(team);
//        }

        winnersBracket = new Bracket(all_teams, true);
    }

    @Override
    public String toString() {
        return "Winners bracket: \n" + winnersBracket.toString() + "\n" +
                "Losers bracket: \n" + losersBracket.toString() + "\n" +
                "The winner of the tournament is: \n" + final_team.toString();
    }

    public Bracket getWinnersBracket() {
        return winnersBracket;
    }

    public Bracket getLosersBracket() {
        return losersBracket;
    }

    public Team getFinalTeam() {
        return final_team;
    }

    public void setFinalTeam(Team final_team) {
        if(final_team == null) throw new IllegalArgumentException("final_team is null");
        this.final_team = final_team;
    }

    // getInfoNextRound(tournament.Bracket bracket)
    // or getInfoNextRound(book winnerBracket) - if true winnersBracket else losersBracket
}
