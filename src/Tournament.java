import java.util.ArrayList;

public class Tournament {
//    private ArrayList<Team> all_teams = new ArrayList<>(); // Idk if it is needed, uncomment if it is
    private Bracket winnersBracket;
    private Bracket losersBracket = null;
    private Team final_team = null;

    public Tournament(ArrayList<Team> all_teams) {
//        for (Team team : all_teams) {
//            if(team == null) throw new NullPointerException("Team is null");
//            this.all_teams.add(team);
//        }

        winnersBracket = new Bracket(all_teams, true);
    }

    @Override
    public String toString() {
        return "Winnners bracket: \n" + winnersBracket.toString() + "\n" +
                "Losers bracket: \n" + losersBracket.toString() + "\n" +
                "The winner of the tournament is: \n" + final_team.toString();
    }

    // getInfoNextRound(Bracket bracket)
    // or getInfoNextRound(book winnerBracket) - if true winnersBracket else losersBracket
}
