package Tournament;

import java.util.ArrayList;

public class Tournament {
    private Bracket winnersBracket;
    private Bracket losersBracket = null;
    private Team final_team = null;
    private Match finalMatch = null;

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
    public void processNextRounds(boolean isNextRoundLosers) {

        Round lastRound = winnersBracket.getRounds().getLast();
        ArrayList<Team> losers = lastRound.getLosers();

        if(!isNextRoundLosers && winnersBracket.getBracketWinner() != null) losersBracket.updateBracketWinner();
        else winnersBracket.updateBracketWinner();

        if(isNextRoundLosers) {
            if (losersBracket == null) {
                losersBracket = new Bracket(losers, false);
            } else {
                losersBracket.createNextRound(losers);
            }
        }
        else {
            winnersBracket.createNextRound();
        }
    }

    public void initializeFinalMatch() {
        finalMatch = new Match(getWinnersBracket().getBracketWinner(), getLosersBracket().getBracketWinner());

    }

    public Match getFinalMatch() {
        return finalMatch;
    }

    private void printBracketHistory(Bracket bracket) {
        ArrayList<Round> rounds = bracket.getRounds();
        for(int i = 0; i < rounds.size(); i++) {
            Round round = rounds.get(i);
            System.out.print("Round " + (i + 1) + ": ");
            System.out.println();

            for(Match m : round.getMatchesModifiable()) {
                printMatchRecord(m);
            }
        }
    }

    private void printMatchRecord(Match match) {
        Team home = match.getHomeTeam();
        Team away = match.getAwayTeam();
        Team winner = match.getMatchWinner();

        System.out.println("Match " + match.getId() + ": " + home.getName() +  " VS " + away.getName() + (winner != null ? " → Winner: " + winner.getName() : " (unfinished)"));
    }

    public void printMatchHistory() {
        System.out.println("=============FULL MATCH HISTORY==============");
        System.out.println("WINNERS BRACKET");
        System.out.println("=============================================");
        printBracketHistory(winnersBracket);
        System.out.println("=============================================");
        System.out.println();
        System.out.println("=============================================");
        System.out.println("LOSERS BRACKET");
        printBracketHistory(losersBracket);
        System.out.println("=============================================");
        System.out.println("OVERALL WINNER: " + getFinalTeam().toString());
        System.out.println("=============================================");
    }
}
