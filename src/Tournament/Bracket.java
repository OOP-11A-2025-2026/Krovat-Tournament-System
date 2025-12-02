package Tournament;

import java.util.ArrayList;

public class Bracket {
    private ArrayList<Round> rounds = new ArrayList<>();
    private Team bracketWinner = null;
    private final boolean isWinnerBracket;

    public Bracket(ArrayList<Team> teams, boolean isWinnerBracket) {
        this.isWinnerBracket = isWinnerBracket;

        Round firstRound = new Round(teams);
        rounds.add(firstRound);
    }

    @Override
    public String toString() {
        StringBuilder message = new StringBuilder();
        for(int i = 0; i < rounds.size(); i++) {
            Round round = rounds.get(i);
            message.append("\ttournament.Round #").append(i).append(": \n");
            message.append(round.toString());
        }

        return message.toString();
    }

    // Returns a copy of rounds, modifying it will NOT modify the original
    public ArrayList<Round> getRounds() {
        return new ArrayList<>(rounds);
    }

    public Team getBracketWinner() {
        return bracketWinner;
    }

    public boolean isWinnerBracket() {
        return isWinnerBracket;
    }

    public void setBracketWinner(Team bracketWinner) {
        if(bracketWinner == null) throw new IllegalArgumentException("bracketWinner is null");
        this.bracketWinner = bracketWinner;
    }

    // Use this method for winnersBracket
    public void createNextRound() {
        ArrayList<Team> participants = rounds.getLast().getWinnersModifiable();
        rounds.add(new Round(participants));
    }

    // Use this method for losersBracket, parameter participants is the losers from winnersBracket
    public void createNextRound(ArrayList<Team> participants) {
        ArrayList<Team> participants2 = rounds.getLast().getWinnersModifiable();
        participants.addAll(participants2);
        rounds.add(new Round(participants));
    }

//        + tournament.Round getLastRound()
//        %% the match is found by id
//        %% checks if there is only one team left - the bracket winner
//        %% if there is - calls getBracketWinner()
//        + tournament.Team getBracketWinner()
}
