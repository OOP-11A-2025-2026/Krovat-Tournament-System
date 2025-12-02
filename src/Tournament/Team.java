package Tournament;

public class Team {
    private static int nextId = 1;
    private final int id;
    private String name;

    public Team(String name) {
        if (name == null || name.isEmpty()) throw new IllegalArgumentException("tournament.Team name cannot be null or empty");
        this.name = name;

        this.id = nextId;
        nextId++;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.isEmpty()) throw new IllegalArgumentException("tournament.Team name cannot be null or empty");
        this.name = name;
    }

    @Override
    public String toString() {
        return "Team " + id + ": " + name;
    }
}
