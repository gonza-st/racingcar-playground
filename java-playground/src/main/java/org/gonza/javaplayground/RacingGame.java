package org.gonza.javaplayground;

public class RacingGame {
    private Boolean isPlaying;

    private String carNames;

    private Integer racingCount;

    public RacingGame() {
        this.isPlaying = false;
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
