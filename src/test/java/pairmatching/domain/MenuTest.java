package pairmatching.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MenuTest {
    @DisplayName("")
    @Test
    void validate() {
        Assertions.assertThatThrownBy(
            () -> Menu.from("4")
        ).isInstanceOf(IllegalArgumentException.class);
    }
}
