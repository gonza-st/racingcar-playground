package org.gonza.javaplayground.car;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    public static final int MOVE_CONDITION = 4;
    private final List<Car> carList = new ArrayList<>();

    public int countCars() {
        return this.carList.size();
    }

    public void convertToCar(List<String> names) {
        names.forEach(carName -> {
            Car car = new Car(carName);
            this.carList.add(car);
        });
    }

    // FIXME: 로직 개선 필요
    public List<Car> highestPositionsCar() {
        int highestPosition = this.carList.stream()
                .map(Car::getPosition)
                .sorted()
                .toList()
                .getFirst();
        return this.carList.stream()
                .filter(car -> car.getPosition() == highestPosition)
                .toList();
    }

    public void moveBy(List<Integer> numbers) {
        for (int i = 0; i < carList.size(); i++) {
            Car car = carList.get(i);
            int number = numbers.get(i);
            moveByNumberCondition(number, car);
        }
    }

    private static void moveByNumberCondition(int number, Car car) {
        if (number >= MOVE_CONDITION) {
            car.move();
        }
    }
}
