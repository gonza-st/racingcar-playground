package org.gonza.javaplayground.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CarsTest {

    @Test
    void 문자열로_Car_생성() {
        String input = "CarA,CarB,CarC";
        Cars cars = new Cars(input);
        Assertions.assertEquals(3, cars.getCars().size());
    }

    @Test
    void Car_이름이_5자를_초과하면_예외가_발생한다() {
        String input = "CarA123,CarB,CarC";
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Cars(input);
        });
    }
}
