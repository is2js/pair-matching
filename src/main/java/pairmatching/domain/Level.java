package pairmatching.domain;

import java.util.Arrays;

public enum Level {
    LEVEL_1("레벨1"),
    LEVEL_2("레벨2"),
    LEVEL_3("레벨3"),
    LEVEL_4("레벨4"),
    LEVEL_5("레벨5"),
    NONE("레벨없음");

    private String name;

    Level(String name) {
        this.name = name;
    }

    public static Level from(final String level) {
        return Arrays.stream(Level.values())
            .filter(it -> it.name.equals(level))
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 Level입니다."));
    }
}
