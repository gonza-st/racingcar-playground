package org.gonza.javaplayground.service;

import org.gonza.javaplayground.core.Car;
import org.gonza.javaplayground.core.Nickname;
import org.gonza.javaplayground.core.Position;
import org.gonza.javaplayground.util.NumberGenerator;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class RacingGame {

    private List<Car> cars;

    public RacingGame(List<String> carNames) {
        this.cars = initForRacing(carNames);
    }

    private List<Car> initForRacing(List<String> carNames) {
        List<Car> cars = new ArrayList<>();

        for (String name : carNames) {
            Car car = new Car(new Nickname(name), new Position());
            cars.add(car);
        }
        return cars;
    }

    public List<String> getCarNames() {
        return this.cars.stream().map(Car::getNickName).collect(toList());
    }

    public List<Position> getCarPositions() {
        return cars.stream().map(Car::getPosition).collect(toList());
    }

    public void play() {
        for (Car car : cars) {
            car.forward(NumberGenerator.generateRandomNumber());
        }
    }

    public List<String> winnerNames() {
        List<String> names = new ArrayList<>();
        final Position winner = Position.winnerPosition(getCarPositions());

        for (Car car : cars) {
            addWinnerCarName(names, winner, car);
        }

        return names;
    }

    private static void addWinnerCarName(List<String> names, Position winner, Car car) {
        if (car.isWinner(winner)) {
            names.add(car.getNickName());
        }
    }
}
