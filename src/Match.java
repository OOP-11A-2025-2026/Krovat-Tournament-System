public class Match {
    private static int nextId = 1;
    private final int id;

    private Team home;
    private Team away;
//    private boolean didHomeWin; // Might actually be better to replace with Team matchWinner if the default is false
    Team matchWinner = null;

    public Match(Team home, Team away) {
        if(home == null || away == null) throw new IllegalArgumentException("Team object cannot be null");
        this.home = home;
        this.away = away;

        this.id = nextId;
        nextId++;
    }

    public Match(Team home, Team away, Team matchWinner) {
        if(home == null || away == null) throw new IllegalArgumentException("Team object cannot be null");
        this.home = home;
        this.away = away;
        this.matchWinner = matchWinner;

        this.id = nextId;
        nextId++;
    }

    @Override
    public String toString() {
        StringBuilder message = new StringBuilder("Match #" + id + "\n" + home.toString() + " VS " + away.toString());
        if(matchWinner != null)
        {
            message.append("The winner is ").append(matchWinner.toString()).append("\n");
        }
        return message.toString();
    }

//        + Team getHomeTeam()
//        + Team getAwayTeam()
}
