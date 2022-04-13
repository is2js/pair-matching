package pairmatching.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CrewTest {

    @DisplayName("")
    @Test
    void create() {
        Assertions.assertDoesNotThrow(
            () -> new Crew(Course.BACKEND, "재성")
        );
    }
}
