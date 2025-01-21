package org.gonza.javaplayground.game.round;

public class RacingRound {
    private static final Integer MIN_ROUND = 0;

    private Integer round;

    public RacingRound(Integer round) {
        if (round <= 0) {
            throw new IllegalArgumentException("should be positive integer");
        }

        this.round = round;
    }

    public Boolean isAvailable() {
        return round > MIN_ROUND;
    }

    public void consume() {
        this.round -= 1;
    }
}
