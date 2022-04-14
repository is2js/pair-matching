package pairmatching.dto;

import pairmatching.domain.Crew;
import pairmatching.domain.Pair;

public class PairDto {

    private final String first;
    private final String second;
    private final String third;

    public PairDto(final String first, final String second, final String third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }

    public static PairDto from(final Pair pair) {
        final Crew first = pair.getFirst();
        final Crew second = pair.getSecond();
        final Crew third = pair.getThird();
        return new PairDto(first.getName(), second.getName(), third.getName());
    }

    public String getFirst() {
        return first;
    }

    public String getSecond() {
        return second;
    }

    public String getThird() {
        return third;
    }
}
