package org.gonza.javaplayground.game.car;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarTest {
    private static final String CAR_NAME = "car1";

    @Test
    public void 차량은_이름을_가지고_있다() {
        Car sut = new Car(CAR_NAME);
        assertEquals(CAR_NAME, sut.getName());
    }

    @Test
    public void 차량의_이동거리를_알_수_있다() {
        Car sut = new Car(CAR_NAME);
        Integer distance = sut.move();
        assertEquals(1, distance);
    }
}
