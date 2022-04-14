package pairmatching.domain;

import java.util.List;

public class Pairs {
    private final List<Pair> value;

    public Pairs(final List<Pair> value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Pairs{" +
            "value=" + value +
            '}';
    }

    public boolean hasSamePair(final Pairs OtherPairs) {
        return value.stream()
            .anyMatch(pair -> OtherPairs.hasSamePair(pair));
    }

    private boolean hasSamePair(final Pair OtherPair) {
        return value.stream()
            .anyMatch(pair -> OtherPair.isSame(pair));
    }
}
