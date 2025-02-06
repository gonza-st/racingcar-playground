package org.gonza.javaplayground.core;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    private Car car;

    @BeforeEach
    void setUp() {
        car = new Car("hong");
    }

    @Test
    @DisplayName("자동차가 생성되면 위치가 0이다.")
    void createCarSuccessTest() throws Exception {
        assertThat(car.getNickName()).isEqualTo("hong");
        assertThat(car.getPosition().getDistance()).isEqualTo(0);
    }

    @Test
    @DisplayName("랜덤 숫자가 4이상이면 한 칸 전진한다.")
    void forwardSuccessTest() throws Exception {
        int randomNumber = 4;

        car.forward(randomNumber);

        assertThat(car.getPosition().getDistance()).isEqualTo(1);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3, -3, -2})
    @DisplayName("랜덤 숫자가 4미만이면 제자리이다.")
    void forwardFailTest_randomNumberIsUnder4(int invalidValue) throws Exception {

        car.forward(invalidValue);

        assertThat(car.getPosition().getDistance()).isEqualTo(0);
    }
}
