package org.gonza.javaplayground.game.car;

public class Car {
    private final CarName name;

    public Car(String name) {
        this.name = new CarName(name);
    }

    public String getName() {
        return name.getValue();
    }

    public Integer move() {
        return 1;
    }
}
