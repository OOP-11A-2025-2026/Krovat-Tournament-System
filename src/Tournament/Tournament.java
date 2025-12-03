package Tournament;

import java.util.ArrayList;

public class Tournament {
    private Bracket winnersBracket;
    private Bracket losersBracket = null;
    private Team final_team = null;

    public Tournament(ArrayList<Team> all_teams) {
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


        // Moves losers from winners bracket to losers bracket
    public void processNextWinnersRound() {

        Round lastRound = winnersBracket.getRounds().getLast();

        ArrayList<Team> losers = lastRound.getLosers();

        winnersBracket.createNextRound();

        if (losersBracket == null) {
            losersBracket = new Bracket(losers, false);
        } else {
            losersBracket.createNextRound(losers);
        }
    }

}

