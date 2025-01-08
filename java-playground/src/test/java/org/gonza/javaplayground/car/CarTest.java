package org.gonza.javaplayground.car;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CarTest {
    @Test
    void Car는_name을_가질_수_있다() {
        String name = "NAME";

        Car car = new Car(name);

        assertEquals(car.getName(), name);
    }

    @Test
    void Car는_name이_5자를_초과할_수_있다() {
        String name = "123456";

        assertThrows(IllegalArgumentException.class, () -> new Car(name));
    }

    @Test
    void Car가_생성되면_position은_0이다() {
        Car car = new Car("name");

        assertEquals(car.getPosition(), 0);
    }
}