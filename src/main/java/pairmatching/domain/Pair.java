package pairmatching.domain;

public class Pair {
    private final Crew first;
    private final Crew second;
    private final Crew third;

    public Pair(final Crew first, final Crew second) {
        this(first, second, null);
    }

    public Pair(final Crew first, final Crew second, final Crew third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }

    @Override
    public String toString() {
        return "Pair{" +
            "first=" + first +
            ", second=" + second +
            ", third=" + third +
            '}';
    }
}
