package org.gonza.javaplayground.game.car;

public class CarSpec {
    private final Integer maxNameLength;
    private final Integer maxDistance;

    public CarSpec(Integer maxNameLength, Integer maxDistance) {
        this.maxNameLength = maxNameLength;
        this.maxDistance = maxDistance;
    }

    public Integer getMaxNameLength() {
        return maxNameLength;
    }

    public Integer getMaxDistance() {
        return maxDistance;
    }
}
