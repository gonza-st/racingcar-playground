package org.gonza.javaplayground.game.car;

import java.util.List;
import java.util.Random;

public class CarService {
    private final CarNameReader carNameReader;
    private final CarSpec carSpec;

    public CarService(CarNameReader carNameReader, CarSpec carSpec) {
        this.carNameReader = carNameReader;
        this.carSpec = carSpec;
    }

    public List<Car> createCars() {
        List<String> carNamesAsString = carNameReader.getCarNames();
        List<Car> cars = carNamesAsString.stream()
                .peek(this::validateCarName)
                .map((name) -> new Car(name, new Random()))
                .toList();

        return cars;
    }

    private void validateCarName(String name) {
        if (name.length() > carSpec.getMaxDistance()) {
            throw new IllegalArgumentException("Car name is too long");
        }
    }

}
