import java.util.ArrayList;

public class Bracket {
//    private ArrayList<Team> teams = new ArrayList<>(); // Idk if it is needed, uncomment if it is
    private ArrayList<Round> rounds = new ArrayList<>();
    private Team bracketWinner = null;
    private final boolean isWinnerBracket;

    public Bracket(ArrayList<Team> teams, boolean isWinnerBracket) {
//        for (Team team : teams) {
//            if(team == null) throw new NullPointerException("Team is null");
//            this.teams.add(team);
//        }

        this.isWinnerBracket = isWinnerBracket;

        Round firstRound = new Round(teams);
        rounds.add(firstRound);
    }

    @Override
    public String toString() {
        StringBuilder message = new StringBuilder();
        for(int i = 0; i < rounds.size(); i++) {
            Round round = rounds.get(i);
            message.append("\tRound #").append(i).append(": \n");
            message.append(round.toString());
        }

        return message.toString();
    }


//        + Bracket(ArrayList~Team~ teams)
//        %% creates the rounds
//        + Round getLastRound()
//        %% the match is found by id
//        %% checks if there is only one team left - the bracket winner
//        %% if there is - calls getBracketWinner()
//        + Team getBracketWinner()
}
