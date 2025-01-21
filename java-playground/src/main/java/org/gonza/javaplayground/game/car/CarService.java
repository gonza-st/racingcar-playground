package org.gonza.javaplayground.game.car;

import java.util.List;

public class CarService {
    private final CarNameReader carNameReader;

    public CarService(CarNameReader carNameReader) {
        this.carNameReader = carNameReader;
    }

    public List<Car> createCars() {
        List<String> carNamesAsString = carNameReader.getCarNames();
        List<Car> cars = carNamesAsString.stream()
                .map(Car::new)
                .toList();

        return cars;
    }
}
