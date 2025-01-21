package org.gonza.javaplayground.game.car;

public class Car {
    private static final Integer MAX_DISTANCE = 10;
    private static final Integer MIN_DISTANCE = 1;

    private final String name;
    private final CarEngine engine;


    public Car(String name, CarEngine engine) {
        this.name = name;
        this.engine = engine;
    }

    public String getName() {
        return name;
    }

    public Integer move() {
        Integer distance = engine.cycle();

        if (distance > MAX_DISTANCE || distance < MIN_DISTANCE) {
            return move();
        }

        return distance;
    }
}
