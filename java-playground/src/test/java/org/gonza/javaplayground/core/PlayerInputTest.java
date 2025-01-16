package org.gonza.javaplayground.core;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PlayerInputTest {
    @Test
    @DisplayName("사용자는 적절한 데이터를 입력할 수 있다.")
    void createPlayerInputSuccessTest() throws Exception {

        PlayerInput playerInput = new PlayerInput("lee,hong,seob", 5);

        assertThat(playerInput.getNames()).isEqualTo("lee,hong,seob");
    }

    @Test
    @DisplayName("경주할 자동차는 2대 이상이어야만 합니다.")
    void createPlayerInputFailTest_namesUnderTwo() throws Exception {
        assertThatThrownBy(() -> new PlayerInput("lee", 5))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("경주할 자동차는 최소 2대 이상이어야 합니다.");
    }

    @ParameterizedTest
    @ValueSource(ints = {-3, -2, -99999})
    @DisplayName("재시도 횟수는 0미만일 수 없다.")
    void createPlayerInputFailTest_retryUnderZero(int invalidRetry) throws Exception {
        assertThatThrownBy(() -> new PlayerInput("lee,hong,seob", invalidRetry))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("재시도 횟수는 0미만일 수 없습니다.");
    }

}
