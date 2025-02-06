package org.gonza.javaplayground.core;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PlayerInputTest {
    @Test
    @DisplayName("사용자는 적절한 데이터를 입력할 수 있다.")
    void createPlayerInputSuccessTest() throws Exception {

        PlayerInput playerInput = new PlayerInput(List.of("lee", "hong", "seob"), 5);

        assertThat(playerInput.getNames()).isEqualTo(List.of("lee", "hong", "seob"));
    }

    @Test
    @DisplayName("경주할 자동차는 2대 이상이어야만 한다.")
    void createPlayerInputFailTest_namesUnderTwo() throws Exception {
        assertThatThrownBy(() -> new PlayerInput(List.of("lee"), 5)).isInstanceOf(IllegalArgumentException.class).hasMessage("경주할 자동차는 최소 2대 이상이어야 합니다.");
    }

    @ParameterizedTest
    @ValueSource(ints = {-3, -2, -99999, 0})
    @DisplayName("재시도 횟수는 0보다 커야한다.")
    void createPlayerInputFailTest_retryUnderZero(int invalidRetry) throws Exception {
        assertThatThrownBy(() -> new PlayerInput(List.of("lee", "hong", "seob"), invalidRetry)).isInstanceOf(IllegalArgumentException.class).hasMessage("재시도 횟수는 0이상이어야 합니다.");
    }

    // 빠진 테스트 케이스 추가
    @Test
    @DisplayName("자동차 이름 목록이 null이면 예외가 발생한다.")
    void createPlayerInputFailTest_nullNames() throws Exception {
        assertThatThrownBy(() -> new PlayerInput(null, 5))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름 목록이 null일 수 없습니다.");
    }

    @Test
    @DisplayName("자동차 이름 목록을 정상적으로 반환한다.")
    void getNamesReturnCorrectValue() throws Exception {
        List<String> names = List.of("lee", "hong", "seob");
        PlayerInput playerInput = new PlayerInput(names, 5);

        assertThat(playerInput.getNames()).isEqualTo(names);
    }

    @Test
    @DisplayName("시도 횟수를 정상적으로 반환한다.")
    void getRetryReturnCorrectValue() throws Exception {
        int retry = 5;
        PlayerInput playerInput = new PlayerInput(List.of("lee", "hong", "seob"), retry);

        assertThat(playerInput.getRetry()).isEqualTo(retry);
    }
}
