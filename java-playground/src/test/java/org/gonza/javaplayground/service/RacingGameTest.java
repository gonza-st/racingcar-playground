package org.gonza.javaplayground.service;

import org.gonza.javaplayground.core.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingGameTest {

    private RacingGame racingGame;

    @BeforeEach
    void setUp() {
        List<String> carNames = List.of("lee", "hong", "seob");
        racingGame = new RacingGame(carNames);
    }

    @Test
    @DisplayName("레이싱 게임을 생성하면 모든 자동차는 초기 위치 0에서 시작한다")
    void allCarsStartAtPositionZero() {
        List<Position> positions = racingGame.getCarPositions();

        assertThat(positions).allMatch(position -> position.getDistance() == 0);
    }

    @Test
    @DisplayName("자동차들의 이름을 정상적으로 반환한다")
    void getCarNamesCorrectly() {
        List<String> actualNames = racingGame.getCarNames();

        assertThat(actualNames).containsExactly("lee", "hong", "seob");
    }
}
