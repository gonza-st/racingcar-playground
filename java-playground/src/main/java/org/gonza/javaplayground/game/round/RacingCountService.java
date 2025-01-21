package org.gonza.javaplayground.game.round;

import org.gonza.javaplayground.game.RacingCountReader;

public class RacingCountService {
    private final RacingCountReader racingCountReader;

    public RacingCountService(RacingCountReader racingCountReader) {
        this.racingCountReader = racingCountReader;
    }

    public RacingCount createRacingCount() {
        Integer count = racingCountReader.getRacingCount();
        return new RacingCount(count);
    }
}
