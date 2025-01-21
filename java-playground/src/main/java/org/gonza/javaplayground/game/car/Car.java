package org.gonza.javaplayground.game.car;

import java.util.Random;

public class Car {
    private static final Integer BOUND = 10;
    private static final Integer OFFSET = 1;
    private static final Integer MAX_DISTANCE = 10;
    private static final Integer MIN_DISTANCE = 1;

    private final CarName name;
    private final Random random;

    public Car(String name, Random random) {
        this.name = new CarName(name);
        this.random = random;
    }

    public String getName() {
        return name.getValue();
    }

    public Integer move() {
        Integer distance = random.nextInt(BOUND) + OFFSET;

        if (distance > MAX_DISTANCE || distance < MIN_DISTANCE) {
            return move();
        }

        return distance;
    }
}
