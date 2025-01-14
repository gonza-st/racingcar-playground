package org.gonza.javaplayground.core;

class Position {
    public static final int CONDITION_MINIMUM_NUMBER_FOR_MOVING_FORWARD = 4;
    private int distance;

    public Position() {
        this.distance = 0;
    }

    public int getDistance() {
        return distance;
    }

    public void moveForward(int number) {
        if (number >= CONDITION_MINIMUM_NUMBER_FOR_MOVING_FORWARD) {
            this.distance++;
        }
    }
}
