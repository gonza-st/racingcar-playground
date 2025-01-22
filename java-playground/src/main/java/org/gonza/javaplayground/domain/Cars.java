package org.gonza.javaplayground.domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private List<Car> cars;

    public Cars(String carNames) {
        this.cars = new ArrayList<>();
        addCars(carNames);
    }

    public void addCars(String carNames) {
        String[] cars = carNames.split(",");
        for (String carName : cars) {
            if (carName.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없습니다.");
            }
            Car car = new Car(carName);
            this.cars.add(car);
        }
    }

    public List<Car> getCars() {
        return cars;
    }

}
