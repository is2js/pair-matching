package pairmatching.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Pair {
    private final Crew first;
    private final Crew second;
    private final Crew third;

    public Pair(final Crew first, final Crew second) {
        this(first, second, new Crew(null, null));
    }

    public Pair(final Crew first, final Crew second, final Crew third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }

    @Override
    public String toString() {
        return "Pair{" +
            "first=" + first.getName() +
            ", second=" + second.getName() +
            ", third=" + third.getName() +
            '}';
    }

    @Override
    public boolean equals(final Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }

        final Pair pair = (Pair) object;

        if (first != null ? !first.equals(pair.first) : pair.first != null) {
            return false;
        }
        if (second != null ? !second.equals(pair.second) : pair.second != null) {
            return false;
        }
        return third != null ? third.equals(pair.third) : pair.third == null;
    }

    @Override
    public int hashCode() {
        int result = first != null ? first.hashCode() : 0;
        result = 31 * result + (second != null ? second.hashCode() : 0);
        result = 31 * result + (third != null ? third.hashCode() : 0);
        return result;
    }

    public boolean isSame(final Pair pair) {
        final List<Crew> allCrews = getAllCrews();
        return allCrews.containsAll(pair.getAllCrews());
    }

    public List<Crew> getAllCrews() {
        Stream<Crew> crews = Stream.of(first, second);
        if (third != null) {
            crews = Stream.concat(crews, Stream.of(third));
        }
        return crews.collect(Collectors.toList());
    }

    public Crew getFirst() {
        return first;
    }

    public Crew getSecond() {
        return second;
    }

    public Crew getThird() {
        return third;
    }
}
