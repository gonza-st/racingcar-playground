package org.gonza.javaplayground.game.count;

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
