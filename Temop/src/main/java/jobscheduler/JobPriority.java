package jobscheduler;

public enum JobPriority {
    HIGH(0),
    LOW(2),
    MEDIUM(1);

    private final int rank;

    JobPriority(int rank) {
        this.rank = rank;
    }

    public int getRank() {
        return rank;
    }
}
