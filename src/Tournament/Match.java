package Tournament;

public class Match {
    private static int nextId = 1;
    private final int id;

    private Team home;
    private Team away;
    private Team matchWinner = null;

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
        System.out.println();
        StringBuilder message = new StringBuilder("Match " + id + ":\n" + home.toString() + " VS " + away.toString());
        if(matchWinner != null)
        {
            message.append("The winner is ").append(matchWinner.toString()).append("\n");
        }
        return message.toString();
    }

    public int getId() {
        return id;
    }

    public Team getHomeTeam() {
        return home;
    }

    public Team getAwayTeam() {
        return away;
    }

    public Team getMatchWinner() {
        return matchWinner;
    }

    public void setHomeTeam(Team home) {
        if(home == null) throw new IllegalArgumentException("home Team object cannot be null");
        this.home = home;
    }

    public void setAwayTeam(Team away) {
        if(away == null) throw new IllegalArgumentException("away Team object cannot be null");
        this.away = away;
    }

    public void setMatchWinner(Team matchWinner) {
        if(matchWinner == null) throw new IllegalArgumentException("matchWinner Team object cannot be null");
        this.matchWinner = matchWinner;
    }
}
