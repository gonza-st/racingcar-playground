package org.gonza.javaplayground.service;

import org.gonza.javaplayground.core.Position;
import org.gonza.javaplayground.view.ConsolePrinter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingGameRunnerTest {
    private static final List<String> CAR_NAMES = List.of("car1", "car2", "car3");
    private RacingGame game;
    private ConsolePrinter printer;
    private int tryCount;
    private RacingGameRunner runner;

    @BeforeEach
    void setUp() {
        game = new RacingGame(CAR_NAMES);
        printer = new ConsolePrinter();
        tryCount = 4;
        runner = new RacingGameRunner(game, tryCount, printer);
    }

    @Test
    @DisplayName("게임은 지정된 횟수만큼 실행되어야 한다")
    void runGameSpecifiedTimes() {
        // when
        runner.run();

        // then
        List<Position> positions = game.getCarPositions();
        assertThat(positions).allMatch(position ->
                position.getDistance() >= 0 && position.getDistance() <= tryCount
        );
    }

    @Test
    @DisplayName("게임이 끝나면 우승자가 존재해야 한다")
    void shouldHaveWinnersAfterGame() {
        // when
        runner.run();

        // then
        List<String> winners = game.winnerNames();
        assertThat(winners).isNotEmpty();
    }

    @Test
    @DisplayName("게임이 끝난 후 모든 자동차는 최소 0의 위치에 있어야 한다")
    void allCarsShouldHaveValidPositionAfterGame() {
        // when
        runner.run();

        // then
        List<Position> finalPositions = game.getCarPositions();
        assertThat(finalPositions)
                .hasSize(CAR_NAMES.size())
                .allMatch(position -> position.getDistance() >= 0);
    }
}
