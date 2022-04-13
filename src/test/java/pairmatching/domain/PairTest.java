package pairmatching.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PairTest {

    private Crew 재성;
    private Crew 포키;
    private Crew 이스트;

    @BeforeEach
    void setUp() {
        재성 = new Crew(Course.BACKEND, "재성");
        포키 = new Crew(Course.BACKEND, "포키");
        이스트 = new Crew(Course.BACKEND, "이스트");
    }

    @DisplayName("")
    @Test
    void name() {
        final Pair pair = new Pair(재성, 포키);
        final Pair pair2 = new Pair(포키, 재성);
        final Pair pair3 = new Pair(이스트, 포키, 재성);
        final Pair pair4 = new Pair(포키, 재성, 이스트);

        Assertions.assertThat(pair3.isSame(pair4)).isTrue();
    }

    @DisplayName("")
    @Test
    void name2() {
        final Pair pair = new Pair(재성, 포키);
        final Pair pair2 = new Pair(포키, 재성);

        Assertions.assertThat(pair.isSame(pair2)).isTrue();
    }
}
