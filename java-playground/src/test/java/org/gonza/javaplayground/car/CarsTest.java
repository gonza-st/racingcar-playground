package org.gonza.javaplayground.car;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;

import org.junit.jupiter.api.Test;

class CarsTest {
    @Test
    void Cars는_Car를_생성할_수_있다() {
        List<String> names = List.of("test1", "test2", "test3");

        Cars cars = new Cars(names);

        assertEquals(names.size(), cars.countCars());
    }

    @Test
    void Car의_이름이_6자를_초과하면_예외가_발생한다() {
        List<String> names = List.of("123456");

        assertThrows(IllegalArgumentException.class, () -> new Cars(names));
    }

    @Test
    void Cars의_Car는_숫자_4_이상이면_이동한다() {
        Cars cars = new Cars(List.of("test1"));

        cars.moveBy(List.of(4));

        assertEquals(1, getHighestPosition(cars));
    }

    @Test
    void Cars의_Car는_숫자_4_미만이면_이동하지_않는다() {
        Cars cars = new Cars(List.of("test1"));
        assertEquals(0, getHighestPosition(cars));

        cars.moveBy(List.of(3));

        assertEquals(0, getHighestPosition(cars));
    }

    private int getHighestPosition(Cars cars) {
        return cars.highestPositionsCar().getFirst().getPosition();
    }
}