package pairmatching.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PairMissionTest {
    @DisplayName("")
    @Test
    void valid_create() {
        Assertions.assertDoesNotThrow(
            () -> new PairMission("백엔드, 레벨1, 자동차경주")
        );
    }

    @DisplayName("")
    @Test
    void invalid_create() {
        org.assertj.core.api.Assertions.assertThatThrownBy(
            () -> new PairMission("중간엔드, 레벨1, 자동차경주")
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("")
    @Test
    void is_backend() {
        final PairMission pairMission = new PairMission("백엔드, 레벨1, 자동차경주");

        final boolean isBackend = pairMission.isBackend();

        assertThat(isBackend).isTrue();
    }
}
