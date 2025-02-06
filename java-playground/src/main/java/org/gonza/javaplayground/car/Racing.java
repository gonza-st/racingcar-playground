package org.gonza.javaplayground.car;

import java.util.ArrayList;
import java.util.List;

public class Racing {
    public static final int MOVE_CONDITION = 4;

    private List<Car> players = new ArrayList<>();

    public Racing(List<String> names) {
        this.players = convertToCar(names);
    }

    public int countPlayers() {
        return this.players.size();
    }

    private List<Car> convertToCar(List<String> names) {
        return names.stream()
            .map(Car::new)
            .toList();
    }

    private static void moveByNumberCondition(int number, Car car) {
        if (number >= MOVE_CONDITION) {
            car.moveForward();
        }
    }

    public RaceResult race(List<Integer> numbers) {
        for (int i = 0; i < numbers.size(); i++) {
            moveByNumberCondition(numbers.get(i), players.get(i));
        }

        return new RaceResult(players);
    }
}
