package org.gonza.javaplayground.game.car;

import java.util.Random;

class CarEngine {
    private static final Integer NOT_ZERO_OFFSET = 1;

    private final Integer maxPower;

    private final Random random;

    public CarEngine(Random random, Integer maxPower) {
        this.random = random;
        this.maxPower = maxPower;
    }

    private Integer getDistance() {
        return this.random.nextInt(maxPower) + NOT_ZERO_OFFSET;
    }

    public Integer cycle() {
        Integer distance = getDistance();
        return distance;
    }
}
