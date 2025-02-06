package org.gonza.javaplayground.car;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {
    @Test
    void Car는_name을_가질_수_있다() {
        String name = "NAME";

        Car car = new Car(name);

        assertEquals(car.getName(), name);
    }

    @Test
    void Car는_name이_5자를_초과할_수_없다() {
        String oneLengthName = "1";
        String fiveLengthName = "12345";
        String sixLengthName = "123456";

        assertDoesNotThrow(() -> new Car(oneLengthName));
        assertDoesNotThrow(() -> new Car(fiveLengthName));
        assertThrows(IllegalArgumentException.class, () -> new Car(sixLengthName));
    }

    @Test
    void Car가_생성되면_position은_0이다() {
        Car car = new Car("name");

        assertEquals(car.getPosition(), 0);
    }

    @Test
    void Car는_한_칸_이동할_수_있다() {
        Car car = new Car("name");
        assertEquals(car.getPosition(), 0);

        car.moveForward();

        assertEquals(car.getPosition(), 1);
    }
}