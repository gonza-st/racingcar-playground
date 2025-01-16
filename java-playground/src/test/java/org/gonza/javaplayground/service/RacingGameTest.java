package org.gonza.javaplayground.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class RacingGameTest {

    @Test
    @DisplayName("레이싱 게임을 만들 수 있다.")
    void createRacingGameSuccess() throws Exception {
        List<String> carNames = List.of("lee", "hong", "seob");
        RacingGame racingGame = new RacingGame(carNames);

        assertThat(racingGame.getCars().size()).isEqualTo(3);
        assertAll("입력한 닉네임이 잘 배정된다.",
                () -> assertThat(racingGame.getCars().get(0).getNickName().getName()).isEqualTo("lee"),
                () -> assertThat(racingGame.getCars().get(1).getNickName().getName()).isEqualTo("hong"),
                () -> assertThat(racingGame.getCars().get(2).getNickName().getName()).isEqualTo("seob")
        );
        assertAll("모든 자동차의 초기 위치는 0이어야 한다",
                () -> racingGame.getCars().forEach(car ->
                        assertThat(car.getPosition().getDistance()).isEqualTo(0))
        );
    }

}
