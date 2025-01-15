package org.gonza.javaplayground.car;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    public static final int MOVE_CONDITION = 4;

    private List<Car> carList = new ArrayList<>();

    public Cars(List<String> names) {
        this.carList = convertToCar(names);
    }

    public int countCars() {
        return this.carList.size();
    }

    private List<Car> convertToCar(List<String> names) {
        return names.stream()
            .map(Car::new)
            .toList();
    }

    private List<Car> highestPositionsCar() {
        int highestPosition = this.carList.stream()
                .map(Car::getPosition)
                .sorted()
                .toList()
                .getFirst();
        return this.carList.stream()
                .filter(car -> car.getPosition() == highestPosition)
                .toList();
    }

    private static void moveByNumberCondition(int number, Car car) {
        if (number >= MOVE_CONDITION) {
            car.move();
        }
    }

    public RaceResult race(List<Integer> numbers) {
        for (int i = 0; i < numbers.size(); i++) {
            moveByNumberCondition(numbers.get(i), carList.get(i));
        }

        List<Car> highestPositionsCarList = highestPositionsCar();

        return new RaceResult(highestPositionsCarList);
    }
}
