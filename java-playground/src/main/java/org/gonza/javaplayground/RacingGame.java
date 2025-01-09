package org.gonza.javaplayground;

import org.gonza.javaplayground.rule.GameRule;

public class RacingGame {
    private GameRule rule;

    private Boolean isPlaying;

    private String carNames;

    private Integer racingCount;

    public RacingGame(GameRule rule) {
        this.isPlaying = false;
        this.rule = rule;
    }

    public void startGame() {
        this.isPlaying = true;
    }

    public Boolean finishGame() {
        return this.isPlaying = false;
    }

    public void assignCarName(String carName) {
        this.carNames = carName;
    }

    public void assignRacingCount(Integer racingCount) {
        this.racingCount = racingCount;
    }

    public void race() {
        this.racingCount--;
    }
}
