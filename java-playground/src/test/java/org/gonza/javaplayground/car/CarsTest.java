package org.gonza.javaplayground.car;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CarsTest {
    private Cars cars;

    @BeforeEach
    void setUp() {
        cars = new Cars();
    }

    @Test
    void Cars는_Car를_생성할_수_있다() {
        List<String> names = new ArrayList<>();
        names.add("test1");
        names.add("test2");
        names.add("test3");

        cars.convertToCar(names);

        assertEquals(names.size(), cars.countCars());
    }

    @Test
    void Car의_이름이_6자를_초과하면_예외가_발생한다() {
        List<String> names = new ArrayList<>();
        names.add("123456");

        assertThrows(IllegalArgumentException.class, () -> cars.convertToCar(names));
    }
}