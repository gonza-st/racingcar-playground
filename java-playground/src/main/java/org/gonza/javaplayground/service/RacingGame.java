package org.gonza.javaplayground.service;

import org.gonza.javaplayground.core.Car;
import org.gonza.javaplayground.core.Nickname;
import org.gonza.javaplayground.core.Position;
import org.gonza.javaplayground.util.NumberGenerator;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class RacingGame {

    private List<Car> cars;

    public RacingGame(List<String> carNames) {
        this.cars = createCars(carNames);
    }

    public List<String> getCarNames() {
        return cars.stream()
                .map(Car::getNickName)
                .collect(toList());
    }

    public List<Position> getCarPositions() {
        return cars.stream()
                .map(Car::getPosition)
                .collect(toList());
    }

    public void play() {
        cars.forEach(car -> car.forward(NumberGenerator.generateRandomNumber()));
    }

    public List<String> winnerNames() {
        int maxPosition = cars.stream()
                .mapToInt(car -> car.getPosition().getDistance())
                .max()
                .orElse(0);

        return cars.stream()
                .filter(car -> car.getPosition().getDistance() == maxPosition)
                .map(Car::getNickName)
                .collect(toList());
    }

    private List<Car> createCars(List<String> carNames) {
        return carNames.stream()
                .map(name -> new Car(new Nickname(name), new Position()))
                .collect(toList());
    }
}
