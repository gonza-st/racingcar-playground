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
                .map(this::createCar)
                .toList();

        return cars;
    }

    private void validateCarName(String name) {
        if (name.length() > carSpec.getMaxDistance()) {
            throw new IllegalArgumentException("Car name is too long");
        }
    }

    private Car createCar(String carName) {
        Random random = new Random();
        Integer engineSpec = carSpec.getMaxDistance();
        CarEngine engine = new CarEngine(random, engineSpec);

        return new Car(carName, engine);
    }
}
