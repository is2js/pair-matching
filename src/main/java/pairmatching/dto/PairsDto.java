package pairmatching.dto;

import java.util.List;
import java.util.stream.Collectors;
import pairmatching.domain.Pairs;

public class PairsDto {

    private final List<PairDto> value;

    public PairsDto(final List<PairDto> value) {
        this.value = value;
    }

    public static PairsDto from(final Pairs pairs) {
        final List<PairDto> pairDtos = pairs.getValue()
            .stream()
            .map(PairDto::from)
            .collect(Collectors.toList());
        return new PairsDto(pairDtos);
    }

    public List<PairDto> getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "PairDto{" +
            "value=" + value +
            '}';
    }
}
