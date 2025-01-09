package org.gonza.javaplayground.car;

import java.util.ArrayList;
import java.util.List;

public class Cars {
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
}
