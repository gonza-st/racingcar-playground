package org.gonza.javaplayground.domain;

public class Car {
    private String name;
    private Integer location;

    public static final int THRESHOLD_FOR_MOVING_FORWARD = 4;

    public Car(String name) {
        this.name = name;
        this.location = 1;
    }

    public Integer moveForward() {
        this.location = this.location + 1;
        return this.location;
    }

    public static Boolean isPossibleMovingForward(int n) {
        boolean isPossible = n >= THRESHOLD_FOR_MOVING_FORWARD;
        return isPossible;
    }

    public String getName() {
        return name;
    }

    public Integer getLocation() {
        return location;
    }
}
