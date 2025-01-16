package org.gonza.javaplayground.service;

import org.gonza.javaplayground.core.Car;
import org.gonza.javaplayground.core.Nickname;
import org.gonza.javaplayground.core.Position;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    private List<Car> cars;

    public RacingGame(List<String> carNames) {
        this.cars = prepareCarForRacing(carNames);
    }

    private List<Car> prepareCarForRacing(List<String> carNames) {
        List<Car> cars = new ArrayList<>();

        for (String name : carNames) {
            Car car = new Car(new Nickname(name), new Position());
            cars.add(car);
        }
        return cars;
    }

    public List<Car> getCars() {
        return this.cars;
    }
}
