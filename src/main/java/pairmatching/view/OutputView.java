package pairmatching.view;

import java.util.Objects;
import pairmatching.dto.PairDto;
import pairmatching.dto.PairsDto;

public class OutputView {
    public void printCurrentMissionPairs(final PairsDto pairsDto) {
        System.out.println("페어 매칭 결과입니다.");
        for (final PairDto pairDto : pairsDto.getValue()) {
            if (Objects.isNull(pairDto.getThird())) {
                System.out.printf("%s : %s", pairDto.getFirst(), pairDto.getSecond());
                System.out.println();
                continue;
            }
            System.out.printf("%s : %s : %s", pairDto.getFirst(), pairDto.getSecond(), pairDto.getThird());
            System.out.println();
        }
    }
}
