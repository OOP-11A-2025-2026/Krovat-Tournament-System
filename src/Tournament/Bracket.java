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
            message.append("\tRound #").append(i).append(": \n");
            message.append(round.toString());
        }

        return message.toString();
    }

    // Returns a copy of rounds, modifying it will NOT modify the original
    public ArrayList<Round> getRounds() {
        return new ArrayList<Round>(rounds);
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
        ArrayList<Team> participants = rounds.getLast().getWinners();
        rounds.add(new Round(participants));
    }

    // Use this method for losersBracket, parameter participants is the losers from winnersBracket
    public void createNextRound(ArrayList<Team> participants) {
        ArrayList<Team> participants2 = rounds.getLast().getWinners();
        participants.addAll(participants2);
        rounds.add(new Round(participants));
    }

    public void updateBracketWinner() {
        ArrayList<Match> matches = rounds.getLast().getMatchesModifiable();
        if(matches.size() == 1) {
            Team winner = matches.getFirst().getMatchWinner();
            if(winner != null)
                bracketWinner = winner;
        }
    }
}
