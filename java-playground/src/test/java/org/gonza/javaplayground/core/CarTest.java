package org.gonza.javaplayground.core;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @Test
    @DisplayName("자동차를 생성할 수 있다.")
    void createCarSuccessTest() throws Exception {
        Car car = new Car(new Nickname("hong"), new Position());

        assertThat(car.getNickName().getName()).isEqualTo("hong");
        assertThat(car.getPosition().getDistance()).isEqualTo(0);
    }

}
