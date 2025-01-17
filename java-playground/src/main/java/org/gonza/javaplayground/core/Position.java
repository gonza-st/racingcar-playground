package org.gonza.javaplayground.core;

import java.util.List;

public class Position {
    public static final int CONDITION_MINIMUM_NUMBER_FOR_MOVING_FORWARD = 4;
    private int distance;

    public Position() {
        this.distance = 0;
    }

    public int getDistance() {
        return distance;
    }

    public void increase(int number) {
        if (number >= CONDITION_MINIMUM_NUMBER_FOR_MOVING_FORWARD) {
            this.distance++;
        }
    }

    public static Position winnerPosition(List<Position> positions) {
        Position winner = positions.get(0);

        for (Position position : positions) {
            winner = compareWinner(winner, position);
        }

        return winner;
    }

    private static Position compareWinner(Position origin, Position compare) {
        if (compare.distance > origin.distance) {
            origin = compare;
        }
        return origin;
    }
}
