package org.gonza.javaplayground.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class RacingGameTest {

    private RacingGame racingGame;

    @BeforeEach
    void setUp() {
        List<String> carNames = List.of("lee", "hong", "seob");
        racingGame = new RacingGame(carNames);
        ;
    }

    @Test
    @DisplayName("레이싱 게임을 만들 수 있다.")
    void createRacingGameSuccess() throws Exception {
        assertThat(racingGame.getCarNames().size()).isEqualTo(3);
        assertAll("입력한 닉네임이 잘 배정된다.",
                () -> assertThat(racingGame.getCarNames().get(0)).isEqualTo("lee"),
                () -> assertThat(racingGame.getCarNames().get(1)).isEqualTo("hong"),
                () -> assertThat(racingGame.getCarNames().get(2)).isEqualTo("seob")
        );
        assertAll("모든 자동차의 초기 위치는 0이어야 한다",
                () -> racingGame.getCarPositions().forEach(car ->
                        assertThat(car.getDistance()).isEqualTo(0))
        );
    }

    @Test
    @DisplayName("게임을 시작할 수 있다.")
    void playingGameSuccessTest() throws Exception {
        racingGame.play();
    }

}
