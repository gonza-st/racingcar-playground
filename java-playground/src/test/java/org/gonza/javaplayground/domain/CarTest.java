package org.gonza.javaplayground.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CarTest {
    String carName = "testCar";

    @Test
    void Car_객체를_생성할_수_있다() {
        Car car = new Car(carName);

        assertEquals(carName, car.getName());
    }

    @Test
    void 생성된_Car_객체의_초기_위치는_1_이다() {
        Car car = new Car(carName);

        assertEquals(1, car.getLocation());
    }

    @Test
    void Car가_앞으로_나아갈_수_있다() {
        Car car = new Car(carName);
        car.moveForward();
        assertEquals(2, car.getLocation());
    }

    @Test
    void Car_이동이_가능한지_확인할_수_있다() {
        assertTrue(Car.isPossibleMovingForward(4));
        assertTrue(Car.isPossibleMovingForward(9));
    }

    @Test
    void Car_이동이_불가능한지_확인할_수_있다() {
        assertEquals(false, Car.isPossibleMovingForward(3));
        assertEquals(false, Car.isPossibleMovingForward(0));
    }
}