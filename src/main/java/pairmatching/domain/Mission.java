package pairmatching.domain;

import static pairmatching.domain.Level.LEVEL_1;
import static pairmatching.domain.Level.LEVEL_2;
import static pairmatching.domain.Level.LEVEL_4;

import java.util.Arrays;

public enum Mission {
    RACING_CAR("자동차경주", LEVEL_1),
    LOTTO("로또", LEVEL_1),
    BASEBALL("숫자야구게임", LEVEL_1),
    BASKET("장바구니", LEVEL_2),
    PAYMENT("결제", LEVEL_2),
    SUBWAY_LINE("지하철노선도", LEVEL_2),
    IMPROVEMENT_PERFORMANCE("성능개선", LEVEL_4),
    DISTRIBUTE("배포", LEVEL_4),
    NONE("", Level.NONE),
    ;

    private final String name;
    private final Level level;

    Mission(final String name, final Level level) {
        this.name = name;
        this.level = level;
    }

    public static Mission from(final String name) {
        return Arrays.stream(Mission.values())
            .filter(it -> it.name.equals(name))
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException("[ERROR] 존재하지 않는 mission입니다."));
    }
}
