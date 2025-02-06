package org.gonza.javaplayground.service;

import org.gonza.javaplayground.view.Printer;

public class RacingGameRunner {
    private final RacingGame racingGame;
    private final int tryCount;
    private final Printer printer;

    public RacingGameRunner(RacingGame racingGame, int tryCount, Printer printer) {
        this.racingGame = racingGame;
        this.tryCount = tryCount;
        this.printer = printer;
    }

    public void run() {
        playRounds();
        announceWinners();
    }

    private void playRounds() {
        for (int i = 0; i < tryCount; i++) {
            playSingleRound();
        }
    }

    private void playSingleRound() {
        racingGame.play();
        printer.printGameStatus(racingGame.getCarNames(), racingGame.getCarPositions());
    }

    private void announceWinners() {
        printer.printWinners(racingGame.winnerNames());
    }
}
